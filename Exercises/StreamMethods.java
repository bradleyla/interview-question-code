package InterviewPrep2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethods {
    private static long counter;
    public static void main(String[] args) {
        // Streaming a Collection object
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        // Streaming a hardcoded collection of objects
        Stream<String> arrayStream = Stream.of("d", "e", "f");

        // Creating a stream via StreamBuilder
        Stream<String> streamBuilder = Stream.<String>builder().add("g").add("h").add("i").build();

//        // Generate() function; runs infinitely unless capped by a limit() function; supplier functional interface
//        int[] fibs = {0, 1};
//        Stream<Integer> fibonacci = Stream.generate(() -> {
//            int result = fibs[1];
//            int fib3 = fibs[0] + fibs[1];
//            fibs[0] = fibs[1];
//            fibs[1] = fib3;
//            return result;
//        }).limit(10);
//        System.out.println(fibonacci.toList());

//        // Iterate() function, runs infinitely unless capped by limit() function
//        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
//        System.out.println(streamIterated.toList());

          // Creating an IntStream via range() method
//        IntStream intStream = IntStream.range(1, 3);
//        System.out.println(intStream);
//
          // filter() method - filters Stream to only include values that match a rule
//        arrayStream = arrayStream.filter(element -> element.contains("d"));
//        // terminal operation, arrayStream will not work after this
//        Optional<String> anyElement = arrayStream.findAny();
////        System.out.println(anyElement);
          // this will throw an IllegalStateException because arrayStream is closed
////        Optional<String> firstElement = arrayStream.findFirst();
//
          // Easier way to run multiple terminal operations; have a separate collection
          // and run multiple streams on it
//        List<String> builderList = streamBuilder.filter(element -> element.contains("h"))
//                .toList();
//        anyElement = builderList.stream().findAny();
//        Optional<String> firstElement = builderList.stream().findFirst();
//        System.out.println(anyElement);
//        System.out.println(firstElement);

//
          // skip() method - skips specified number of elements in a stream
//        Stream<String> skippedStream = Stream.of("ab", "bc", "cd").skip(2);
//        System.out.println(skippedStream.toList());
//
        List<String> list = Arrays.asList("first", "second", "third");
//
          // combination of operations:
          // stream() - converts list elements into a stream
          // skip() - skips first element of the stream
          // map() - takes a lambda / method reference as a function or operator interface and returns a new value
          // sorted() - sorts remaining elements by natural / ascending order
          // count() - terminal operation that returns the number of elements left in the stream
//        long size = list.stream().skip(1)
//                .map(String::length).sorted().count();
//        System.out.println(size);
//
          // intermediate operations are lazy - filter() is never called here
          // because there's no terminal operation; thus counter = 0 at the end
//        Stream<String> listStream = list.stream().filter(element -> {
//            wasCalled();
//            return element.contains("d");
//        });
//        System.out.println(counter);
//
          // filter() is called twice and map() called once; 1st element
          // doesn't match filter so pipeline doesn't progress further, but
          // 2nd element matches filter and calls map(). Since findFirst() only
          // needs one element, 3rd element is not used at all.
//        Optional<String> firstString = list.stream().filter(element -> {
//            wasCalled();
//            System.out.println("filter() is called");
//            return element.contains("d");
//        }).map(element -> {
//            System.out.println("map() is called");
//            return element.toUpperCase();
//        }).findFirst();
//        System.out.println(counter);
//
          // map() is called 3 times, but 2 elements are discarded, which wastes memory
          // counter = 3
//        counter = 0;
//        size = list.stream().map(element -> {
//            wasCalled();
//            return element.substring(0, 2);
//        }).skip(2).count();
//        System.out.println(counter);
//
          // map() is only called once because skip() comes first
          // counter = 1
//        counter = 0;
//        size = list.stream().skip(2).map(element -> {
//            wasCalled();
//            return element.substring(0, 2);
//        }).count();
//        System.out.println(counter);
//
          // reduce() - aggregates all elements in a stream with an optional
          // initial "identity" as a base value
//        int reducedTwo =
//                IntStream.range(1, 4).reduce(10, Integer::sum);
//        System.out.println(reducedTwo);
//
          // reduce value with multiple aggregates; second one will only run
          // under a parallelStream(), where each element aggregate gets its own
          // process and then combiner combines all the aggregates together (aggregate of aggregate)
//        int reducedParallel = Arrays.asList(1, 2, 3).stream()
//                .reduce(10, (a, b) -> a + b);
////                        (a, b) -> {
////                    System.out.println("combiner was called");
//////                    return a + b;
////                    return a;
////                });
//        System.out.println(reducedParallel);

        List<String> productList = Arrays.asList("POTATOES", "ORANGE", "LEMON", "BREAD");
        List<Integer> priceList = Arrays.asList(55, 43, 8, 10);

        // collect() - converting a series of stream values to a collection
//        List<String> collectorCollection = productList.stream().map(String::toLowerCase).collect(Collectors.toList());
//        System.out.println(collectorCollection);

        // Collectors.joining() - reduce an entire list to a single element
//        String listToString = productList.stream().map(String::toLowerCase)
//                .collect(Collectors.joining(", ", "[", "]"));
//        System.out.println(listToString);

        // average value for all numeric elements of stream
        double averagePrice = priceList.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(averagePrice);

        // sum of all numeric elements of stream
        int summingPrice = priceList.stream().mapToInt(Integer::intValue).sum();
        System.out.println(summingPrice);

        // create a statistical report of all integer calculations (count, sum, min, average, max)
        IntSummaryStatistics statistics = priceList.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(statistics);

        // creating a custom collector using Collector.of() for collect() method
        Collector<String, ?, LinkedList<String>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<String> productLinkedList = productList.stream().collect(toLinkedList);

        // Catching Exceptions in Streams
        // 1. try-catch block - works and is obvious, but is anti-pattern because *it*
        // dictates what happens to Stream elements instead of the result of the previous
        // operation in the Stream

        List<Path> pathList = List.of(Path.of("Exercises/StreamMethods.java"), Path.of("Exercises/ImplementRunnable.java"), Path.of("Exercises/MaxMeanAverage"));
        List<String> productContents = pathList.stream()
                .map(path -> {
                    try {
                        return Files.readString(path);
                    } catch (IOException e) {
                        return null;
                    }
                }).filter(Objects::nonNull).toList();
        System.out.println(productContents);

        // 2. Extract try-catch in a separate method and return default value when exception occurs

        List<String> fileContents = pathList.stream()
                .map(StreamMethods::safeReadString)
                .filter(Objects::nonNull).toList();
        System.out.println(fileContents);

        // 3. Return Optional instance from separate method to prevent NullPointerException
        // further down the call stack

        List<String> fileContentsList = pathList.stream()
                .map(StreamMethods::readString).filter(Optional::isEmpty).map(Optional::get).toList();
        System.out.println(fileContentsList);

    }

    private static void wasCalled() {
        counter++;
    }

    private static String safeReadString(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            return null;
        }
    }

    private static Optional<String> readString(Path path) {
        try {
            return Optional.of(Files.readString(path));
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
