package livraria.model.repositorio;

import livraria.Interface.InAdministrador;
import livraria.model.AdminUsuario;

import java.util.ArrayList;
import java.util.List;

public class RepoAdmin implements InAdministrador {
    private final List<AdminUsuario> userAdm = new ArrayList<>();

    @Override
    public boolean login(String cpf, String senha) {
        for(int i = 0; i < this.userAdm.size(); i++){
            if(this.userAdm.get(i).getCPF().equalsIgnoreCase(cpf) && this.userAdm.get(i).getSenha().equalsIgnoreCase(senha)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cadastro(AdminUsuario User) {
        if(this.userAdm.contains(User)){
            return false;
        }
        this.userAdm.add(User);
        return true;
    }
}
