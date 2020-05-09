import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
public class MainTest {
    public static void main(String[] args) {
        String base64 = null;
        InputStream in = null;
        try {
            in = new FileInputStream(new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\temp\\100000013235.png"));
            byte[] bytes = new byte[in.available()];
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(base64);
    }

}
