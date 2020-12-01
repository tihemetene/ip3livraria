package livraria;

public class Produto {

    private String cod;
    private String titulo, nome;
    private int volume;
    private int quantidade;
    private double preco;

    public Produto(String cod, String titulo){
        try {
            if (cod == null ) {
                this.cod = "0";
            } else {
                this.cod = cod;
            }
        } catch (NullPointerException erro1) {
            System.out.println("[!] Falha Criar Produto" + erro1);
        }

        try {
            if (titulo == null ) {
                this.titulo = "sem titulo";
            } else {
                this.titulo = titulo;
            }
        } catch (NullPointerException erro2) {
            System.out.println("[!] Falha Criar Produto" + erro2);
        }

    }

    public Produto () {

    }

    public Produto(String cod) {
        this.cod = cod;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
      try {
          if (preco >= 1.0) {
              this.preco = preco;
          }
      } catch (IllegalArgumentException erro) {
          System.out.println("[!] Preco não pode ser negativo");
      }
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setCod(String cod) {
        try {
            if (this.cod != "" || this.cod != null) {
                this.cod = cod;
            }
        } catch (NullPointerException erro) {
            System.out.println("[!] código não pode ser nulo");
        }
    }

    public void setTitulo(String titulo) {
        try {
            if(this.titulo != "" || this.titulo != null) {
                this.titulo = titulo;
            }
        } catch (NullPointerException erro) {
            System.out.println("[!] titulo não pode ser nulo");
        }
    }

    public void setNome(String nome) {
        try {
            if(this.nome != "" || this.nome != null) {
                this.nome = nome;
            }
        } catch (NullPointerException erro) {
            System.out.println("[!] nome não pode ser nulo");
        }
    }

    public void setQuantidade(int quantidade) {
        try {
            if (quantidade >= 1.0) {
                this.quantidade = quantidade;
            }
        } catch (IllegalArgumentException erro) {
            System.out.println("[!] quantidade não pode ser negativo");
        }
    }

    public String getCod(){

        return cod;
    }
    public String getNome(){

        return titulo;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Produtos{" +
                "cod='" + cod + '\'' +
                ", titulo='" + titulo + '\'' +
                ", nome='" + nome + '\'' +
                ", volume=" + volume +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }

    public double getVolume()
    {
        return volume;

    }
    
    public void setVolume(int v){
        try {
            if (v >= 1.0) {
                this.volume = v;
            }
        } catch (IllegalArgumentException erro) {
            System.out.println("[!] volume não pode ser negativo");
        }
    }

    public int getQtd(){
        return quantidade;
    }

}
