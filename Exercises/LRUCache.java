package InterviewPrep2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        super.put(key, value);
        System.out.printf("Key %s and value %s are inserted/updated into LRU cache.", key, value);
        System.out.println();
    }

    public static void main(String[] args) {
        int capacity = 2;
        String regex = "\\w+ \\d+( \\d+)?";
        LRUCache lruCache = new LRUCache(capacity);
        String queries = "SET 1 2 SET 2 3 SET 1 5 SET 4 5 SET 6 7 GET 4 SET 1 2 GET 3";
        Matcher matcher = Pattern.compile(regex).matcher(queries);
        List<String> queriesList = new ArrayList<>();

        while(matcher.find()) {
            String match = matcher.group().trim();
            queriesList.add(match);
        }

        for(String query: queriesList) {
            String[] queryArray = query.split(" ");
            if(queryArray[0].equals("SET")) {
                lruCache.set(Integer.parseInt(queryArray[1]), Integer.parseInt(queryArray[2]));
            } else if(queryArray[0].equals("GET")) {
                System.out.println(lruCache.get(Integer.parseInt(queryArray[1])));
            } else {
                System.out.printf("ERROR: query %s is not SET or GET.", queryArray[0]);
                System.out.println();
            }
        }
    }


}
