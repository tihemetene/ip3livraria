package Livraria;


/**
 *
 * @author Rodolfo
 */

public class Cliente extends Usuario {
    private String cpf;
    private String dataDeCadastro;
    private String dataDeAniversario;


    public Cliente(String nome, String dataDeCadastro, String dataDeAniversario, String cpf) {
        super(id, nome, senha);
        this.dataDeAniversario = dataDeAniversario;
        this.dataDeCadastro = dataDeCadastro;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
       if (ValidaCpf.isValidCpf(cpf)) {
            this.cpf = cpf;
        } else{
            System.out.println("==> CPF no formato inválido")
       }
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
                "", nome, dataDeCadastro, dataDeAniversario);
    }
}
