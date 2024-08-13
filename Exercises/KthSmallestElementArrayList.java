package InterviewPrep2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/*
How would you find the kth smallest element from an ArrayList without modifying the original list?
 */
public class KthSmallestElementArrayList {
    public static void main(String[] args) {
       List<Integer> numList = new ArrayList<>();
        numList.add(4);
        numList.add(3);
        numList.add(7);
        numList.add(14);
        numList.add(9);
        System.out.println(kthSmallest(numList, 2));
    }

    public static Integer kthSmallest(List<Integer> numList, int k) {
        //custom Comparator added that prioritizes values in descending order
        PriorityQueue<Integer> intQueue = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < numList.size(); i++) {
            intQueue.offer(numList.get(i));

            // when PriorityQueue is larger than k size, remove largest element
            if(intQueue.size() > k) {
                intQueue.poll();
            }
        }

        // return the kth smallest element (largest element in k size PriorityQueue)
        return intQueue.peek();
    }

}
