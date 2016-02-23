import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bod on 10/9/15.
 */
public class TestMatcher {

    private static final Pattern mSessionIdPattern =
            Pattern.compile("[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}");

    public static void main(String[] strings) {
        Matcher matcher = mSessionIdPattern.matcher(null);
        //Matcher matcher = mSessionIdPattern.matcher("/rt/drivers/df22435a-3f02-4337-bab9-5a0640aaf66c");
        //Matcher matcher = mSessionIdPattern.matcher("/rt/drivers/df22435a-3f02-4337-bab9-5a0640aaf66c/verify-info");
        System.out.println(matcher.replaceAll("uuid"));


        final URI uri = URI.create("http://stackoverflow/java/regex?a=123");
        System.out.println(uri.getPath().substring(1));
        System.out.println(uri.getHost());
    }
}
