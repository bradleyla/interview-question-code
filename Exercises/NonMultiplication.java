package InterviewPrep2;

public class NonMultiplication {
    public static void main(String[] args) {
        System.out.println(nonMultiply(9, 8));
    }

    public static int nonMultiply(int first, int second) {
        int multiplySum = first;
        for(int i = 1; i < second; i++) {
            multiplySum += first;
        }
        return multiplySum;
    }
}
