/**
 * Created by bod on 7/25/16.
 */
public class HelloJson {

    public static void main(String[] args) {

        String payload = "\"feedMessagePayload\":{\"authorLabel\":\"Justin\","
                + "\"content\":\"<html><p>Celebrate National kitten day with furry friends!</p></html>\","
                + "\"titleLabel\":\"Kittens are coming\"}},\"score\":3.0,\"templateType\":\"MOBILE_MESSAGE\"";
        String card = "{\"cardID\":\"the-feed-card-id\",\"cardType\":\"mobile_message\",\"cardUUID\":\"the-card-uuid\","
                + "\"payload\":{" + payload + "}";
        String content = "{\"feed\":{\"cards\":[" + card + "]}}";

        System.out.println(content);

        String a = "{\"feed\":{\"cards\":[{\"cardUUID\":\"ea0108eb-65fb-5239-b556-efac23c82f75\",\"cardType\":\"MOBILE_MESSAGE\",\"cardID\":\"00000000-0000-0000-0000-000000000006\",\"score\":1,\"payload\":{\"type\":\"mobileMessageWebViewPayload\",\"mobileMessageWebViewPayload\":{\"uuid\":\"11111111-1111-1111-1111-111111111114\",\"header\":\"Helix\",\"text\":\"Moving atoms\",\"authorName\":\"Peggy\",\"startDate\":\"1970-01-01T00:00:00.222Z\",\"fullViewHTML\":\"<html>place_holder</html>\",\"url\":\"https://www.youtube.com/embed/bx1-im6i8uk?autoplay=1\"}},\"templateType\":\"MOBILE_MESSAGE_WEB_VIEW\",\"sectionUUID\":null},{\"cardUUID\":\"284d0b0c-eb8c-5f13-92ad-ce8bc1613149\",\"cardType\":\"MOBILE_MESSAGE\",\"cardID\":\"11111111-1111-1111-1111-111111111112\",\"score\":1,\"payload\":{\"type\":\"mobileMessageWebViewPayload\",\"mobileMessageWebViewPayload\":{\"uuid\":\"11111111-1111-1111-1111-111111111113\",\"header\":\"fake header\",\"text\":\"fake text\",\"authorName\":\"fake author\",\"startDate\":\"1970-01-01T00:00:00.111Z\",\"fullViewHTML\":\"<html><body leftmargin=0 topmargin=0 rightmargin=0 bottommargin=0><img src=\\\"https://s3-us-west-2.amazonaws.com/uber-common-public/xiao/spotify.png\\\" height=auto width=100%/></body></html>\",\"url\":null}},\"templateType\":\"MOBILE_MESSAGE_WEB_VIEW\",\"sectionUUID\":null}],\"sections\":null},\"meta\":{\"lastModifiedTimeMs\":1469750686229}}";
        System.out.println(a);
    }
}
