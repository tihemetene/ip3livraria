package livraria.model;

import java.util.ArrayList;

public class FactoryProduto {
    ArrayList<Produto> lista;

    Produto produto;


    public Produto getProduto(String nome, String descricao, double preco, int qtdEstoque, int  codigo, int tipo){

        if(tipo== 1){
            return new Livro (nome, descricao, preco, qtdEstoque, codigo,tipo);
        }if(tipo == 2){
            return new Jogo (nome, descricao, preco, qtdEstoque, codigo,tipo);
        }

        return null;
    }

    @Override
    public String toString() {
        return "Nome: " + produto.getNome() +
                "Descrição: "+ produto.getDescricao() +
                "Preço: "+ produto.getPreco() +
                "Estoque: "+ produto.getQtdEstoque() +
                "Codigo de Barras: "+ produto.getCodigo();
    }
}
