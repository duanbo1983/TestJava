import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 7/20/15.
 */
public class Util {

    /**
     * Calculates the bounds covered by specific tile.
     *
     * @param tileId {@link TileId} of the tile
     * @return {@link Util.LatLngBounds}
     */
    public static LatLngBounds boundsOfTile(TileId tileId) {
        return boundsOfTile(tileId.getX(), tileId.getY(), tileId.getZoom());
    }

    /**
     * Calculates the bounds covered by specific tile.
     *
     * @param x    x index of tile
     * @param y    y index of tile
     * @param zoom zoom level
     * @return {@link LatLngBounds}
     */
    public static LatLngBounds boundsOfTile(int x, int y, int zoom) {
        int noTiles = (1 << zoom);
        double longitudeSpan = 360.0 / noTiles;
        double longitudeMin = -180.0 + x * longitudeSpan;

        double mercatorMax = 180 - (((double) y) / noTiles) * 360;
        double mercatorMin = 180 - (((double) y + 1) / noTiles) * 360;
        double latitudeMax = mercatorToLatitude(mercatorMax);
        double latitudeMin = mercatorToLatitude(mercatorMin);

        LatLngBounds bounds = new LatLngBounds(new LatLng(latitudeMin, longitudeMin),
                new LatLng(latitudeMax, longitudeMin + longitudeSpan));
        return bounds;
    }

    /**
     * Calculates the mercator value for latitude.
     *
     * @param latitude Latitude degree [-85, 85]
     * @return The mercator value for input latitude
     */
    public static double mercatorFromLatitude(double latitude) {
        double radians = Math.toRadians(latitude + 90) / 2;
        return Math.toDegrees(Math.log(Math.tan(radians)));
    }

    /**
     * Calculates latitude degree for specific mercator value.
     *
     * @param mercator The mercator value
     * @return Latitude degree for the mercator value
     */
    public static double mercatorToLatitude(double mercator) {
        double radians = Math.atan(Math.exp(Math.toRadians(mercator)));
        return Math.toDegrees(2 * radians) - 90;
    }

    /**
     * Calculates tile index based on lat/lon and zoom level.
     *
     * @param latLng {@link LatLng}
     * @param zoom   zoom level
     * @return {@link TileId}
     */
    public static TileId getTileIndex(LatLng latLng, int zoom) {
        int xtile = (int) Math.floor((latLng.lon + 180) / 360 * (1 << zoom));
        int ytile = (int) Math.floor((1 - Math.log(
                Math.tan(Math.toRadians(latLng.lat)) + 1 / Math.cos(Math.toRadians(latLng.lat)))
                / Math.PI) / 2 * (1 << zoom));
        if (xtile < 0) {
            xtile = 0;
        }
        if (xtile >= (1 << zoom)) {
            xtile = ((1 << zoom) - 1);
        }
        if (ytile < 0) {
            ytile = 0;
        }
        if (ytile >= (1 << zoom)) {
            ytile = ((1 << zoom) - 1);
        }
        return new TileId(xtile, ytile, zoom);
    }

    /**
     * Calculates the tile index list in the latlng bounds.
     *
     * @param latLngBounds {@link LatLngBounds}
     * @param zoom         zoom level
     * @return List of {@link TileId}
     */
    public static List<TileId> getTileIndexes(LatLngBounds latLngBounds, int zoom) {
        List<TileId> tileIds = new ArrayList<TileId>();
        TileId leftBottom = getTileIndex(latLngBounds.southwest, zoom);
        TileId rightTop = getTileIndex(latLngBounds.northeast, zoom);

        int xMin = leftBottom.getX();
        int xMax = rightTop.getX();
        int yMin = rightTop.getY();
        int yMax = leftBottom.getY();

        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {
                tileIds.add(new TileId(i, j, zoom));
            }
        }

        return tileIds;
    }

    static class LatLng {

        double lat;
        double lon;

        public LatLng(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;

        }
    }

    static class LatLngBounds {

        LatLng southwest;
        LatLng northeast;

        public LatLngBounds(LatLng southwest, LatLng northeast) {
            this.southwest = southwest;
            this.northeast = northeast;
        }
    }
}