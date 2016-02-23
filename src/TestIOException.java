import java.io.IOException;

/**
 * Created by bod on 9/30/15.
 */
public class TestIOException {

    public static void main(String[] strings) {
        TestIOException testIOException = new TestIOException();
        IOException io = null;
        try {
            testIOException.readFile();
        } catch (IOException e) {
            //e.printStackTrace();
            io = e;
        }

        if (io != null) {
            testIOException.printException(io);
        }
    }

    public void printException(IOException exception) {
        IOException ioException = new IOException(exception.getMessage());
        //exception.printStackTrace(ioException);
        ioException.printStackTrace();
    }

    public void readFile() throws IOException {
        throw new IOException("TestError");
    }
}
