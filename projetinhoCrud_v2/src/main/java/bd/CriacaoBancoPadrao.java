package bd;

import util.Input;
import util.CredenciaisUtil;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriacaoBancoPadrao {
    public static void menu(){


            int op = 1;
            String resp = " ";
            do {
                System.out.println("=========Menu Banco=========");
                System.out.println("| 1 - Criar Banco          |");
                System.out.println("| 2 - Destruir Banco       |");
                System.out.println("| 0 - Sair                 |");
                System.out.println("============================");
                System.out.print("Resposta: ");
                op = Input.nextInt();
                switch (op){
                    case 0:
                        System.out.println("Saindo do menu Banco...");
                        break;
                    case 1:
                        System.out.println("Deseja criar a table Usuários? s/n");
                        resp = Input.nextLine();
                        createDatabase(CredenciaisUtil.confirmaSim(resp));
                        break;
                    case 2:
                        System.out.println("Deseja realmente destruir o banco? s/n");
                        resp = Input.nextLine();
                        if(CredenciaisUtil.confirmaSim(resp)){
                            dropDatabase();
                        }
                        break;
                    default:
                        System.out.println("Insira um valor novamente,");
                        break;
                }
            }while(op != 0);
        }


    private static void createDatabase(Boolean criarTable){
        Connection conn = ConnectionFactory.getConnectionSemBanco();

        String sql = "create database projeto_crud_java";

        try{
            assert conn != null;
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.execute();
            stm.close();
            System.out.println("Banco de dados criado com sucesso !!");
            if(criarTable){
                createTableUsuario(true);
            }
        }catch(SQLException ex){
            System.out.println("Erro na Criação do Banco !!");
            System.out.println(ex.getErrorCode());
        }
    }


    private static void dropDatabase(){
        Connection conn = ConnectionFactory.getConnectionSemBanco();

        String sql = "drop database projeto_crud_java";
        try{
            assert conn != null;
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.execute();
            stm.close();
            System.out.println("Banco de dados destruido com sucesso !!");
        }catch(SQLException ex){
            System.out.println("Erro na Criação do Banco !!");
            System.out.println(ex.getErrorCode());
        }
    }

    private static void createTableUsuario(boolean criarUsuarioAdmin){

        Connection conn = ConnectionFactory.getConnectionComBanco();

        String sql = "create table usuario (idUsuario int auto_increment primary key, usuarioLogin varchar(50), senhaLogin varchar(50), nivelAcesso varchar(30));";

        try{
            DatabaseUtil.useDatabase();
            assert conn != null;
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.execute();
            if(criarUsuarioAdmin){
                sql = "insert into usuario (usuarioLogin, senhaLogin, nivelAcesso) values ('admin','admin','admin');";// criação do usuário de admin automatico
                stm.execute(sql);
            }
            stm.close();
            System.out.println("Table Usuario criada com sucesso !!");
        }catch(SQLException ex){
            System.out.println("Erro na criação da TABLE USUARIO");
            System.out.println(ex.getMessage());
        }
    }
}
