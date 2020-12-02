package livraria;

import java.util.Scanner;

public class LivrariaMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op;
        String cod = " ", titulo, matricula;
        Catalogo Livraria = new Catalogo();

        Valida valida = new Valida();


        do{
            MenuLogin();
            //exibirMenu();
            System.out.print("==> Informe a opção: ");
            op = Integer.parseInt(in.nextLine());
            switch (op){
                case 1: System.out.print("==> Informe o código do livro: ");
                        cod = in.nextLine();                        
                        Livraria.cadastrar(cod);
                        break;
                case 2: Livraria.exibirPorCod(cod);
                        break;
                case 3: Livraria.ordenaCod();
                        break;
                case 4: System.out.print("==> Informe o código para busca: ");
                        cod = in.nextLine();
                        Livraria.consultar(cod);
                        break;
                case 5: break;
            }
        }while (op != 7);
    }

    public static void exibirMenu(){
        banner();
        System.out.println("Menu principal ");
        System.out.println("1 - Registrar um livro");
        System.out.println("2 - Exibir livros");
        System.out.println("3 - Ordenar por código");
        System.out.println("4 - Consultar dados de um livro");
        System.out.println("5 - Sair do programa ");
    }


    public static void exibirMenuAdmin(){
        banner();
        System.out.println("Menu principal ");
        System.out.println("1 - Registrar um livro");
        System.out.println("2 - Editar Livro");
        System.out.println("3 - Remover Livro");
        System.out.println("4 - Consultar livro");
        System.out.println("5 - Consultar dados de um livro");
        System.out.println("6 - Cadastrar Funcionario");
        System.out.println("7 - Editar Funcionario");
        System.out.println("8 - Remover Funcionario");
        System.out.println("9 - Cadastrar Funcionario");
        System.out.println("10 - Consultar produto");
        System.out.println("-1 - Sair do programa ");
    }


    public static void MenuLogin() {
        Funcionario Admin = new Funcionario(1, "Admin", "ABC@123", 10000.00, "Gerente TI", "1", true);
        Valida valida = new Valida();
        Scanner login = new Scanner(System.in);
        Scanner senha = new Scanner(System.in);
        String inputLogin,inputSenha;
        Boolean validaLogin;
        banner();
        do {
            System.out.println("==> Bem vindo a Livraria \n digite seu login e senha para prosseguir com seu dia");
            inputLogin = login.nextLine();
            validaLogin = valida.verificarLogin(Admin, inputLogin);
            if (!validaLogin) {
                System.out.println("Dados inválidos favor tentar novamente");
            }
        } while(validaLogin != true); {
            if (valida.verificarLogin(Admin, inputLogin)) {
                System.out.println("==> Digite sua senha para prosseguir: ");
                inputSenha = senha.nextLine();
                System.out.println("" + inputLogin + ": " + inputSenha);
                if (valida.verificarAdmin(Admin)) {
                    if(valida.verificarSenha(Admin,Admin.getSenha())) {
                        exibirMenuAdmin();
                    }
                }
            } else {
                System.out.println("Dados inválidos favor tentar novamente");
            }
        }



    }

    public static void banner() {
        System.out.println("\n" +
                "  _     _                      _       \n" +
                " | |   (_)_   ___ __ __ _ _ __(_) __ _ \n" +
                " | |   | \\ \\ / / '__/ _` | '__| |/ _` |\n" +
                " | |___| |\\ V /| | | (_| | |  | | (_| |\n" +
                " |_____|_| \\_/ |_|  \\__,_|_|  |_|\\__,_|\n" +
                "                                       \n");
    }
    
}
