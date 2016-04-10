import java.net.MalformedURLException;
import java.net.URL;
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

        System.out.println(String.format("Error adding ground overlay", "GroundOverlayOptions was: Position: 37.775812, -122.418047 [0], Image: present, Width: 4, Height: 4, Map zoom level: 18.0, Map target: 37.775702077835085, -122.4182530492544 [0]"));


        URL url = null;
        try {
            url = new URL("/abc");
            System.out.println(url);
        }
        catch (MalformedURLException e) {
            System.out.println(e);
        }

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
