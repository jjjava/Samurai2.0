package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author bp12214
 */
public class SQL_Select_ID_File {

    public static int getIDFile( String nome,String path, String ext) {
        int id = 0;
        try {
            Connection theConn = connection.MyConnection.getConnection();
            String sql = "SELECT * FROM tb_files WHERE path ='" + path + "' AND "
                       + "nome = '" + nome + "' AND ext = '" + ext + "'";

            Statement stmt = theConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            theConn.close();
        } catch (Exception e) {
            System.out.println("select id: "+e);
        }
        return id;
    }
}
