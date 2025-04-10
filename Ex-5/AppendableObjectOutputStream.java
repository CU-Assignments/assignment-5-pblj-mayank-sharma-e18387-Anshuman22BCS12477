// File: AppendableObjectOutputStream.java
import java.io.*;

public class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        File file = new File("employees.dat");
        if (file.length() == 0) {
            super.writeStreamHeader(); // only write header for new file
        } else {
            reset(); // avoid writing header again
        }
    }
}
