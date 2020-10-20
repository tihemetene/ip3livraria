package livraria;


public class Carrinho {
    private double totalPagar;
    private List<Produtos> produtos;


    public Carrinho() {
        this.produtos = new ArrayList<Produto>();
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public void adicionar(Produtos p) {
        this.produtos.add(p);
    }

    public void remover(int pos) {
        this.produtos.remove(pos);
    }

}