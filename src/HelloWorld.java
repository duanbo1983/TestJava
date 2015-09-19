import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bod on 6/10/15.
 */
public class HelloWorld {

    private static final String RAMEN = "/ramen";
    private static final String PATH = RAMEN + "/recv?uid=%s&seq=%d&sessionid=%s";
    private static final String PARAM_SESSION_ID = "sessionid";

    static Pattern sessionIdPattern = Pattern.compile("(&sessionid=([^&]+)$)|(&sessionid=([^&]+)&.+$)");

    public static void main(String[] strings) {
        System.out.println("HelloWorld");
        String address = "http://upload.wikimedia.org/wikipedia/en/5/59/Kirix-strata-logo-256.png";
        try {
            URL url = new URL(address);
            System.out.println(url.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println(String.valueOf(20));

//        Locale locale = new Locale("ar", "SA");
//
        String path = String.format( PATH, "uuid_uuu", 0, null);
        System.out.println(path);

        // get the supported locales
//        Locale[] locale = Locale.getAvailableLocales();
//        System.out.println("Supported locales: ");
//        for (int i = 0; i < locale.length; i++) {
//            System.out.println(locale[i].getLanguage() + ", " + locale[i].getCountry() + ", "
//                            + locale[i].getVariant() + ", " + locale[i].getDisplayName()
//            );
//
//            String path = String.format(locale[i], PATH, "uuid_uuu", 0, "session_id_xxx");
//
//            if (!path.contains("seq=0")) {
//                System.out.println("------xxxxxxx-------");
//            }
//        }

        int a = 1;
        a += 1 << 10;;
        System.out.println(a);

//        System.out.println(TimeUnit.SECONDS.toMillis(15));
//
//        int a = (int) Long.valueOf("1.0").longValue();
//        System.out.println(a);
//
//        Map<String, Integer> map = new HashMap<String, Integer>();
//
//        for (Integer integer : map.values()) {
//
//        }
//
//        System.out.println(map.size());

        String original_path = "/ramen/recv?uid=51cef997-c3eb-4c33-abd6-195ba39b4b49&seq=0&sessionid=4xZgvXkxxMq2mX5YZS1OlHd5oVVYPXiaLls7SuR588XNt1pRkKPounNwnp0ck6z092NstNpeoh6kr4YXmaMw";
        String original_path_2 = "/ramen/recv?uid=51cef997-c3eb-4c33-abd6-195ba39b4b49&seq=0&sessionid=4xZgvXkxxMq2mX5YZS1OlHd5oVVYPXiaLls7SuR588XNt1pRkKPounNwnp0ck6z092NstNpeoh6kr4YXmaMw&token=847";

//        Pattern MY_PATTERN = Pattern.compile("&sessionid=([^&]+)$");
//        Pattern MY_PATTERN_2 = Pattern.compile("&sessionid=([^&]+)&.+$");

        long start = System.currentTimeMillis();

        Pattern MY_PATTERN_3 = Pattern.compile("(&sessionid=([^&]+)$)|(&sessionid=([^&]+)&.+$)");

        Matcher m = MY_PATTERN_3.matcher(original_path);
        while (m.find()) {
            int count = m.groupCount();
            System.out.println("group count of 1 : " + count);
            for (int i = 0 ; i < count ; i ++) {
                String s = m.group(i + 1);
                System.out.println("matched : " + s);
            }
        }

        m = MY_PATTERN_3.matcher(original_path_2);
        while (m.find()) {
            int count = m.groupCount();
            System.out.println("group count of 2: " + count);
            for (int i = 0 ; i < count ; i ++) {
                String s = m.group(i + 1);
                System.out.println("matched : " + s);
            }
        }

        System.out.println("DB-Test time elapse : " + (System.currentTimeMillis() - start));

        System.out.println("getSessionId in 1 : " + getSessionId(original_path));
        System.out.println("getSessionId in 2 : " + getSessionId(original_path_2));
    }

    private static String getSessionId(String path) {
        if (path == null || path.trim().length() == 0) {
            return null;
        }

        String sessionId = null;
        Matcher matcher = sessionIdPattern.matcher(path);
        if (matcher.find()) {
            int count = matcher.groupCount();
            if (count == 4) {
                sessionId = matcher.group(2);

                if (sessionId == null) {
                    sessionId = matcher.group(4);
                }
            }
        }

        return sessionId;
    }
}

