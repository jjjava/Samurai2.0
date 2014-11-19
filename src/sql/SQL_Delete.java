package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author bp12214
 */
public class SQL_Delete {

    public static void deleteFiles() {
        Connection theConn = null;
        try {
            theConn = connection.MyConnection.getConnection();
            String sql = "DELETE FROM tb_files";
            PreparedStatement ps = theConn.prepareStatement(sql);

            ps.executeUpdate();
            ps.close();
            
            System.out.println("Delete files");

        } catch (Exception ex) {
            System.out.println("dev :" + ex);
        } finally {
            try {
                if (theConn != null) {
                    theConn.close();
                }
            } catch (Exception ex) {
                System.out.println("dev :" + ex);
            }
        }
    }

    public static void deleteFolders() {
        Connection theConn = null;
        try {
            theConn = connection.MyConnection.getConnection();
            String sql = "DELETE FROM tb_folders";
            PreparedStatement ps = theConn.prepareStatement(sql);

            ps.executeUpdate();
            ps.close();
            System.out.println("Delete folders");

        } catch (Exception ex) {
            System.out.println("dev :" + ex);
        } finally {
            try {
                if (theConn != null) {
                    theConn.close();
                }
            } catch (Exception ex) {
                System.out.println("dev :" + ex);
            }
        }
    }

    public static void deleteContent() {
        Connection theConn = null;
        try {
            theConn = connection.MyConnection.getConnection();
            String sql = "DELETE FROM tb_content";
            PreparedStatement ps = theConn.prepareStatement(sql);

            ps.executeUpdate();
            ps.close();
            System.out.println("Delete content");

        } catch (Exception ex) {
            System.out.println("dev :" + ex);
        } finally {
            try {
                if (theConn != null) {
                    theConn.close();
                }
            } catch (Exception ex) {
                System.out.println("dev :" + ex);
            }
        }
    }
}