package prototype;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author bp12214
 */
public class ReadFile {

    public static String read2File(File f) {
        String cont2 = "";
        try {
            FileInputStream fis = new FileInputStream(f);

            // get max length  
            int readSize = 2 * 1024 * 1024; // 2Mb  
            int len = fis.available() < readSize ? fis.available() : readSize;
            byte[] buffer = new byte[len];

            // read to buffer  
            fis.read(buffer, 0, len);
            String aux = new String(buffer);
            cont2 = aux;

        } catch (Exception e) {
            System.out.println("Erro readFile: " + e.getMessage());
        }
        return cont2;
    }
}