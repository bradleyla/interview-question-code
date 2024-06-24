package InterviewPrep2;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String input1 = "abc";
        String input2 = "aaa";
        String input3 = "aba";
        System.out.println(palindromeCount(input1));
        System.out.println(palindromeCount(input2));
        System.out.println(palindromeCount(input3));
    }

    public static int palindromeCount(String input) {
        int count = 0;
        int size = input.length();

        // checks all substrings
        for(int i = 0; i < size; i++) {
            for(int j = i; j < size; j++) {
                int mismatch = 0;
                if(isPalindrome(input, i, j, mismatch)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPalindrome(String input, int i, int j, int mismatch) {

        // once two pointers meet in the middle, return true or false based on mismatching characters
        if(i > j) {
            return mismatch == 0;
        }

        // if the characters being checked aren't the same, then increment mismatch if they aren't equal
        if(i != j) {
            if(input.charAt(i) != input.charAt(j)) {
                mismatch++;
            }
        }

        // check next two characters in the substring, going towards the middle
        return isPalindrome(input, i + 1, j - 1, mismatch);
    }
}
