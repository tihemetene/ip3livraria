package livraria.model;

import livraria.Interface.InObserver;
import livraria.Interface.InSubject;

import java.util.ArrayList;
import java.util.List;

public class Produto implements InSubject {
        private int codigo;
        private String nome;
        private String marca;
        private String descricao;
        private double preco;
        private int qtdEstoque;
        List <InObserver> listObservers;

        public Produto(String nome, String marca, String descricao, double preco, int qtdEstoque) {
            this.nome = nome;
            this.marca = marca;
            this.descricao = descricao;
            this.preco = preco;
            this.qtdEstoque = qtdEstoque;
            this.listObservers = new ArrayList();
        }

        public int getCodigo() {
            return this.codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
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

        public void setQtdEstoque(int qtdEstoque){
            this.qtdEstoque = qtdEstoque;
        }

        public int getQtdEstoque(){
            return this.qtdEstoque;
        }

        @Override
        public String toString() {
            return "\n" + "Código: " + codigo + "\n" + "Nome: " + nome + "\n" + "Marca: " + marca + "\n"
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
