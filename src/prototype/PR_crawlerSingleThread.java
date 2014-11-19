package prototype;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bp12214
 */
public class PR_crawlerSingleThread  {

    private String root;
    private hslFileFilter filter;

    public PR_crawlerSingleThread(String root) {
        this.root = root;
        filter = new hslFileFilter();
    }

    public void start() {
//        Thread t = new Thread(this);
//        t.setPriority(10);
//        t.start();
//        //  Thread.yield();
//        t.setName("Single");
//        System.out.println("## Nova Thread " + t.getName());
    }

    private void allList(File file) {
        if (!file.isHidden()) {
            if (file.isDirectory()) {
                File[] list = file.listFiles(filter);
                sql.SQL_Insert_Folder.insertFolders(new String[]{file.getName(), file.getAbsolutePath(), "0"});
                for (int i = 0; i < list.length; i++) {
                    allList(list[i]);
                }
            } else {
                if ((file.length() / 1024) / 1024 > 512) {
                    System.out.println("Maior que 512mb " + (file.length() / 1024) / 1024);
                } else {
                    System.out.println(file.getAbsolutePath());
                    if (GetExtencion.getExt(file).equalsIgnoreCase("txt")) {

                        sql.SQL_Insert_Files.insertFiles(
                                new String[]{file.getName(),
                            file.getAbsolutePath(),
                            GetExtencion.getExt(file),
                            "0"});

                        int id = sql.SQL_Select_ID_File.getIDFile(file.getName(),
                                file.getAbsolutePath(),
                                GetExtencion.getExt(file));

                        sql.SQL_Insert_Content.insertContent(id, ReadFile.read2File(file));
                    }
                    if (GetExtencion.getExt(file).equalsIgnoreCase("xml")) {

                        sql.SQL_Insert_Files.insertFiles(
                                new String[]{file.getName(),
                            file.getAbsolutePath(),
                            GetExtencion.getExt(file),
                            "0"});

                        int id = sql.SQL_Select_ID_File.getIDFile(file.getName(),
                                file.getAbsolutePath(),
                                GetExtencion.getExt(file));

                        sql.SQL_Insert_Content.insertContent(id, ReadFile.read2File(file));
                    }
                    if (GetExtencion.getExt(file).equalsIgnoreCase("java")) {

                        sql.SQL_Insert_Files.insertFiles(
                                new String[]{file.getName(),
                            file.getAbsolutePath(),
                            GetExtencion.getExt(file),
                            "0"});

                        int id = sql.SQL_Select_ID_File.getIDFile(file.getName(),
                                file.getAbsolutePath(),
                                GetExtencion.getExt(file));

                        sql.SQL_Insert_Content.insertContent(id, ReadFile.read2File(file));
                    }
                    if (GetExtencion.getExt(file).equalsIgnoreCase("html")) {

                        sql.SQL_Insert_Files.insertFiles(
                                new String[]{file.getName(),
                            file.getAbsolutePath(),
                            GetExtencion.getExt(file),
                            "0"});

                        int id = sql.SQL_Select_ID_File.getIDFile(file.getName(),
                                file.getAbsolutePath(),
                                GetExtencion.getExt(file));

                        sql.SQL_Insert_Content.insertContent(id, ReadFile.read2File(file));
                    }
                    if (GetExtencion.getExt(file).equalsIgnoreCase("xhtml")) {

                        sql.SQL_Insert_Files.insertFiles(
                                new String[]{file.getName(),
                            file.getAbsolutePath(),
                            GetExtencion.getExt(file),
                            "0"});

                        int id = sql.SQL_Select_ID_File.getIDFile(file.getName(),
                                file.getAbsolutePath(),
                                GetExtencion.getExt(file));

                        sql.SQL_Insert_Content.insertContent(id, ReadFile.read2File(file));
                    }
                    if (GetExtencion.getExt(file).equalsIgnoreCase("bat")) {

                        sql.SQL_Insert_Files.insertFiles(
                                new String[]{file.getName(),
                            file.getAbsolutePath(),
                            GetExtencion.getExt(file),
                            "0"});

                        int id = sql.SQL_Select_ID_File.getIDFile(file.getName(),
                                file.getAbsolutePath(),
                                GetExtencion.getExt(file));

                        sql.SQL_Insert_Content.insertContent(id, ReadFile.read2File(file));
                    } else {
                        sql.SQL_Insert_Files.insertFiles(
                                new String[]{file.getName(),
                            file.getAbsolutePath(),
                            GetExtencion.getExt(file),
                            "0"});
                    }
                }
            }
        }
    }

   
    public void run() {
        File file = new File(root);
        System.out.println("*****************************" + file.getAbsoluteFile());


        while (true) {
            if (file.exists()) {
                allList(file);
            }
        }

    }
}