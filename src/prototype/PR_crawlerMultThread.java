package prototype;

import java.io.File;

/**
 *
 * @author bp12214
 */
public class PR_crawlerMultThread implements Runnable {

    private String root;
    private String ext;
    private hslFileFilter filter;

    public PR_crawlerMultThread(String root, String ext) {
        this.root = root;
        this.ext = ext;
        filter = new hslFileFilter();
    }

    public void start() {
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        // Thread.yield();
        t.start();

        t.setName(ext);
        System.out.println("Nova Thread " + t.getName());
    }

    private void allList(File file) {
        if (!file.isHidden()) {
            if (file.isDirectory()) {
                File[] list = file.listFiles(filter);
                for (int i = 0; i < list.length; i++) {
                    allList(list[i]);
                }
            } else {
                if (ext.equalsIgnoreCase(GetExtencion.getExt(file))) {
                    System.out.println(file.getAbsolutePath() + " - " + GetExtencion.getExt(file));


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

    @Override
    public void run() {
        File file = new File(root);
        System.out.println("*****************************" + file.getAbsoluteFile());
        if (file.exists()) {
            allList(file);
        }
    }
}