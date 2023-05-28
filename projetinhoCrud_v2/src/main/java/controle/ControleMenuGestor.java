package controle;

import util.Input;

public class ControleMenuGestor {
    protected static void menu() {
        int op = 1;
        do {
            System.out.println("===Menu Funcionario===");
            System.out.println("|  1 - fazer       |");
            System.out.println("|  2 - fazer       |");
            System.out.println("|  0 - Sair        |");
            System.out.println("====================");
            System.out.print("Resposta: ");
            op = Input.nextInt();
            switch (op) {
                case 0 -> System.out.println("Saindo...");
                case 1 -> System.out.println("a");
                case 2 -> System.out.println("b");
                default -> System.out.println("Número inválido");
            }

        } while (op != 0);
    }
}
