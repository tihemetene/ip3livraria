package livraria.model.repositorio;

import livraria.model.Produto;


public class Desconto implements Runnable {
    public RepoProduto repositorioProduto;

    public Desconto(RepoProduto repositorioProduto){
        this.repositorioProduto = repositorioProduto;
    }

    @Override
    public void run() {
        int valorMaximo = this.repositorioProduto.listarProdutos().size();
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
