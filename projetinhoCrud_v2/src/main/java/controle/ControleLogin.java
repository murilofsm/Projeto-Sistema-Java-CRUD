package controle;

import bd.ConnectionFactory;
import util.DatabaseUtil;
import util.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControleLogin {

    protected static void menuLogin(){
        boolean travaLogin = true;
        int contTentativas = 1;
       do{
           System.out.println("=====Login=====");
           System.out.print("Insira o Usuário: ");
           String usuarioLogin = Input.nextLine();
           System.out.print("Insira a Senha: ");
           String senhaLogin = Input.nextLine();

           if(validarCredenciais(usuarioLogin,senhaLogin)){
               travaLogin = false;
               String nivelAcesso = buscarNivelAcesso(usuarioLogin);
               assert nivelAcesso != null;
               if(nivelAcesso.equals("funcionario")){
                   ControleMenuFuncionario.menu();
               }else if(nivelAcesso.equals("admin")){
                   ControleMenuAdmin.menu();
               }

           }else if(contTentativas == 3){
               System.out.println("Maximo de tentativas");
                travaLogin = false;
           }else{
               System.out.println("Login Inválido, Digite novamente");
               contTentativas++;
           }
       }while(travaLogin);


    }

    private static boolean validarCredenciais(String usuarioLogin, String senhaLogin){
        Connection conn = ConnectionFactory.getConnectionComBanco();

        String sql = "select * from usuario where usuarioLogin = ? and senhaLogin = ?";
        String usuarioBusca = "";
        String senhaBusca = "";

        try{
            DatabaseUtil.useDatabase();
            assert conn != null;
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,usuarioLogin);
            stm.setString(2,senhaLogin);

            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                usuarioBusca = rs.getString("usuarioLogin");
                senhaBusca = rs.getString("senhaLogin");
            }
            rs.close();
            stm.close();
            conn.close();

            if(usuarioBusca.equals(usuarioLogin) && senhaBusca.equals(senhaLogin)){
                return true;
            }

        }catch(SQLException ex){
            System.out.println("Usuário não existe.");
            System.out.println(ex.getMessage());
        }

        return false;
    }


    private static String buscarNivelAcesso(String usuarioLogin){
        Connection conn = ConnectionFactory.getConnectionComBanco();

        String nivelAcesso = "";
        String sql = "select nivelAcesso from usuario where usuarioLogin = ?;";


        try{
            DatabaseUtil.useDatabase();
            assert conn != null;
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,usuarioLogin);

            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                nivelAcesso = rs.getString("nivelAcesso");

            }
            rs.close();
            stm.close();
            conn.close();
            return nivelAcesso;
        }catch(SQLException ex){
            System.out.println("Erro na busca de Nivel");
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
