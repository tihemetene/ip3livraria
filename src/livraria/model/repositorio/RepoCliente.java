package livraria.model.repositorio;

import livraria.Interface.InCliente;
import livraria.exceptions.CPFinvalidoExcecao;
import livraria.exceptions.Validaçoes;
import livraria.model.Carrinho;
import livraria.model.ClienteUsuario;
import livraria.model.Produto;

import java.util.ArrayList;
import java.util.List;


public class RepoCliente implements InCliente {

    private final List<ClienteUsuario> listaClientes = new ArrayList();
    private ClienteUsuario clienteLogado;
    private Carrinho carrinhoCompras;

    @Override
    public boolean cadastrar(ClienteUsuario cliente) {

        if(this.buscar(cliente.getCPF()) != -1){
            return false;
        }
        return this.listaClientes.add(cliente);


    }

    @Override
    public boolean remover(String CPF) {
        if(this.buscar(CPF) == -1){
            return false;//cpf nao encontrado
        }
        this.listaClientes.remove(this.buscar(CPF));//cpf encontrado
        return true;
    }

    @Override
    public int buscar(String CPF){

        if (this.listaClientes.isEmpty()) {
            return -1;
        }//este cpf nao esta na lista
        for(int i = 0; i < this.listaClientes.size(); i++){
            if(this.listaClientes.get(i).getCPF().compareTo(CPF) == 0){
                return i;
            }
        }//este cpf esta na lista
       return -1;


    }

    @Override
    public boolean login(String CPF, String senha) {
        if(this.buscar(CPF) != -1) {
            int index = this.buscar(CPF);
            if(this.listaClientes.get(index).getSenha().equalsIgnoreCase(senha)){
                this.clienteLogado = this.listaClientes.get(index);
                this.carrinhoCompras = new Carrinho();
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public List visualizarCarrinho() {

        return this.carrinhoCompras.visualizarCarrinho();
    }

    @Override
    public boolean adicionarItemCarrinho(Produto produto) {
        return this.carrinhoCompras.adicionarItem(produto);
    }

    @Override
    public boolean removerItemCarrinho(Produto produto) {
        return this.carrinhoCompras.removerItem(produto);
    }

    @Override
    public boolean finalizarCompra() {
        return this.carrinhoCompras.finalizarCompra();
    }

    @Override
    public double valorCompra() {
        return this.carrinhoCompras.valorCompra();
    }

}
