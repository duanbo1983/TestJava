import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bod on 9/22/15.
 */
public class HelloList {

    public static void main(String[] strings) {
        LimitedHashMap<Integer, String> map = new LimitedHashMap<>(3);
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
    }

    private static class LimitedHashMap<K, V> extends LinkedHashMap<K, V> {

        private final int mMaxSize;

        public LimitedHashMap(int maxSize) {
            mMaxSize = maxSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > mMaxSize;
        }
    }
}
