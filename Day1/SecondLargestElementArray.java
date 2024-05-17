package Day1;

public class SecondLargestElementArray {
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 7, 15, 17, 4, 2};
        System.out.println(secondGreatest(array));
    }

    public static int secondGreatest(int[] array) {
        int max = -1;
        int secondMax = -1;

        // If element is higher than current max, update second max to current max,
        // and current max to new higher element. If element is higher than second max but
        // not current max, update second max only to new higher element.
        for(int element : array) {
            if(element > max) {
                secondMax = max;
                max = element;
            } else if(element > secondMax) {
                secondMax = element;
            }
        }
        return secondMax;
    }
}
