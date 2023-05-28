package util;

import bd.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {
    public static void useDatabase(){
        Connection conn = ConnectionFactory.getConnectionComBanco();
        String sql = "use projeto_crud_java";
        try {
            assert conn != null;
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.execute(sql);
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
