package livraria;

/**
 *
 * @author Rodolfo
 */


abstract class Usuario {

    private String nome;
    private String senha;
    private int id;

    public Usuario() {
    	
    }
    
    public  Usuario(int id, String nome, String senha) {
        this.id = id;
        this.senha = senha;
        this.nome = nome;
    }
   
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", id=" + id +
                '}';
    }

   

}
