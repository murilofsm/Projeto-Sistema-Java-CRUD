package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnectionComBanco() {

        String url = "jdbc:mysql://localhost/projeto_crud_java";
        String user = "root";
        String password = "2344";
        
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Conexao nao realizada !!");
            e.printStackTrace();
            return null;
        }
    }

    protected static Connection getConnectionSemBanco(){ // vai ser utilizada p/ criar o banco de dados (NÃO SEI SE VAI DAR CERTO)
        String url = "jdbc:mysql://localhost/";
        String user = "root";
        String password = "2344";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Conexao nao realizada !!");
            e.printStackTrace();
            return null;
        }
    }
}
