package controle;

import util.Input;

public class ControleMenuPrincipal {

    protected static void menu() {
        int op = 1;
        do{
            System.out.println("===Menu Principal===");
            System.out.println("|  1 - Login       |");
            System.out.println("|  2 - Cadastrar   |");
            System.out.println("|  0 - Sair        |");
            System.out.println("====================");
            System.out.print("Resposta: ");
            op = Input.nextInt();
            switch (op) {
                case 0 -> System.out.println("Saindo...");
                case 1 -> ControleLogin.menuLogin();
                case 2 -> ControleCadastroUsuario.cadastrar();
                default -> System.out.println("Número inválido");
            }
        }while (op != 0);
    }
}