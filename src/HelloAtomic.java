import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by bod on 9/14/15.
 */
public class HelloAtomic {

    public static void main(String[] strings) {

        AtomicBoolean testBoolean = new AtomicBoolean(false);

        System.out.println("isSet : " + testBoolean.compareAndSet(false, true));
        System.out.println("curr  : " + testBoolean.get());
        System.out.println("isSet : " + testBoolean.compareAndSet(false, false));
        System.out.println("curr  : " + testBoolean.get());
        System.out.println("isSet : " + testBoolean.compareAndSet(true, true));
        System.out.println("curr  : " + testBoolean.get());
        System.out.println("isSet : " + testBoolean.compareAndSet(true, false));
        System.out.println("curr  : " + testBoolean.get());

        AtomicReference<String> stringAtomicReference = new AtomicReference<>();

        stringAtomicReference.set(null);
        String test = stringAtomicReference.get();
        String testNull = "null";
        System.out.println(stringAtomicReference.get());

        stringAtomicReference.set("abc");
        System.out.println(stringAtomicReference.get());

        stringAtomicReference.set(null);
        System.out.println(stringAtomicReference.get());
        stringAtomicReference = null;

        List<Integer> fullList = new ArrayList<>();
        fullList.add(0);
        fullList.add(1);
        fullList.add(2);
        fullList.add(3);
        fullList.add(4);
        fullList.add(5);

        Integer[] messages;
        int max = 6;
        List<Integer> subList = fullList;
        int size = fullList.size();
        if (size > max) {
            subList = fullList.subList(0, max);
        }
        messages = subList.toArray(new Integer[subList.size()]);
        subList.clear();
        System.out.println(Arrays.toString(messages));
        System.out.println(fullList.size());
    }
}
