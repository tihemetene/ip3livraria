package livraria.model;
import java.util.Date;

public class AdminUsuario extends Usuario {

    public AdminUsuario(String CPF, String nome, String telefone, String senha, Date data) {
        super(CPF, nome, telefone, senha, data);
    }

    @Override
    public String toString() {
        return "CPF: " +this.CPF+ ", Nome: " +this.nome+ ", Telefone: " +this.telefone+ ", Data de ingressão/inscrição: "+this.data;
    }
}
