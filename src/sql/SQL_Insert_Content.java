package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQL_Insert_Content {

    public static void insertContent(int id_file, String data) {
        Connection theConn = null;
        try {
            theConn = connection.MyConnection.getConnection();
            String sql =
                    "INSERT INTO tb_content( "
                    + " id_file ," //1
                    + " content " //2
                    + " ) VALUES ("
                    + " ?," //1
                    + " ? " //2
                    + " )";

            PreparedStatement ps = theConn.prepareStatement(sql);

            ps.setInt(1, id_file);
            ps.setString(2, data);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert content: " + e.getMessage());
        } finally {
            try {
                if (theConn != null) {
                    theConn.close();
                }
            } catch (Exception e) {
                System.out.println("insert content: " + e.getMessage());
            }
        }
    }
}
