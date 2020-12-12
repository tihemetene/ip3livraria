package livraria.model;

import livraria.Interface.InObserver;
import livraria.Interface.InSubject;

import java.util.ArrayList;
import java.util.List;

public class Produto implements InSubject {
        protected String codBarras;
        protected String nome;
        protected String descricao;
        protected String editora;
        protected int tipo;
        protected double preco;
        protected int qtdEstoque;
        List <InObserver> listObservers;


    public Produto(String nome, String editora, String descricao, double preco, int qtdEstoque, String codBarras, int tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.listObservers = new ArrayList();
        this.codBarras = codBarras;
        this.editora = editora;
        this.tipo = tipo;


    }


    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
            hasChanged();
        }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setQtdEstoque(int qtdEstoque){
            this.qtdEstoque = qtdEstoque;
        }

        public int getQtdEstoque(){
            return this.qtdEstoque;
        }

        @Override
        public String toString() {
            return "Nome: " + nome + "\n" + "Tipo: " + tipo + "\n"
                    + "Descrição: " + descricao + "\n" + "Preço: " + preco + "\n";
        }

        @Override
        public boolean attach(InObserver observer) {
            return this.listObservers.add(observer);
        }

        @Override
        public boolean detach(InObserver observer) {
            return this.listObservers.remove(observer);
        }

        @Override
        public void hasChanged() {
            notifyObservers();
        }

        @Override
        public void notifyObservers() {
            if(!this.listObservers.isEmpty()){
                for(int i = 0; i < this.listObservers.size(); i++){
                    this.listObservers.get(i).update(this);
                }
            }
        }
}
