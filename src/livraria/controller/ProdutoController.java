package livraria.controller;

import livraria.Interface.InProduto;
import livraria.exceptions.CodigoNaoEncontradoException;
import livraria.exceptions.ExisteProdutoExcecao;
import livraria.model.Produto;
import livraria.model.repositorio.Desconto;
import livraria.model.repositorio.RepoProduto;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoController {

    private final InProduto repositorioProduto;

    public ProdutoController(){
        this.repositorioProduto = new RepoProduto();
    }

    public boolean cadastrarProduto(Produto produto){
        boolean cadastrarP_ok = this.repositorioProduto.cadastrarProduto(produto);
        if(cadastrarP_ok){
            return true;
        }
        else
            return false;
    }

    public boolean alterarQuantidade(int codigo, int quantidade){
        boolean alteraOk = this.repositorioProduto.alterarQuantidade(codigo, quantidade);
        if (alteraOk){
            return true;
        }
        return false;
    }

    public List listarProdutos() throws ExisteProdutoExcecao {
        List<Produto> listaProdutos=this.repositorioProduto.listarProdutos();
        if(listaProdutos.isEmpty()){return null;}
        else {
            return this.repositorioProduto.listarProdutos();
        }
    }

    public boolean removerProduto(int codigo){
        boolean removerP_ok = this.repositorioProduto.removerProduto(codigo);
        if(removerP_ok){
            return true;
        }else{
            return false;
        }
    }

    public int buscarProcuto(int codigo) throws CodigoNaoEncontradoException {
        int buscar = this.repositorioProduto.buscarProduto(codigo);
        if(buscar != -1){
            return this.repositorioProduto.buscarProduto(codigo);
        }else
            return -1;
    }

    public Produto retornarProduto(int codigo){
        Produto produto = this.repositorioProduto.retornarProduto(codigo);
        if(produto!= null) {
            return this.repositorioProduto.retornarProduto(codigo);
        }else
            return null;
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
