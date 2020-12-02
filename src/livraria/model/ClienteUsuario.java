package livraria.model;
import livraria.Interface.InObserver;
import livraria.Interface.InSubject;

public class ClienteUsuario extends Usuario implements InObserver {
    InSubject subject;


    public ClienteUsuario(String CPF, String nome, String telefone, String senha, Produto produto) {
        super(CPF, nome, telefone, senha);
        this.subject = produto;
    }

    @Override
    public void update(InSubject updatedSubject) {
        this.subject = updatedSubject;
    }
}
