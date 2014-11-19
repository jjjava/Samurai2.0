package prototype;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 *
 * @author Hudson
 */
public class hslFileFilter implements FileFilter {

    private String description;
    private ArrayList<String> extensions;

    public hslFileFilter() {
    
        extensions = new ArrayList<String>();
        extensions.add("txt");
        extensions.add("doc");
        extensions.add("pdf");
        extensions.add("xls");
        extensions.add("vsd");
        extensions.add("ppt");
        extensions.add("mdb");
        extensions.add("xml");
        extensions.add("csv");
        extensions.add("java");
        extensions.add("html");
        extensions.add("xhtml");
        extensions.add("css");
        extensions.add("mp3");
        extensions.add("bmp");
        extensions.add("png");
        extensions.add("bat");
        extensions.add("exe");
        extensions.add("msi");
        extensions.add("zip");
        
        description = "Arquivos suportados";
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        } else {
            String path = file.getAbsolutePath().toLowerCase();
            for (int i = 0; i < extensions.size(); i++) {
                String extension = extensions.get(i);
                if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getDescription() {
        return description;
    }
}