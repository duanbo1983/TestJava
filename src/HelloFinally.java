import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 1/21/16.
 */
public class HelloFinally {
    public static void main(String[] strings) {
        List<String> list = new ArrayList<>(8);
        list.add("dd");
        list.add("dd");

        System.out.println(list.size());

        System.out.println(getL(null));
    }

    public static int getL(String s) {
        try {
            return s.length();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("---");
            return 0;
        } finally {
            System.out.println("Finish --");
        }
    }
}
