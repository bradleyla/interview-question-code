package InterviewPrep2;

public class MaxOnesInRows {
    public static void main(String[] args) {
        int[][] array = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println(maxOnes(array));
    }

    public static int maxOnes(int[][] array) {
        int maxRow = 0;
        int maxOnesInRow = 0;
        int onesInRow;
        for(int i = 0; i < array.length; i++) {
            onesInRow = 0;
            for(int j = 0; j < array[0].length; j++) {
                if(array[i][j] == 1) {
                    onesInRow++;
                }
            }
            if(onesInRow > maxOnesInRow) {
                maxOnesInRow = onesInRow;
                maxRow = i;
            }
        }
        return maxRow;
    }
}
