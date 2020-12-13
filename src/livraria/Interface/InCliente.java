package livraria.Interface;


import livraria.exceptions.ExisteProdutoExcecao;
import livraria.model.ClienteUsuario;
import livraria.model.Produto;

import java.util.List;

public interface InCliente {
    boolean cadastrar(ClienteUsuario cliente);
    boolean remover(String CPF);
    int buscar(String CPF);
    boolean login(String CPF, String senha);
    List visualizarCarrinho() throws ExisteProdutoExcecao;
    boolean adicionarItemCarrinho(Produto produto);
    boolean removerItemCarrinho(Produto produto);
    boolean finalizarCompra();
}
