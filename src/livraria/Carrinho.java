package livraria;

/**
 *
 * @author Rodolfo
 */

public class Carrinho {
    private Cliente cliente;
    private Produto produtos;
    private double total;
    private int quantidade;


    public Carrinho(Cliente cliente, Produto produtos) {
        this.cliente = cliente;
        this.produtos = produtos;

    }

    public void comprarItem(int quantidadeComprada) {
        int quantidade = produtos.getQuantidade();

        if ((quantidade - quantidadeComprada) >= 0) {
            int novaQtd = quantidade - quantidadeComprada;
            produtos.setQuantidade(novaQtd);
        } else {
            System.out.println("==> Produto " + produtos.getNome()
                    + " sem estoque suficiente.");
        }
    }

    public double calculaValorTotal() {
        return total = quantidade * produtos.getPreco();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setItemCarrinho(Produto produtos) {
        this.produtos = produtos;
    }

    public Produto getCarrinho() {
        return produtos;
    }

    public String toString() {
        return String.format("Cliente: %s" + "\nDados do Pedido: %s" + "\nTotal Pedido: %.2f", cliente.getNome(), produtos, total);
    }

}