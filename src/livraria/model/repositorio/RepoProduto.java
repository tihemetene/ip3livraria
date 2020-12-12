package livraria.model.repositorio;
import livraria.model.FactoryProduto;
import livraria.model.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RepoProduto {
    protected List<Produto> listaProdutos = new ArrayList();


    public boolean cadastrarProduto(Produto produto) {
        return this.listaProdutos.add(produto);
    }


    public boolean alterarQuantidade(String codigo, int quantidade) {
        if(this.buscarProduto(codigo) != -1){
            int index = this.buscarProduto(codigo);
            this.listaProdutos.get(index).setQtdEstoque(quantidade);
            return true;
        }
        return false;
    }

    public List listarProdutos() {
        return Collections.unmodifiableList(listaProdutos);
    }


    public boolean removerProduto(String codigo) {
        if(buscarProduto(codigo) == -1){
            return false;
        }
        this.listaProdutos.remove(buscarProduto(codigo));
        return true;
    }

    public int buscarProduto(String codigo) {
        for(int i = 0; i < this.listaProdutos.size(); i++){
            if(this.listaProdutos.get(i).getCodBarras().equalsIgnoreCase(codigo)){
                return i;
            }
        }
        return -1;
    }


    public Produto retornarProduto(String codigo) {
        int codigoProduto = this.buscarProduto(codigo);
        if(codigoProduto != -1){
            return this.listaProdutos.get(codigoProduto);
        }else{
            return null;
        }
    }

    //FactoryProduto factory = new FactoryProduto();


}
