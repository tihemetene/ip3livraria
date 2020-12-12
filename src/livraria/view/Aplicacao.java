package livraria.view;
import livraria.Interface.InFachada;
import livraria.controller.Fachada;
import livraria.exceptions.ExisteProdutoExcecao;
import livraria.model.FactoryProduto;
import livraria.model.Produto;
import livraria.model.AdminUsuario;
import livraria.model.ClienteUsuario;
import java.util.Scanner;
import java.util.Date;
import java.util.List;

public class Aplicacao {
    private static final InFachada fachada = new Fachada();
    /*
     *  Singleton
     *
     * */
    private static Aplicacao instance;

    static Aplicacao getInstance() {
        if (instance == null) {
            instance = new Aplicacao();
        }
        return instance;
    }

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        int menuAdm, menuCliAuth, codProduto, menuAdminAuth, menuInicial, menuCli, qtdEstoque, tipo;
        String nome, telefone, cpf, senha, editora, descricao, codBarras;
        System.out.println(banner());
        double preco;
        boolean login;
        Produto produto;
        FactoryProduto factory = new FactoryProduto();

        do{
            menuInicial = menuInicial();
            switch(menuInicial){
                case 1:
                    //MenuInicial
                    do{
                        menuCli = menuCliente();
                        switch(menuCli){
                            case 1:
                                //Fazer login
                                System.out.println("Login do Cliente");
                                System.out.print("CPF: "); cpf = in.nextLine();
                                System.out.print("Senha: "); senha = in.nextLine();
                                login = fachada.loginCliente(cpf, senha);
                                if(login){
                                    do{
                                        menuCliAuth = menuClienteAutenticado();
                                        switch(menuCliAuth){
                                            /*
                                             + "1. Visualizar catálogo. \n"
                                            + "2. Adicionar item ao carrinho. \n"
                                            + "3. Remover item do carrinho. \n"
                                            + "4. Visualizar carrinho. \n"
                                            + "5. Finalizar compra. \n"
                                            + "6. Sair. \n"
                                            */
                                            case 1:
                                                percorreLista(fachada.visualizarProdutos());
                                                break;
                                            case 2:
                                                System.out.print("Código do produto: ");
                                                codProduto = in.nextInt();
                                                fachada.adicionarProdutoCarrinho(codProduto);
                                                break;
                                            case 3:
                                                System.out.print("Código para remoção: ");
                                                codProduto = in.nextInt();
                                                fachada.removerProduto(codProduto);
                                                break;
                                            case 4:
                                                System.out.println("Visualizar carrinho");
                                                percorreLista(fachada.visualizarCarrinho());
                                                break;
                                            case 5:
                                                System.out.println("Finalizando compras");
                                                fachada.finalizarCompra();
                                                break;
                                            case 6:
                                                System.out.println("Deslogando área do cliente");
                                                break;
                                            default:
                                                System.out.println("Opção inválida - ClienteAuth()");
                                                menuCliAuth = menuClienteAutenticado();
                                        }
                                    }while(menuCliAuth != 6);
                                }
                                break;
                            case 2:
                                //Cadastro
                                System.out.println("Cadastro do cliente");
                                System.out.print("Nome: "); nome = in.nextLine();
                                System.out.print("CPF: "); cpf = in.nextLine();
                                System.out.print("Telefone: "); telefone = in.nextLine();
                                System.out.print("Senha: "); senha = in.nextLine();
                                Date data = new Date();

                                ClienteUsuario novoCliente = new ClienteUsuario(cpf, nome, telefone, senha, data);
                                fachada.cadastrarCliente(novoCliente);
                                System.out.println("Usuário "+novoCliente.getNome()+" cadastrado!");
                                break;
                            case 3:
                                System.out.println("Saindo da área do cliente!");
                                break;
                            default:
                                System.out.println("Opção inválida - menuCli()");
                                menuCli = menuCliente();
                        }
                    }while (menuCli != 3);
                    break;
                case 2:
                    //MenuInicial
                    do{
                        menuAdm = menuAdministrativo();
                        switch(menuAdm){
                            case 1:
                                //Fazer login
                                System.out.println("Login do Administrador");
                                System.out.print("CPF: "); cpf = in.nextLine();
                                System.out.print("Senha: "); senha = in.nextLine();
                                login = fachada.loginAdministrador(cpf, senha);
                                if(login){
                                    do{
                                        menuAdminAuth = menuAdministrativoAuth();
                                        switch(menuAdminAuth){
                                            /*
                                            + "1. Cadastrar Produto. \n"
                                            + "2. Alterar quantidade em estoque. \n"
                                            + "3. Remover produto. \n"
                                            + "4. Visualizar catálogo. \n"
                                            + "5. Sair. \n"
                                            */
                                            case 1:
                                                System.out.println("Cadastrar novo Produto");
                                                System.out.println("Tipo do produto(1-Livro/2-Jogo): ");
                                                tipo = in.nextInt();
                                                System.out.print("Nome do produto: ");
                                                nome = in.nextLine();
                                                System.out.print("Editora/Empresa do produto: ");
                                                editora = in.nextLine();
                                                System.out.print("Descricao do produto: ");
                                                descricao = in.nextLine();
                                                System.out.println("Cód. de barras do produto: ");
                                                codBarras = in.nextLine();
                                                System.out.print("Preço do produto: ");
                                                preco = in.nextDouble();
                                                System.out.print("Qtd em estoque: ");
                                                qtdEstoque = in.nextInt();
                                                produto = new Produto(nome, editora, descricao, preco, qtdEstoque, codBarras, tipo);
                                                System.out.println(fachada.cadastrarProduto(produto));
                                                System.out.println("Produto: "+produto.toString() + "cadastrado");
                                                break;
                                            case 2:
                                                System.out.print("Código do produto: ");
                                                codProduto = in.nextInt();
                                                System.out.print("Quantidade: ");
                                                qtdEstoque = in.nextInt();
                                                fachada.alterarQuantidade(codProduto, qtdEstoque);
                                                System.out.println("Produto atualizado");
                                                break;
                                            case 3:
                                                System.out.println("Remover produto");
                                                System.out.print("Código do produto: ");
                                                codProduto = in.nextInt();
                                                fachada.removerProduto(codProduto);
                                                System.out.println("Produto removido.");
                                                break;
                                            case 4:
                                                percorreLista(fachada.visualizarProdutos());
                                                break;
                                            case 5:
                                                fachada.aplicarDescontoAleatorio();
                                                break;
                                            case 6:
                                                System.out.println("Fim programa");
                                                break;
                                            default:
                                                System.out.println("Opção inválida - AdmAuth()");
                                                menuAdminAuth = menuAdministrativoAuth();
                                        }

                                    }while(menuAdminAuth != 6);
                                }
                                break;
                            case 2:
                                //Cadastro
                                System.out.println("Cadastro Administrador");
                                System.out.print("Nome: "); nome = in.nextLine();
                                System.out.print("CPF: "); cpf = in.nextLine();
                                System.out.print("Telefone: "); telefone = in.nextLine();
                                System.out.print("Senha: "); senha = in.nextLine();
                                Date data = new Date();
                                AdminUsuario user = new AdminUsuario(cpf, nome, telefone, senha, data);
                                fachada.cadastarAdministrador(user);
                                System.out.println("Usuário: " + user.getNome() + " cadastrado com sucesso!");
                                break;
                            case 3:
                                System.out.println("Saindo da área do administrador!");
                                break;
                            default:
                                System.out.println("Opção inválida - menuAdm()");
                                menuAdm = menuAdministrativo();
                        }
                        //Código admin
                    } while(menuAdm != 3);
                    break;
                case 3:
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida - menuInicial()");
                    menuInicial = menuInicial();
            }
        }while(menuInicial != 3);
    } //fim main

    public static int menuInicial() {
        Scanner in = new Scanner(System.in);
        int opcao;
        banner();
        System.out.print("v1.0\n"
                + "1. Área do Cliente\n"
                + "2. Área do Administrador\n"
                + "3. Sair\n"
                + "Opção: ");
        opcao = in.nextInt();
        in.nextLine();
        return opcao;
    }

    public static int menuCliente() {
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

    public static int menuClienteAutenticado() {
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

    public static int menuAdministrativo() {
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

    public static void percorreLista(List l) {
        if(l.isEmpty()){
            System.out.println("Lista vazia");
        }
        l.forEach((a) -> {
            System.out.println(a);
        });
    }

    public static String banner() {
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