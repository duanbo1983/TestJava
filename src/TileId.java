/**
 * Defines id of a tile used in mercator projection.
 */
public class TileId {

    private final int mX;
    private final int mY;
    private final int mZoom;

    /**
     * Constructor.
     *
     * @param x X index of tile index
     * @param y Y index of the tile index
     * @param zoom Zoom of the tile index
     */
    public TileId(int x, int y, int zoom) {
        mX = x;
        mY = y;
        mZoom = zoom;
    }

    /**
     * @return X index of tile index
     */
    public int getX() {
        return mX;
    }

    /**
     * @return Y index of the tile index
     */
    public int getY() {
        return mY;
    }

    /**
     * @return Zoom of the tile index
     */
    public int getZoom() {
        return mZoom;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TileId)) {
            return false;
        }
        final TileId other = (TileId) o;
        return other.mX == mX && other.mY == mY && other.mZoom == mZoom;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result += 31 * mX;
        result += 31 * mY;
        result += 31 * mZoom;
        return result;
    }

    @Override
    public String toString() {
        return "TileId -- x : " + mX + " , y : " + mY + " , zoom : " + mZoom;
    }
}
