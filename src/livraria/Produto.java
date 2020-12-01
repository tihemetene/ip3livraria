package livraria;

public class Produto {

    private String cod;
    private String titulo, nome;
    private int volume;
    private int quantidade;
    private double preco;

    public Produto(String cod, String titulo){

        if (cod == null ) {
            this.cod = "0";
        } else {
            this.cod = cod;
        }

        if (titulo == null ) {
            this.titulo = "sem titulo";
        } else {
            this.titulo = titulo;
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
        if (preco <= 0 ) {
            System.out.println("=> Valor não poder ser zero ou menor do que isso");
        }
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0 || quantidade >= 200) {
            System.out.println("==> Quantidade não pode ser vazia.. ou maior do que 100");
        }
        this.quantidade = quantidade;
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
        this.volume = v;
    }

    public void setQtd(int q){
        quantidade = q;
    }
    
    public int getQtd(){
        return quantidade;
    }

}
