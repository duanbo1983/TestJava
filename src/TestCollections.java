import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bod on 2/23/16.
 */
public class TestCollections {

    public static void main(String[] strings) {
        final Set<String> mLocationListeners =
                Collections.synchronizedSet(new HashSet<>());

        mLocationListeners.add("aaa");
        mLocationListeners.add("bbb");
        mLocationListeners.add("ccc");
        mLocationListeners.add("ddd");
        mLocationListeners.add("fff");

        final Object o = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("DB-Test thread entered");

                synchronized (o) {
                    try {
                        o.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("DB-Test thread adding");
                mLocationListeners.add("eee");
                System.out.println("DB-Test thread added");
            }
        }).start();

        synchronized (mLocationListeners) {
            for (String listener : mLocationListeners) {
                System.out.println("DB-Test --> start: " + listener);
                synchronized (listener) {
                    try {
                        listener.wait(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("DB-Test --> end: " + listener);
            }
        }
    }
}
