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
    }
}
