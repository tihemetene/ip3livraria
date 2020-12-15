package livraria.model;

public class Livro extends Produto {
    public Livro(String nome, String editora, String descricao, double preco, int qtdEstoque, int codigo, int tipo) {
        super(nome, editora, descricao, preco, qtdEstoque, codigo, tipo);
    }

    @Override
    public String toString() {
        return "Nome " +this.nome+ "Editora: "+this.editora+ "Descrição: " +this.descricao+ "Preço: "+this.preco+ "ISBN: "+this.codigo;
    }
}
