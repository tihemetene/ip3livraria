package livraria;
import java.util.Scanner;
public class Catalogo {
    private Produtos[] produtos;
    private int total;
    private boolean estaOrdenado;
    public static final int TOTAL_LIVROS = 1000;
    public void Produtos() {
        produtos = new Produtos[TOTAL_LIVROS];
    }

    public void cadastrar(String cod) {
        Scanner in = new Scanner(System.in);
        int pos, qtd;
        String titulo;
        int volume;
        pos = consultar(cod);
        if (pos == -1) {
            System.out.println("Informe o título do livro: ");
            titulo = in.nextLine();
            produtos[total] = new Produtos(cod, titulo);
            System.out.println("Informe o volume do livro: ");
            volume = in.nextInt();
            produtos[total].setVolume(volume);
            System.out.println("Informe a quantidade em estoque: ");
            qtd = in.nextInt();
            produtos[total].setQtd(qtd);
            total++;
            estaOrdenado = false;
            System.out.println("registro efetuado ");
        } else {
            System.out.println("registro não efetuado, livro já encontrado armazenado");
        }

    }
    
    public void exibir(String cod){
        
    }

    public int consultar(String cod) {
        int pos;
        if (estaOrdenado == true) {
            pos = buscaBinaria(cod);
        } else {
            pos = buscaSimples(cod);
        }
        return pos;
    }

    public int buscaSimples(String cod) {
        boolean achou = false;
        String matr;
        int i;
        for (i = 0; i < total; i++) {
            matr = produtos[i].getCod();
            if (matr.compareToIgnoreCase(cod) == 0) {
                achou = true;
                break;
            }
        }
        if (achou == true) {
            return i;
        }
        else {
            return -1;
        }
    }
    
    public int buscaBinaria(String cod){
        int inicio = 0, meio, fim = total -1;
        String matr;
        boolean achou = false;
        do {
            meio = (inicio + fim) / 2;
            matr = produtos[meio].getCod();
            if (matr.compareToIgnoreCase(cod)== 0) {
                achou = true;
                break;
            }
            else if (matr.compareToIgnoreCase(cod) > 0) {
                fim = meio - 1;
            }
            else {
                inicio = meio + 1;
            }
        } while (inicio <= fim);
        if (achou == true){
            return meio;
        }
        else {
            return -1;
        }
    }
    public void exibir(){
        for(int i = 0; i < total; i++){
            System.out.println(produtos[i].toString());
        }
    }
    public void ordenaCod(){
        int i,j, fim = total - 1;
        String chave, m, n;
        for(i = 1; i <= fim; i++){
            chave = produtos[i].getCod();
            j = i - 1;
            m = produtos[j].getCod();
            while(j >= 0 && m.compareTo(chave) > 0){
                n = m;
                j = j - 1;
            }
            n = chave;
        }
    }
    
}
