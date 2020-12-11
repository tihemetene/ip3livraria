package livraria.view;

import livraria.Interface.InFachada;
import livraria.controller.Fachada;
import livraria.exceptions.ExisteProdutoExcecao;
import livraria.model.Produto;
import livraria.model.AdminUsuario;
import java.util.Scanner;



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

    public static void main(String[] args) throws InterruptedException {

        int menuAdm, menuCliAuth, codProduto, menuAdminAuth, menuInicial, menuCli, qtdEstoque;
        String nome, telefone, cpf, senha, marca, descricao;
        Menu m = new Menu();
        System.out.println(m.banner());
        double preco;
        boolean login;
        Produto produto;


        do{
            menuInicial = m.menuInicial();
            switch(menuInicial){
                case 1:
                    //MenuInicial
                    do{
                        menuCli = m.menuCliente();
                        switch(menuCli){
                            case 1:
                                //Fazer login
                                System.out.println("Login do Cliente");
                                System.out.print("CPF: "); cpf = in.nextLine();
                                System.out.print("Senha: "); senha = in.nextLine();
                                login = fachada.loginCliente(cpf, senha);
                                if(login){
                                    do{
                                        menuCliAuth = m.menuClienteAutenticado();
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
                                                m.percorreLista(fachada.visualizarProdutos());
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
                                                m.percorreLista(fachada.visualizarCarrinho());
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
                                                menuCliAuth = m.menuClienteAutenticado();
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
//                                UsuarioCliente novoCliente = new UsuarioCliente(cpf, nome, telefone, senha, p);
//                                fachada.cadastrarCliente(novoCliente);
//                                System.out.println("Usuário "+novoCliente.getNome()+" cadastrado!");
                                break;
                            case 3:
                                System.out.println("Saindo da área do cliente!");
                                break;
                            default:
                                System.out.println("Opção inválida - menuCli()");
                                menuCli = m.menuCliente();
                        }
                    }while (menuCli != 3);
                    break;
                case 2:
                    //MenuInicial
                    do{
                        menuAdm = m.menuAdministrativo();
                        switch(menuAdm){
                            case 1:
                                //Fazer login
                                System.out.println("Login do Administrador");
                                System.out.print("CPF: "); cpf = in.nextLine();
                                System.out.print("Senha: "); senha = in.nextLine();
                                login = fachada.loginAdministrador(cpf, senha);
                                if(login){
                                    do{
                                        menuAdminAuth = m.menuAdministrativoAuth();
                                        switch(menuAdminAuth){
                                            /*
                                            + "1. Cadastrar Produto. \n"
                                            + "2. Alterar quantidade em estoque. \n"
                                            + "3. Remover produto. \n"
                                            + "4. Visualizar catálogo. \n"
                                            + "5. Sair. \n"
                    String nome, String marca, String descricao, double preco, int qtdEstoque
                                            */
                                            case 1:
                                                System.out.println("Cadastrar novo Produto");
                                                System.out.print("Nome do produto: ");
                                                nome = in.nextLine();
                                                System.out.print("Marca do produto: ");
                                                marca = in.nextLine();
                                                System.out.print("Descricao do produto: ");
                                                descricao = in.nextLine();
                                                System.out.print("Preço do produto: ");
                                                preco = in.nextDouble();
                                                System.out.print("Qtd em estoque: ");
                                                qtdEstoque = in.nextInt();
                                                produto = new Produto(nome,marca,descricao,preco,qtdEstoque);
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
                                                m.percorreLista(fachada.visualizarProdutos());
                                                break;
                                            case 5:
                                                fachada.aplicarDescontoAleatorio();
                                                break;
                                            case 6:
                                                System.out.println("Fim programa");
                                                break;
                                            default:
                                                System.out.println("Opção inválida - AdmAuth()");
                                                menuAdminAuth = m.menuAdministrativoAuth();
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
                                AdminUsuario user = new AdminUsuario(cpf, nome, telefone, senha);
                                fachada.cadastarAdministrador(user);
                                System.out.println("Usuário: " + user.getNome() + " cadastrado com sucesso!");
                                break;
                            case 3:
                                System.out.println("Saindo da área do administrador!");
                                break;
                            default:
                                System.out.println("Opção inválida - menuAdm()");
                                menuAdm = m.menuAdministrativo();
                        }
                        //Código admin
                    } while(menuAdm != 3);
                    break;
                case 3:
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida - menuInicial()");
                    menuInicial = m.menuInicial();
            }
        }while(menuInicial != 3);
    } //fim main
}
