package Livraria;

/**
 *
 * @author Rodolfo
 */

public class Cliente extends Usuario {

    private String dataDeCadastro;
    private String dataDeAniversario;
    private Endereco enderecoDeEntrega;
    private Endereco enderecoDeFaturamento;

    public Cliente(String nome, String dataDeCadastro, String dataDeAniversario, Endereco enderecoDeEntrega,
                   Endereco enderecoDeFaturamento) {
        super(id, nome, senha);
        this.dataDeAniversario = dataDeAniversario;
        this.dataDeCadastro = dataDeCadastro;
        this.enderecoDeEntrega = enderecoDeEntrega;
        this.enderecoDeFaturamento = enderecoDeFaturamento;
    }


    public void setDataDeAniversario(String dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }
        return String.format("Nome do Cliente: %s " +
                "\nCadastrado desde: %s " +
                "\nData de Aniversário: %s " +
                "\nEndereço de Entrega: %s" +
                "\nEndereço de Faturamento: %s", nome, dataDeCadastro, dataDeAniversario, enderecoDeEntrega, enderecoDeFaturamento);
    }
}
