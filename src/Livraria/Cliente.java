package livraria;

/**
 *
 * @author Rodolfo
 */

public class Cliente extends Usuario {
    
	private String cpf;
    private String dataDeCadastro;
    private String dataDeAniversario;
 
    
    public Cliente() {
    	super();
    }
    
    
    public Cliente(int id, String nome, String senha) {
	super(id, nome, senha);
	this.dataDeAniversario = dataDeAniversario;
	this.dataDeCadastro = dataDeCadastro;
	this.cpf = cpf;
	}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Throwable {
       if (ValidaCpf.isValidCpf(cpf)) {
            this.cpf = cpf;
        } else{
        	throw new Exception("[!] CPF inválido");
       }
    }

    public void setDataDeAniversario(String dataDeAniversario) throws Throwable {
    	
    	if (dataDeAniversario != "" || dataDeAniversario != null) {
    		this.dataDeAniversario = dataDeAniversario;
    	} else {
    		throw new Exception("[!] data inválida");
    	}
    }

    public String getDataDeAniversario() {
        return dataDeAniversario;
    }

    public void setDataDeCadastro(String dataDeCadastro) throws Throwable {
    	
    	if (dataDeCadastro != "" || dataDeCadastro != null) {
    		this.dataDeCadastro = dataDeCadastro;
    	} else {
    		throw new Exception("[!] data inválida");
    	}
    	
        
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }
    
    
    @Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", dataDeCadastro=" + dataDeCadastro + ", dataDeAniversario=" + dataDeAniversario
				+ "]";
	}

          
}
