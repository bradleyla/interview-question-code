package InterviewPrep2;

import java.util.*;


/*
Implement a custom HashSet that allows you to limit the number of elements it can hold. Once
the element is reached, the oldest element should be automatically removed when a new element
is added.
 */
public class LimitedHashSet<E> extends LinkedHashSet<E> {

    private final int capacity;
    private final Queue<E> orderQueue;
    public LimitedHashSet(int capacity) {
        super();
        this.capacity = capacity;
        this.orderQueue = new LinkedList<>();
    }

    @Override
    public boolean add(E e) {
        if(this.size() >= capacity) {
            E oldest = orderQueue.poll();
            this.remove(oldest);
        }
        if(super.add(e)) {
            orderQueue.add(e);
            return true;
        }
        return false;
    }



}
