package livraria.Interface;

import livraria.model.AdminUsuario;
import livraria.model.ClienteUsuario;
import livraria.model.Produto;

import java.util.List;

public interface InFachada {
    boolean cadastrarCliente(ClienteUsuario cliente);

    boolean removerCliente(String CPF);

    boolean loginCliente(String CPF, String senha);

    boolean cadastarAdministrador(AdminUsuario administrador);

    boolean loginAdministrador(String CPF, String senha);

    boolean cadastrarProdutos(Produto produto);

    boolean alterarQuantidade(int codigo, int quantidade);

    List visualizarProdutos();

    boolean removerProduto(int codigo);

    boolean adicionarProdutoCarrinho(int codigo);

    boolean removerItemCarrinho(int codigo);

    boolean cadastrarProduto(Produto produto);

    List visualizarCarrinho();

    boolean finalizarCompra();

    boolean aplicarDescontoAleatorio();
}
