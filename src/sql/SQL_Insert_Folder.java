package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQL_Insert_Folder {

    public static void insertFolders(String data[]) {
        Connection theConn = null;
        try {
            theConn = connection.MyConnection.getConnection();
            String sql =
                    "INSERT INTO tb_folders ( "
                    + " nome ," //1
                    + " path ," //2
                    + " rel " //3

                    + " ) VALUES ("
                    + " ?," //1
                    + " ?," //2
                    + " ? " //3
                    + " )";

            PreparedStatement ps = theConn.prepareStatement(sql);

            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setInt(3, Integer.parseInt(data[2]));

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert folder: "+e.getMessage());
        } finally {
            try {
                if (theConn != null) {
                    theConn.close();
                }
            } catch (Exception e) {
                System.out.println("insert folder: "+e.getMessage());
            }
        }
    }
}
