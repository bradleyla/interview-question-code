package InterviewPrep2;

public class MaximumXOR {
    public static void main(String[] args) {
        int[] array = {25, 10, 2, 8, 5, 3};
        System.out.println(maxXOR(array));
    }

    public static int maxXOR(int[] array) {
        int maxXOR = 0;

        for(int i = 0; i < array.length; i++) {
            for(int j = i; j < array.length; j++) {
                int currXOR = array[i] ^ array[j];
                if(currXOR > maxXOR) {
                    maxXOR = currXOR;
                }
            }
        }
        return maxXOR;
    }
}
