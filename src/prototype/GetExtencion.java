package prototype;

import java.io.File;

/**
 *
 * @author Hudson Schumaker
 */
public class GetExtencion {

    public static String getExt(String path) {
        File f = new File(path);
        String ext = "";
        String fileName = f.getName();
        String exts[] = fileName.split("\\.");
        int i = exts.length;
        if (i > 1) {
            ext = exts[i - 1];
        }
        return ext;
    }
    public static String getExt(File f) {
        String ext = "";
        String fileName = f.getName();
        String exts[] = fileName.split("\\.");
        int i = exts.length;
        if (i > 1) {
            ext = exts[i - 1];
        }
        return ext;
    }
}
