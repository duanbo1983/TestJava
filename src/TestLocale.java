import java.util.Locale;

/**
 * Created by bod on 2/9/16.
 */
public class TestLocale {

    public static void main(String[] strings) {

        Locale locale = new Locale("ar", "");

        Locale.setDefault(locale);

        System.out.println(Locale.getDefault());

        System.out.println(String.format("%d", 123));
        System.out.println(String.format(locale, "%s", "en_US"));
    }
}
