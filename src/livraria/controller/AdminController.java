package livraria.controller;

import livraria.Interface.InAdministrador;
import livraria.model.AdminUsuario;
import livraria.model.repositorio.RepoAdmin;


public class AdminController {
    private final InAdministrador repoAdmin;

    public AdminController(){
        this.repoAdmin = new RepoAdmin();
    }

    public boolean cadastro(AdminUsuario User){
        boolean controller_C = this.repoAdmin.cadastro(User);
        if(controller_C){
            return true;
        }else
            return false;
    }

    public boolean login(String CPF, String senha){
        boolean login = this.repoAdmin.login(CPF, senha);
        if(login){
            return true;
        }else
            return false;
    }
}
