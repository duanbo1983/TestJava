import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 8/16/16.
 */
public class HelloGeneric {

    public static void main(String[] strings) {
        List<Object> list = new ArrayList<>();
        List<? extends String> strList = new ArrayList<>();
        List<? extends Object> wildList = new ArrayList<>();

        wildList = strList;

        //strList.add("");

        //wildList.add("");

        //wildList.add(strList.get(0));
    }

    public static void print() {
        List<? extends String> list = new ArrayList<>();

        for(String o : list) {

        }

        list.add(null);

        List<? super String> listSuper = new ArrayList<>();

        listSuper.add("abc");
    }

    static void embeddedGeneric() {
        List<List<? extends Object>> list = new ArrayList<>();

        List<? extends String> listObj = new ArrayList<>();

        //listObj.add("");

        list.add(listObj);
    }
}
