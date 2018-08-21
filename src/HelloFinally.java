import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 1/21/16.
 */
public class HelloFinally {
    public static void main(String[] strings) {
        System.out.println("new Index:" + newIndex(8));
        System.out.println("new Index:" + newIndex(9));
        System.out.println("new Index:" + newIndex(10));
        System.out.println("new Index:" + newIndex(11));
        System.out.println("new Index:" + newIndex(12));
    }

    public static int newIndex(int index) {
        index -= index & (-index);
        return index;
    }

}
