package InterviewPrep2;

public class MaxMeanAverage {
    public static void main(String[] args) {
        int[] array = {6, 8, -3, -30, 42, 56};
        System.out.println(maxMeanAverage(array, 3));
    }

    public static int maxMeanAverage(int[] array, int n) {
        // Modified Kadane's Algorithm
        int maxEndingHere = 0;

        // set up initial sum separately so sliding window will work
        for(int i = 0; i < n; i++) {
            maxEndingHere += array[i];
        }

        int maxSoFar = maxEndingHere;

        // sliding window and Kadane's algorithm
        for(int i = n; i < array.length; i++) {
            maxEndingHere += array[i] - array[i - n];
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }

        // return average of max sum, rounded up
        return (int) Math.ceil((double) maxSoFar / n);
    }
}
