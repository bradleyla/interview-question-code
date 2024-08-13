package InterviewPrep2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/*
How would you remove all occurrences of a specific element from an ArrayList without using any
additional data structures?
 */
public class RemoveSpecificElement {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(3);
        numList.add(6);
        numList.add(8);
        numList.add(3);
        numList.add(13);
        numList.add(8);
        System.out.println(removeElement(numList, 3));
    }

    public static List<Integer> removeElement(List<Integer> numList, Integer element) {
        numList.removeIf(index -> Objects.equals(index, element));
        return numList;
    }
}
