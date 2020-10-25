package livraria

/**
 *
 * @author Rodolfo
 */

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

public class Estoque {

    private ArrayList<Produtos> produtos = new ArrayList<Item>();

    public void cadastraItem(Produto p){
        this.itens.add(item);
        System.out.println("Quantidade Total do "+ item.getNome() + " em estoque: "+ p.getQuantidade());
    }

    public void removeItem(Produto p, int quantidade){
        int i = p.getQuantidade() - quantidade;
        System.out.println("Quantidade Total do "+ p.getNome() + " em estoque após remover: "+ i);
    }

    public void quantidadeTotal(Produto p){
        int total = p.getQuantidade();
        System.out.println(total);
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Estoque (Total de Itens: "+ itens.size() + ") \n");

        for(Produtos p:produtos){
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }
}
