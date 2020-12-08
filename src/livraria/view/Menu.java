package livraria.view;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu() {

    }

    public int menuInicial() {
        Scanner in = new Scanner(System.in);
        int opcao;
        banner();
        System.out.print("v1.0\n"
                + "1. Àrea do Cliente\n"
                + "2. Área do Administrador\n"
                + "3. Sair\n"
                + "Opção: ");
        opcao = in.nextInt();
        in.nextLine();
        return opcao;
    }

    public int menuCliente() {
        Scanner in = new Scanner(System.in);
        int opcao;
        System.out.println("[!] Área do cliente.");
        System.out.print("Escolha a opção desejada: \n"
                + "1. Efetuar login \n"
                + "2. Realizar cadastro \n"
                + "3. Sair\n"
                + "Opção: ");
        opcao = in.nextInt();
        in.nextLine();
        return opcao;
    }

    public int menuClienteAutenticado() {
        Scanner in = new Scanner(System.in);
        int opcao;
        System.out.println("==> Área do cliente.");
        System.out.print("Escolha a opção: \n"
                + "1. Visualizar catálogo. \n"
                + "2. Adicionar item ao carrinho. \n"
                + "3. Remover item do carrinho. \n"
                + "4. Visualizar carrinho. \n"
                + "5. Finalizar compra. \n"
                + "6. Sair. \n"
                + "Opção: ");
        opcao = in.nextInt();
        in.nextLine();
        return opcao;
    }

    public int menuAdministrativo() {
        Scanner in = new Scanner(System.in);
        int opcao;
        System.out.print("Área do Administrador \n"
                + "1. Efetuar login \n"
                + "2. Cadastrar Administrador\n"
                + "3. Sair\n"
                + "Opção: ");
        opcao = in.nextInt();
        in.nextLine();
        return opcao;
    }


    public static int menuAdministrativoAuth() {
        int opcao;
        Scanner in = new Scanner(System.in);
        System.out.print("Menu Admnistrativo \n"
                + "1. Cadastrar Produto. \n"
                + "2. Alterar quantidade em estoque. \n"
                + "3. Remover produto. \n"
                + "4. Visualizar catálogo. \n"
                + "5. Aplicar roleta desconto. \n"
                + "6. Sair. \n"
                + "Opção: ");
        opcao = in.nextInt();
        in.nextLine();
        return opcao;
    }

    public void percorreLista(List l) {
        if(l.isEmpty()){
            System.out.println("Lista vazia");
        }
        l.forEach((a) -> {
            System.out.println(a);
        });
    }


    public String banner() {
        return  "        ,\n" +
                " LIVRARIA DINO BUGGER ,\n" +
                "       /|\n" +
                "      / |\n" +
                "     /  /\n" +
                "    |   |\n" +
                "   /    |\n" +
                "   |    \\_\n" +
                "   |      \\__\n" +
                "   \\       __\\_______\n" +
                "    \\                 \\_\n" +
                "    | /                 \\\n" +
                "    \\/                   \\\n" +
                "     |                    |\n" +
                "     \\                   \\|\n" +
                "     |                    \\\n" +
                "     \\                     |\n" +
                "     /\\    \\_               \\\n" +
                "    / |      \\__ (   )       \\\n" +
                "   /  \\      / |\\\\  /       __\\____\n" +
                "snd|  ,     |  /\\ \\ \\__    |       \\_\n" +
                "   \\_/|\\___/   \\   \\}}}\\__|  (@)     )\n" +
                "    \\)\\)\\)      \\_\\---\\   \\|       \\ \\\n" +
                "                  \\>\\>\\>   \\   /\\__o_o)\n" +
                "                            | /  VVVVV\n" +
                "                            \\ \\    \\\n" +
                "                             \\ \\MMMMM                  oh bugger!\n" +
                "                              \\______/         _____ /\n" +
                "                                              |  O O|\n" +
                "                                             /___|_|/\\_\n" +
                "                                        ==( |          |\n" +
                "                                             (o)====(o)";
    }


}
