package InterviewPrep2;

public class ZeroSumSubArray {
    public static void main(String[] args) {
        int[] array = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(zeroSumSubArrayLength(array));
    }

    public static int zeroSumSubArrayLength(int[] array) {
        int maxLengthSoFar = 0;
        int currentLength;
        int sum;
        for(int i = 0; i < array.length; i++) {
            currentLength = 0;
            sum = 0;
            for(int j = i; j < array.length; j++) {
                sum += array[j];
                currentLength++;
                if(sum == 0 && currentLength > maxLengthSoFar) {
                    maxLengthSoFar = currentLength;
                }
            }
        }
        return maxLengthSoFar;
    }
}
