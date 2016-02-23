/**
 * @author The Elite Gentleman
 *
 */
public enum NetworkType {
//    NETWORK_TYPE_WIFI("networkConnectionType_WiFi"),
//    NETWORK_TYPE_GPRS("networkConnectionType_GPRS"),
//    NETWORK_TYPE_EDGE("networkConnectionType_EDGE"),
//    NETWORK_TYPE_CDMA("networkConnectionType_CDMA"),
//    NETWORK_TYPE_EVDO_0("networkConnectionType_EVDO_0"),
//    NETWORK_TYPE_EVDO_A("networkConnectionType_EVDO_A"),
//    NETWORK_TYPE_EVDO_B("networkConnectionType_EVDO_B"),
//    NETWORK_TYPE_1xRTT("networkConnectionType_CDMA1x"),
//    NETWORK_TYPE_HSDPA("networkConnectionType_HSDPA"),
//    NETWORK_TYPE_HSUPA("networkConnectionType_HSUPA"),
//    NETWORK_TYPE_LTE("networkConnectionType_LTE"),
//    NETWORK_TYPE_EHRPD("networkConnectionType_EHRPD"),
//    NETWORK_TYPE_HSPAP("networkConnectionType_HSPAP"),
//    NETWORK_TYPE_UMTS("networkConnectionType_WCDMA"),
//    NETWORK_TYPE_HSPA("networkConnectionType_HSPA"),
//    NETWORK_TYPE_IDEN("networkConnectionType_IDEN"),
//    NETWORK_TYPE_UNKNOWN("networkConnectionType_Unknown"),

    networkConnectionType_WiFi("networkConnectionType_WiFi"),
    networkConnectionType_GPRS("networkConnectionType_GPRS"),
    networkConnectionType_EDGE("networkConnectionType_EDGE"),
    networkConnectionType_CDMA("networkConnectionType_CDMA"),
    networkConnectionType_EVDO_0("networkConnectionType_EVDO_0"),
    networkConnectionType_EVDO_A("networkConnectionType_EVDO_A"),
    networkConnectionType_EVDO_B("networkConnectionType_EVDO_B"),
    networkConnectionType_CDMA1x("networkConnectionType_CDMA1x"),
    networkConnectionType_HSDPA("networkConnectionType_HSDPA"),
    networkConnectionType_HSUPA("networkConnectionType_HSUPA"),
    networkConnectionType_LTE("networkConnectionType_LTE"),
    networkConnectionType_EHRPD("networkConnectionType_EHRPD"),
    networkConnectionType_HSPAP("networkConnectionType_HSPAP"),
    networkConnectionType_WCDMA("networkConnectionType_WCDMA"),
    networkConnectionType_HSPA("networkConnectionType_HSPA"),
    networkConnectionType_IDEN("networkConnectionType_IDEN"),
    networkConnectionType_Unknown("networkConnectionType_Unknown"),
    ;

    private final String text;

    /**
     * @param text
     */
    NetworkType(final String text) {
        this.text = text;
    }

    /*
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
