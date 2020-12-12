package livraria.model;
import java.util.ArrayList;
public class FactoryProduto {

    ArrayList<Produto> lista;

    public FactoryProduto(){

    }
    public Produto getProduto(ArrayList<Produto> lista){
        for(int i = 0; i <= lista.size(); i++){
            Produto p = lista.get(i);
            if(p.getTipo() == 1){
                return new Livro (p.getNome(), p.getEditora(),p.getDescricao(), p.getPreco(), p.getQtdEstoque(),p.getCodBarras(),p.getTipo());
            }else if(p.getTipo() == 2){
                return new Jogo (p.getNome(), p.getEditora(),p.getDescricao(), p.getPreco(), p.getQtdEstoque(),p.getCodBarras(),p.getTipo());
            }
        }
        return null;
    }

}