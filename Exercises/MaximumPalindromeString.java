package InterviewPrep2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumPalindromeString {
    public static void main(String[] args) {
        String input = "YABCCBAZ";
        String input2 = "ABC";
        System.out.println(findPalindrome(input));
        System.out.println(findPalindrome(input2));
    }

    public static String findPalindrome(String input) {
        List<String> palindromeSubstrings = new ArrayList<>();
        int size = input.length();

        // checks all substrings
        for(int i = 0; i < size; i++) {
            for(int j = i; j < size; j++) {
                int mismatch = 0;
                // only inputs substrings if they're at least one char long
                if(isPalindrome(input, i, j, mismatch) && j != i) {
                    palindromeSubstrings.add(input.substring(i, j + 1));
                }
            }
        }
        // sorts by max length descending, then lexicographically smallest (ascending) for equal
        // length strings
        palindromeSubstrings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int lengthCompare = Integer.compare(o2.length(), o1.length());
                if(lengthCompare != 0) {
                    return lengthCompare;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        if(palindromeSubstrings.isEmpty())
            return "None";
        else
            return palindromeSubstrings.get(0);
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
