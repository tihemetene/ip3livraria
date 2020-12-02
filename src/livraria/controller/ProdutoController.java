package livraria.controller;

import livraria.Interface.InProduto;
import livraria.model.Produto;
import livraria.model.repositorio.Desconto;
import livraria.model.repositorio.RepoProduto;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoController {

    private final InProduto repositorioProduto;

    public ProdutoController(){
        this.repositorioProduto = (InProduto) new RepoProduto();
    }

    public boolean cadastrarProduto(Produto produto){
        return this.repositorioProduto.cadastrarProduto(produto);
    }

    public boolean alterarQuantidade(int codigo, int quantidade){
        return this.repositorioProduto.alterarQuantidade(codigo, quantidade);
    }

    public List listarProdutos(){
        return this.repositorioProduto.listarProdutos();
    }

    public boolean removerProduto(int codigo){
        return this.repositorioProduto.removerProduto(codigo);
    }

    public int buscarProcuto(int codigo) {
        return this.repositorioProduto.buscarProduto(codigo);
    }

    public Produto retornarProduto(int codigo){
        return this.repositorioProduto.retornarProduto(codigo);
    }

    public boolean aplicarDescontoAleatorio(){
        Desconto descontoProduto = new Desconto((RepoProduto)this.repositorioProduto);
        Thread concorrencia = new Thread(descontoProduto);
        concorrencia.start();

        try {
            concorrencia.join();
            return true;
        } catch (InterruptedException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
