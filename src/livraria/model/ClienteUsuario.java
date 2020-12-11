package livraria.model;
import livraria.Interface.InObserver;
import java.util.Date;
import livraria.Interface.InSubject;

public class ClienteUsuario extends Usuario implements InObserver {
    InSubject subject;

    public ClienteUsuario(String CPF, String nome, String telefone, String senha,  Date data) {
        super(CPF, nome, telefone, senha, data);
        //this.subject = produto;
    }

    @Override
    public void update(InSubject updatedSubject) {
        this.subject = updatedSubject;
    }

    public String toString() {
        return "CPF: " +this.CPF+ ", Nome: " +this.nome+ ", Telefone: " +this.telefone+ ", Data de ingressão/inscrição: "+this.data;
    }

}
