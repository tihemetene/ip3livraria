package livraria;


/**
 *
 * @author Rodolfo
 */



public class Funcionario extends Usuario {

    private double salario;
    private String funcao, matricula;
    private final boolean isAdmin;

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
        try {
            if (salario > 1000.0) {
                this.salario = salario;
            }
        } catch (IllegalArgumentException erro) {
            System.out.println("salario nao pode ser menor do que 1000");
        }
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        try {
            if (funcao != "" || funcao != null) {
                this.funcao = funcao;
            }
        } catch (NullPointerException erro) {
            System.out.println("funcao nao pode ser nula");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        try {
            if (matricula != "" || matricula != null) {
                this.matricula = funcao;
            }
        } catch (NullPointerException erro) {
            System.out.println("matricula nao pode ser nula");
        }
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

}
