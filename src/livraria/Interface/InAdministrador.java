package livraria.Interface;

import livraria.model.AdminUsuario;

public interface InAdministrador {
    boolean login(String cpf, String senha);
    boolean cadastro(AdminUsuario User);
}
