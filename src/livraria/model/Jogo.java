package livraria.model;

public class Jogo extends Produto{

    public Jogo(String nome, String editora, String descricao, double preco, int qtdEstoque, String codBarras, int tipo) {
        super(nome, editora, descricao, preco, qtdEstoque, codBarras, tipo);
    }

    @Override
    public String toString() {
        return "Nome " +this.nome+ "Descrição: " +this.descricao+ "Preço: "+this.preco;
    }
}
