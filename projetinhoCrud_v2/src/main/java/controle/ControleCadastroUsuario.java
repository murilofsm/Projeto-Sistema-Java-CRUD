package controle;

import bd.ConnectionFactory;
import modelo.Usuario;
import util.Input;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControleCadastroUsuario {
    protected static void cadastrar(){
        Usuario user = new Usuario();

        System.out.print("Digite nome de Usuário: ");
        user.setUsuarioLogin(Input.nextLine());
        System.out.print("Digite a senha: ");
        user.setSenhaLogin(Input.nextLine());

        insertBanco(user);
    }
    private static void insertBanco(Usuario user){
        Connection conn = ConnectionFactory.getConnectionComBanco();

        String sql = "insert into usuario (usuarioLogin, senhaLogin, nivelAcesso) values (? ,? ,? ); ";
        try{
            DatabaseUtil.useDatabase();
            assert conn != null;
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,user.getUsuarioLogin());
            stm.setString(2,user.getSenhaLogin());
            stm.setString(3,user.getNivelAcesso());
            stm.execute();
            stm.close();
            System.out.println("Usuário cadastrado com sucesso !!!");
        }catch(SQLException ex){
            System.out.println("Erro no INSERT USUARIO");
            System.out.println(ex.getMessage());
        }
    }
}
