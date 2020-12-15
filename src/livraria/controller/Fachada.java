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
        boolean cadastrarC_ok = this.controladorCliente.cadastrar(cliente);
        if(cadastrarC_ok){
            return true;
        }else
        return false;
    }

    @Override
    public boolean removerCliente(String CPF) {

        boolean clientelogin=this.controladorCliente.remover(CPF);
       if (clientelogin){
        return true;}
       return false;
    }

    @Override
    public boolean cadastarAdministrador(AdminUsuario administrador) {
boolean admcadastro=this.controladorAdministrador.cadastro(administrador);
if(admcadastro) {
    return true;
}
return false;
    }

    @Override
    public boolean cadastrarProdutos(Produto produto) {

if(produto!=null){
    return this.controladorProduto.cadastrarProduto(produto);
}
       return false;
    }

    @Override
    public boolean alterarQuantidade(int codigo, int quantidade) {

        boolean produto = this.controladorProduto.alterarQuantidade(codigo,quantidade);
if(produto){
        return this.controladorProduto.alterarQuantidade(codigo, quantidade);}
return false;
    }

    @Override
    public List visualizarProdutos() throws ExisteProdutoExcecao {
        List<Produto> listaProdutos=this.controladorProduto.listarProdutos();
        if(listaProdutos.isEmpty()){return null;}
        return this.controladorProduto.listarProdutos();
    }

    @Override
    public boolean removerProduto(int codigo) {
        Produto produto = this.controladorProduto.retornarProduto(codigo);
        if(produto!=null){
        return this.controladorProduto.removerProduto(codigo);}
        else{return false;}
    }

    @Override
    public boolean loginCliente(String CPF, String senha) {
   boolean clientelogin=this.controladorCliente.login(CPF,senha);
   if(clientelogin) {
       return true;
   }
   return false;
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
        boolean loginAdmOk = this.controladorAdministrador.login(CPF, senha);
        if(loginAdmOk){
            return true;
        }
        else
            return false;

    }

    @Override
    public boolean cadastrarProduto(Produto produto) {
        boolean cadastroOk = this.controladorProduto.cadastrarProduto(produto);
        if(cadastroOk){
            return true;
        }else
            return false;

    }

    @Override
    public List visualizarCarrinho() throws ExisteProdutoExcecao{
        return this.controladorCliente.visualizarCarrinho();
    }

    @Override
    public boolean finalizarCompra() {
        boolean finalizar = this.controladorCliente.finalizarCompra();
        if(finalizar){
            return  true;
        }else
            return false;
    }

    @Override
    public double valorCompra(){
        double valor=this.controladorCliente.valorCompra();
        if(valor<=0){return valor;}
        return 0.0;
    }

    @Override
    public boolean aplicarDescontoAleatorio() {
        boolean desc = this.controladorProduto.aplicarDescontoAleatorio();
        if(desc){
            return true;
        }else
            return false;
    }

}
