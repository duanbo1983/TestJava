import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bod on 9/16/15.
 */
public class TestCounter {

    int count = 0;

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] strings) {

        TestCounter testCounter = new TestCounter();

        testCounter.start();
    }

    TestCounter() {

    }

    void start() {
        final Object mutex = new Object();

        for (int i = 0 ; i < 100; i ++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    while (count < 10000) {
//                        synchronized (mutex) {
//                            System.out.println(count ++);
//                        }
//                    }

                    while (atomicInteger.getAndIncrement() < 10000) { }
                }
            });
            thread.start();
        }
    }
}
