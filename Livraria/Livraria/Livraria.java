package Livraria;
import java.util.Scanner;

public class Livraria {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op;
        String cod = " ", titulo;
        Catalogo Livraria = new Catalogo();
        do{
            exibirMenu();
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
