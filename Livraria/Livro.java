package Livraria;

public class Livro {
    private String ISBN;
    private String titulo, editora, descricao;
    private int numero_Paginas;


    public void test(String a){]
        this.test = a;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumero_Paginas() {
        return numero_Paginas;
    }

    public void setNumero_Paginas(int numero_Paginas) {
        this.numero_Paginas = numero_Paginas;
    }


    @Override
    public String toString() {
        return "Livro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editora='" + editora + '\'' +
                ", descricao='" + descricao + '\'' +
                ", numero_Paginas=" + numero_Paginas +
                '}';
    }
}
