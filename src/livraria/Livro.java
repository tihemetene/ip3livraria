package livraria;
import livraria.model.Produto;


public class Livro extends Produto {
    private String ISBN;
    private String titulo, editora, descricao;
    private int numero_Paginas;

    public Livro (String ISBN, String titulo, String editora, String descricao, String cod) {
        super(cod);
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.editora = editora;
        this.descricao = descricao;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        try {
            if (ISBN != null || ISBN != "") {
                this.ISBN = ISBN;
            }
        } catch (NullPointerException erro) {
            System.out.println("ISBN não pode ser nulo");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        try {
            if (titulo != null || titulo != "") {
                this.titulo = titulo;
            }
        } catch (NullPointerException erro) {
            System.out.println("titulo não pode ser nulo");
        }
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        try {
            if (editora != null || editora != "") {
                this.editora = editora;
            }
        } catch (NullPointerException erro) {
            System.out.println("editora não pode ser nulo");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        try {
            if (descricao != null || descricao != "") {
                this.descricao = descricao;
            }
        } catch (NullPointerException erro) {
            System.out.println("descricao não pode ser nulo");
        }
    }

    public int getNumero_Paginas() {
        return numero_Paginas;
    }

    public void setNumero_Paginas(int numero_Paginas) {
        try {
            if (numero_Paginas > 1) {
                this.numero_Paginas = numero_Paginas;
            }
        } catch (IllegalArgumentException erro) {
            System.out.println("numero de paginas não pode ser 0");
        }
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
