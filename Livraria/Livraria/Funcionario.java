package Livraria;


/**
 *
 * @author Rodolfo
 */



public class Funcionario extends Usuario {

    private double salario;
    private String funcao, matricula;
    private boolean isAdmin;

    public Funcionario(int id, String nome, String senha, double salario, String funcao, String matricula, boolean isAdmin) {
        super(id, nome, senha);
        this.salario = salario;
        this.funcao = funcao;
        this.matricula = matricula;
        this.isAdmin = isAdmin;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "funcao='" + funcao + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }

    public void mostrarDadosFunc() {
        if (this.getMatricula() != "") {
            System.out.println("[+] Funcionario: " + this.getNome() + " Funçao: " + this.getFuncao() + " " + this.getMatricula());
        }
    }

    /*
    * Fazer metodos abaixo
    * ==> alterarDadosFuncionario, BuscarFuncionario
    *
    *
    * */
}
