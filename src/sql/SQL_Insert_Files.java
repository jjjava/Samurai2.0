package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQL_Insert_Files {

    public static void insertFiles(String data[]) {
        Connection theConn = null;
        try {
            theConn = connection.MyConnection.getConnection();
            String sql =
                    "INSERT INTO tb_files ( "
                    + " nome ," //1
                    + " path ," //2
                    + " ext  ," //3
                    + " rel   " //4

                    + " ) VALUES ("
                    + " ?," //1
                    + " ?," //2
                    + " ?," //3
                    + " ? " //4
                    + " )";

            PreparedStatement ps = theConn.prepareStatement(sql);

            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setInt(4, Integer.parseInt(data[3]));


            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert file: "+e.getMessage());
        } finally {
            try {
                if (theConn != null) {
                    theConn.close();
                }
            } catch (Exception e) {
                System.out.println("insert file: "+e.getMessage());
            }
        }
    }
}
