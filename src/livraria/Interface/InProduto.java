package livraria.Interface;

import livraria.model.Produto;

import java.util.List;

public interface InProduto {
    boolean cadastrarProduto(Produto produto);

    boolean alterarQuantidade(int codigo, int quantidade);

    List listarProdutos();

    boolean removerProduto(int codigo);

    int buscarProduto(int codigo);

    Produto retornarProduto(int codigo);
}
