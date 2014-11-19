/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hudson.sales
 */
public class SQL_Search {

    public static ArrayList doQueryName(String param) {
        ArrayList array = new ArrayList();
        Connection theConn = null;
        String sql = "SELECT * FROM tb_files WHERE nome LIKE '%" + param + "%' ORDER BY rel DESC";
        try {
            theConn = connection.MyConnection.getConnection();
            Statement stmt = theConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                array.add(
                        rs.getString("nome") + "#"
                        + rs.getString("path"));  
            }
            rs.close();
            stmt.close();
            theConn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return array;
    }
    
    public static ArrayList doQueryContent(String param) {
        ArrayList array = new ArrayList();
        Connection theConn = null;
        String sql = "SELECT * FROM tb_content WHERE content LIKE '%" + param + "%'";
        try {
            theConn = connection.MyConnection.getConnection();
            Statement stmt = theConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                array.add(
                        rs.getString("content") + "#"
                        + "n/a");  
            }
            rs.close();
            stmt.close();
            theConn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return array;
    }
}
