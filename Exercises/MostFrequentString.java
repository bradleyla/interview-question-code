package InterviewPrep2;

import java.util.*;

public class MostFrequentString {
    public static void main(String[] args) {
        String[] array = {"abba", "hullabaloo", "woot", "hullabaloo", "yodel", "yogi"};
        String[] array2 = {"abba", "abba", "yodel", "yodel", "bank", "cherry"};
        System.out.println(mostFrequent(array));
        System.out.println(mostFrequent(array2));
    }

    public static String mostFrequent(String[] array) {
        Map<String, Integer> frequencies = new HashMap<>();

        // inputting all array strings in HashMap with frequency as value
        for(String string : array) {
            if(!frequencies.containsKey(string)) {
                frequencies.put(string, 1);
            } else {
                frequencies.replace(string, frequencies.get(string) + 1);
            }
        }

        // create a list of entries from frequency map to sort them
        List<Map.Entry<String, Integer>> frequencyList = new ArrayList<>(frequencies.entrySet());

//        System.out.println(frequencyList);

        // sort frequency list based on value first (reverseOrder() since higher values first), then
        // sort by alphabetical key if values are identical
        frequencyList.sort(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey()));

//        System.out.println(frequencyList);

        // return highest frequency string that's alphabetically first
        return frequencyList.get(0).getKey();
    }
}
