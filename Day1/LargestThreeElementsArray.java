package Day1;

import java.util.Arrays;

public class LargestThreeElementsArray {
    public static void main(String[] args) {
        int[] array = {4, 46, 347, 24, 28, 5959, 14, 856};
        System.out.println(Arrays.toString(largestThreeElements(array)));
    }

    public static int[] largestThreeElements(int[] array) {
        int[] largestThreeArray = new int[3];
        int max = -1;
        int secondMax = -1;
        int thirdMax = -1;

        // If element is higher than current max, update all three largest elements to new values.
        // If element is higher than second max but not max, update second and third largest.
        // If element is higher than third max but not second max or max, update third largest.
        // For all code flows, update in order of third > second > max, and discard previous third largest element.
        for(int element : array) {
            if(element > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = element;
            } else if(element > secondMax) {
                thirdMax = secondMax;
                secondMax = element;
            } else if(element > thirdMax) {
                thirdMax = element;
            }
        }
        largestThreeArray[0] = max;
        largestThreeArray[1] = secondMax;
        largestThreeArray[2] = thirdMax;

        return largestThreeArray;
    }
}
