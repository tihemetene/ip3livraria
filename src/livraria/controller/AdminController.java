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
        return this.repoAdmin.cadastro(User);
    }

    public boolean login(String CPF, String senha){
        return this.repoAdmin.login(CPF, senha);
    }
}
