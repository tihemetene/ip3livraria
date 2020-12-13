package livraria.controller;

import livraria.Interface.InFachada;
import livraria.exceptions.ExisteProdutoExcecao;
import livraria.model.AdminUsuario;
import livraria.model.ClienteUsuario;
import livraria.model.Produto;

import java.util.List;

public class Fachada implements InFachada {

    ClienteController controladorCliente;
    ProdutoController controladorProduto;
    AdminController controladorAdministrador;

    public Fachada(){
        this.controladorCliente = new ClienteController();
        this.controladorProduto = new ProdutoController();
        this.controladorAdministrador = new AdminController();
    }

    @Override
    public boolean cadastrarCliente(ClienteUsuario cliente) {
        return this.controladorCliente.cadastrar(cliente);
    }

    @Override
    public boolean removerCliente(String CPF) {
        return this.controladorCliente.remover(CPF);
    }

    @Override
    public boolean cadastarAdministrador(AdminUsuario administrador) {
        return this.controladorAdministrador.cadastro(administrador);
    }

    @Override
    public boolean cadastrarProdutos(Produto produto) {
        return this.controladorProduto.cadastrarProduto(produto);
    }

    @Override
    public boolean alterarQuantidade(int codigo, int quantidade) {
        return this.controladorProduto.alterarQuantidade(codigo, quantidade);
    }

    @Override
    public List visualizarProdutos() throws ExisteProdutoExcecao {
        return this.controladorProduto.listarProdutos();
    }

    @Override
    public boolean removerProduto(int codigo) {
        return this.controladorProduto.removerProduto(codigo);
    }

    @Override
    public boolean loginCliente(String CPF, String senha) {
        return this.controladorCliente.login(CPF, senha);
    }

    @Override
    public boolean adicionarProdutoCarrinho(int codigo) {
        Produto produto = this.controladorProduto.retornarProduto(codigo);
        if(produto != null){
            return this.controladorCliente.adicionarItemCarrinho(produto);
        }else{
            return false;
        }
    }


    @Override
    public boolean removerItemCarrinho(int codigo) {
        Produto produto = this.controladorProduto.retornarProduto(codigo);
        if(produto != null){
            return this.controladorCliente.removerItemCarrinho(produto);
        }else{
            return false;
        }
    }

    @Override
    public boolean loginAdministrador(String CPF, String senha) {
        return this.controladorAdministrador.login(CPF, senha);
    }

    @Override
    public boolean cadastrarProduto(Produto produto) {
        return this.controladorProduto.cadastrarProduto(produto);
    }

    @Override
    public List visualizarCarrinho() throws ExisteProdutoExcecao {
        return this.controladorCliente.visualizarCarrinho();
    }

    @Override
    public boolean finalizarCompra() {
        return this.controladorCliente.finaliarCompra();
    }

    @Override
    public boolean aplicarDescontoAleatorio() {
        return this.controladorProduto.aplicarDescontoAleatorio();
    }

}
