package InterviewPrep2;

import java.util.ArrayList;
import java.util.List;

public class ChangeCents {
    public static void main(String[] args) {
        int[] coins1 = {25, 10, 5};
        int[] coins2 = {9, 6, 5, 1};
        System.out.println(makeChange(coins1, 30));
        System.out.println(makeChange(coins2, 11));
    }

    public static int makeChange(int[] coins, int amount) {
        int n = coins.length;
        int currAmount;
        int minLength = Integer.MAX_VALUE;
        List<List<Integer>> possibleSols = new ArrayList<>();

        // finds all possible solutions that match amount
        for(int i = 0; i < n; i++) {
            currAmount = coins[i];
            List<Integer> currentSol = new ArrayList<>();
            currentSol.add(coins[i]);

            // updates currAmount and currentSol if two values are less than or equal to target amount,
            // and adds solution to possible solutions if target amount is reached exactly
            for(int j = i; j < n; j++) {
                if(currAmount + coins[j] < amount) {
                    currentSol.add(coins[j]);
                    currAmount += coins[j];
                } else if(currAmount + coins[j] == amount) {
                    currentSol.add(coins[j]);
                    currAmount += coins[j];
                    possibleSols.add(currentSol);
                }
            }
        }

        // finds solution in all possible solutions with the least amount of values and returns that;
        // if there are no solutions returns -1
        if(!possibleSols.isEmpty()) {
            for (List<Integer> sol : possibleSols) {
                if (sol.size() < minLength) {
                    minLength = sol.size();
                }
            }
            return minLength;
        } else {
            return -1;
        }
    }
}
