package InterviewPrep2;

public class HappyNumbers {
    public static void main(String[] args) {
        int num = 19;
        System.out.println(isHappy(num));
    }

    public static boolean isHappy(int num) {
        int pointer1 = num;
        int pointer2 = num;

        // must be do-while, otherwise loop gets skipped
        do {
            pointer1 = happySum(pointer1);
            pointer2 = happySum(pointer2);
            pointer2 = happySum(pointer2);
        } while (pointer1 != pointer2);

        return pointer1 == 1;
    }

    public static int happySum(int num) {
        int digit;
        int sum = 0;

        while(num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}
