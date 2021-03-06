package livraria.controller;

import livraria.Interface.InCliente;
import livraria.model.ClienteUsuario;
import livraria.model.Produto;
import livraria.model.repositorio.RepoCliente;

import java.util.List;

public class ClienteController {
    private final InCliente repositorioCliente;

    public ClienteController(){
        this.repositorioCliente = new RepoCliente();
    }

    public boolean cadastrar(ClienteUsuario cliente){
        return this.repositorioCliente.cadastrar(cliente);
    }

    public boolean remover(String CPF){
        return this.repositorioCliente.remover(CPF);
    }

    public boolean login(String CPF, String senha){
        return this.repositorioCliente.login(CPF, senha);
    }

    public List visualizarCarrinho(){
        return this.repositorioCliente.visualizarCarrinho();
    }

    public boolean adicionarItemCarrinho(Produto produto){
        return this.repositorioCliente.adicionarItemCarrinho(produto);
    }

    public boolean removerItemCarrinho(Produto produto){
        return this.repositorioCliente.removerItemCarrinho(produto);
    }

    public boolean finaliarCompra(){
        return this.repositorioCliente.finalizarCompra();
    }
}
