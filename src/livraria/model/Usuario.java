package livraria.model;
import java.util.Date;

public abstract class Usuario {
    protected String CPF;
    protected String nome;
    protected String telefone;
    protected String senha;
    protected String tipo;
    protected Date data;

    public Usuario(String CPF, String nome, String telefone, String senha, Date data) {
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.data = data;
    }


    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = new Date();
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

}
