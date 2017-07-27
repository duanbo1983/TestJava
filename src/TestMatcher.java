import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bod on 10/9/15.
 */
public class TestMatcher {

    private static final String UUID_PATTERN_STR =
            "[A-Fa-f0-9]{8}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{12}";
    private static final Pattern STATUS_PATTERN =
            Pattern.compile("^/rt/riders/" + UUID_PATTERN_STR + "/status.*|^/rt/riders/me/status.*");


    private static final Pattern TOKEN_PATTERN =
            Pattern.compile("(^/rt/notifier/device-tokens/).+");

    private static final Pattern mSessionIdPattern =
            Pattern.compile("[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}");

    public static void main(String[] strings) {
        //Matcher matcher = mSessionIdPattern.matcher(null);
        //Matcher matcher = mSessionIdPattern.matcher("/rt/drivers/df22435a-3f02-4337-bab9-5a0640aaf66c");
        //Matcher matcher = mSessionIdPattern.matcher("/rt/drivers/df22435a-3f02-4337-bab9-5a0640aaf66c/verify-info");
        //System.out.println(matcher.replaceAll("uuid"));


//        final URI uri = URI.create("http://stackoverflow/java/regex?a=123");
//        System.out.println(uri.getPath().substring(1));
//        System.out.println(uri.getHost());


        final Matcher matcher1 = STATUS_PATTERN.matcher("/rt/riders/df22435a-3f02-4337-bab9-5a0640aaf66c/status");
        System.out.println(matcher1.matches());

        final Matcher matcher2 = STATUS_PATTERN.matcher("/rt/riders/me/status");
        System.out.println(matcher2.matches());

        final Matcher matcher3 = STATUS_PATTERN.matcher("/rt/ridrs/me/status");
        System.out.println(matcher3.matches());

        final Matcher matcher4 = STATUS_PATTERN.matcher("/rt/riders/d-3f02-4337-bab9-5a0640aaf66c/status");
        System.out.println(matcher4.matches());

        final Matcher matcher5 = TOKEN_PATTERN.matcher("/rt/notifier/device-tokens/fXA__MW2BqY:APA91bFVGqOLmTl2lrrODRn8tdKM3xwvtC8zKvEvZpj296XToKvmPJHEOYCChlTrVKSzTRp0HlE0LhwwJSEEFarHhSPvg6vsWvEwR6LKBm4FBhNoz7D0Rh2i07k4gqZVcJdJghFRLdWU");
        System.out.println(matcher5.toString());
        System.out.println(matcher5.replaceFirst("$1token"));
    }
}
