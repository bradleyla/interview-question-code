package InterviewPrep2;

public class LimitedHashSetTest {
    public static void main(String[] args) {
        LimitedHashSet<Integer> limitedHashSet = new LimitedHashSet<>(3);
        limitedHashSet.add(1);
        limitedHashSet.add(2);
        limitedHashSet.add(3);

        System.out.println("LimitedHashSet before 4: " + limitedHashSet);

        limitedHashSet.add(4);

        System.out.println("LimitedHashSet before 5: " + limitedHashSet);

        limitedHashSet.add(5);

        System.out.println("LimitedHashSet after 5: " + limitedHashSet);
    }
}
