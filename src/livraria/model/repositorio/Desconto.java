package livraria.model.repositorio;

import livraria.exceptions.ExisteProdutoExcecao;
import livraria.model.Produto;


public class Desconto implements Runnable {
    public RepoProduto repositorioProduto;

    public Desconto(RepoProduto repositorioProduto){
        this.repositorioProduto = repositorioProduto;
    }

    @Override
    public void run() {
        int valorMaximo = 0;
        try {
            valorMaximo = this.repositorioProduto.listarProdutos().size();
        } catch (ExisteProdutoExcecao existeProdutoExcecao) {
            existeProdutoExcecao.printStackTrace();
        }
        int numeroAleatorio = 0;

        do{
            numeroAleatorio = (int)(Math.random()*10);
        }while(numeroAleatorio >= valorMaximo);

        Produto produtoSorteado = this.repositorioProduto.retornarProduto(numeroAleatorio);
        double precoAtual = produtoSorteado.getPreco();
        double novoPreco = precoAtual - precoAtual*0.2;
        produtoSorteado.setPreco(novoPreco);
    }
}
