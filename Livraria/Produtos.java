package Livraria;


public class Produtos {
    private final String cod;
    private final String titulo;
    private int volume;
    private int qtd;
    
    public Produtos(String cod, String titulo){

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

    public String getCod(){

        return cod;
    }
    public String getNome(){

        return titulo;
    }
    public double getVolume()
    {
        return volume;

    }
    
    public void setVolume(int v){
        this.volume = v;
    }

    
    public void setQtd(int q){
        qtd = q;
    }
    
    public int getQtd(){
        return qtd;
    }
    
    @Override
    public String toString(){
        return "Código: " +cod+ " Título: " +titulo+ "Volume: " +volume+ "Estoque: " +qtd;
    }
}
