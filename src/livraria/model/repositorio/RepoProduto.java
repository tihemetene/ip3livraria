package livraria.model.repositorio;

import livraria.Interface.InProduto;
import livraria.model.Produto;
import livraria.exceptions.ExisteProdutoExcecao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RepoProduto implements InProduto {


    protected List<Produto> listaProdutos = new ArrayList();


    public boolean cadastrarProduto(Produto produto) throws NullPointerException{
        try {
            if (produto != null ) {
                return this.listaProdutos.add(produto);
            }
        } catch (NullPointerException err) {
            System.out.println("A mensagem tava aqui ");
        }
        return false;
    }


    public boolean alterarQuantidade(int codigo, int quantidade) {
        if(this.buscarProduto(codigo) != -1){
            int index = this.buscarProduto(codigo);
            this.listaProdutos.get(index).setQtdEstoque(quantidade);
            return true;
        }
        return false;
    }

    public List listarProdutos() throws ExisteProdutoExcecao {

        if (listaProdutos != null ) {
            System.out.println();
            return Collections.unmodifiableList(listaProdutos);
        }
        return Collections.unmodifiableList(listaProdutos);
    }


    public boolean removerProduto(int codigo) {
        if(buscarProduto(codigo) == -1){
            return false;
        }
        this.listaProdutos.remove(buscarProduto(codigo));
        return true;
    }

    public int buscarProduto(int codigo) {
        for(int i = 0; i < this.listaProdutos.size(); i++){
            if(this.listaProdutos.get(i).getCodigo() == codigo){
                return i;
            }
        }
        return -1;
    }


    public Produto retornarProduto(int codigo) {
        int codigoProduto = this.buscarProduto(codigo);
        if(codigoProduto != -1){
            return this.listaProdutos.get(codigoProduto);
        }else{
            return null;
        }
    }

}
