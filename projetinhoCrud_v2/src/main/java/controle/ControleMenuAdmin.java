package controle;

import bd.ConnectionFactory;
import bd.CriacaoBancoPadrao;
import util.Input;

import java.sql.Connection;

public class ControleMenuAdmin {

    public static void menu(){
        int op = 1;
        do {
            System.out.println("=========Menu Admin========");
            System.out.println("|  1 - Controle Database  |");
            System.out.println("|  2 - Cadastrar Gestor   |");
            System.out.println("|  0 - Sair               |");
            System.out.println("===========================");
            System.out.print("Resposta: ");
            op = Input.nextInt();
            switch (op) {
                case 0 -> System.out.println("Saindo...");
                case 1 -> CriacaoBancoPadrao.menu();
                case 2 -> System.out.println("b");
                default -> System.out.println("Número inválido");
            }

        }while (op!=0);
    }

    private static void cadastrarGestor(){
        Connection conn = ConnectionFactory.getConnectionComBanco();



    }


    private static void setarDados(){

    }




}
