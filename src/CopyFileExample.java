import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileExample {
    public static void main(String[] args) throws IOException {
        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            inStream = new FileInputStream(new File("./txt/file1.txt"));
            outStream = new FileOutputStream(new File("./txt/file2.txt"));
            int count = 0;
            int length;
            byte[] buffer = new byte[1024];

            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
                count+=length;
            }
            System.out.println("File is copied successful!" );
            System.out.println("Number of characters in file : " + count);
        } catch (IOException e) {
            System.err.println("Can't find file1.txt");
        } finally {
            inStream.close();
            outStream.close();
        }
    }
}
