package livraria.controller;

import livraria.Interface.InCliente;
import livraria.exceptions.ExisteProdutoExcecao;
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

        boolean cadastrarOK=this.repositorioCliente.cadastrar(cliente);
        if(cadastrarOK){return true;}
        else{return false;}
    }

    public boolean remover(String CPF){
        boolean removerok=this.repositorioCliente.remover(CPF);
        if(removerok){return true;}
        else{return false;}
    }

    public boolean login(String CPF, String senha){

        boolean loginOk = this.repositorioCliente.login(CPF, senha);

        if (loginOk) {
            return true;
        } else {
            return false;
        }
    }

    public List visualizarCarrinho() throws ExisteProdutoExcecao {
        return this.repositorioCliente.visualizarCarrinho();
    }

    public boolean adicionarItemCarrinho(Produto produto){
        boolean addcarinho =this.repositorioCliente.adicionarItemCarrinho(produto);
        if(addcarinho ){return true;}
        else{return false;}
    }

    public boolean removerItemCarrinho(Produto produto){
        boolean removerCarrinho= this.repositorioCliente.removerItemCarrinho(produto);
        if(removerCarrinho){return true;}
        else{return false;}
    }

    public boolean finalizarCompra(){
        boolean  fimcompra= this.repositorioCliente.finalizarCompra();
        if(fimcompra){return true;}
        else{return false;}
    }
    public double valorCompra(){
        double valor=this.repositorioCliente.valorCompra();
return valor;
    }

}
