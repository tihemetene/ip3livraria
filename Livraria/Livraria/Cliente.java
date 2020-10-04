package Livraria;

public class Cliente extends Usuario  {

    private String cpf;
    private int id;

    public static final String divisor = String.format( "+-----+------------------------+---------------+%n" );
    public static final String header = String.format( "|  %-2s | %-22s | %-13s |%n", "#", "Nome", "CPF" );
    public static final String none = String.format( "| %-44s |%n", "Nenhum cliente encontrado" );

    public Cliente(int id, String nome, String senha, String cpf, int id1) {
        super(id, nome, senha);
        this.cpf = cpf;
        this.id = id1;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        result.append( String.format( "|  %-2s ", this.getId() ) );
        result.append( String.format( "| %-22s ", this.getNome() ) );
        result.append( String.format( "| %-13s |%n", this.getCpf() ) );

        return result.toString();
    }
}
