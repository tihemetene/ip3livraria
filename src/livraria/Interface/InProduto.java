package livraria.Interface;

import livraria.exceptions.CodigoNaoEncontradoException;
import livraria.exceptions.ExisteProdutoExcecao;
import livraria.model.Produto;

import java.util.List;

public interface InProduto {
    boolean cadastrarProduto(Produto produto);

    boolean alterarQuantidade(int codigo, int quantidade);

    List listarProdutos() throws ExisteProdutoExcecao;

    boolean removerProduto(int codigo);

    int buscarProduto(int codigo) throws CodigoNaoEncontradoException;

    Produto retornarProduto(int codigo);
}
