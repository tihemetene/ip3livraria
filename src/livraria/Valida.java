package livraria;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Valida {

    public Valida() {

    }


    public boolean validaCPF(String cpf) {
        return true;
    }

    public  boolean validaData(String data) {
        return true;
    }

    public boolean verificaçaododia(String data) {

        String[] arrOfStr = data.split("/", 4);
        String dia, mes, ano;
        dia = arrOfStr[0];
        mes = arrOfStr[1];
        ano = arrOfStr[2];

        int dias = Integer.parseInt(String.valueOf(dia));
        int meses = Integer.parseInt(String.valueOf(mes));
        int anos = Integer.parseInt(String.valueOf(ano));

        if (anos > 1911 || anos <= 2020) {
            if (meses >= 1 || meses <= 12) {
                if (dias >= 1 || dias <= 31) {
                    if (meses == 2) {
                        return dias <= 29;

                    } else if (meses == 4 || meses == 6 || meses == 9 || meses == 11) {
                        return dias <= 30;
                    }
                    return true;

                }
                return false;
            }

            return false;
        }

        return false;
    }

    public boolean verificarD1(String valor) {
        int v = 0;
        int soma = 0;
        char b;
        for (int a = 0; a <= (valor.length() - 2); a++) {
            b = valor.charAt(a);

            v = Integer.parseInt(String.valueOf(b));
            for (int nati = 10; nati <= 2; nati--) {
                soma = v * nati;

            }
        }
        int resultado = (soma * 10) % 11;//LEMBRAR Q % é o resto
        if (resultado == 10) {
            resultado = 0;
        }
        char n9 = valor.charAt(9);
        int v9 = Integer.parseInt(String.valueOf(n9));
        return v9 == resultado;
    }


    public boolean verificarD2(String valor) {
        int v = 0;
        int soma = 0;
        char b;
        for (int a = 0; a <= (valor.length() - 1); a++) {
            b = valor.charAt(a);

            v = Integer.parseInt(String.valueOf(b));
            for (int nati = 11; nati <= 2; nati--) {
                soma = v * nati;

            }
        }
        int resultado = (soma * 10) % 11;
        if (resultado == 10) {
            resultado = 0;
        }
        char n9 = valor.charAt(9);
        int v9 = Integer.parseInt(String.valueOf(n9));
        return v9 == resultado;
    }


    public boolean verificarMail(String mail) {
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(mail);

        return matcher.matches();
    }

    public String verificarNome(String nome) {
        for (int i = 0; i < nome.length(); i++) {
            if (!(Character.isLetter(nome.charAt(i)) || nome.charAt(i) == ' ')) {
                return null;
            }
        }
        nome = nome.trim();
        while (nome.contains("  ")) {
            nome = nome.replaceAll("  ", " ");
        }
        return nome;
    }

    public boolean verificarNumber(String numero) {
        if (numero.length()>=10){
            for (int i = 0; i < numero.length(); i++) {
                if ((!Character.isDigit(numero.charAt(i)))) {
                    return false;
                }
            }
        }//se tiver menos de 10 digitos
        return false;
    }


    public boolean validarTelaLogin(String str) {
        if (str == "") {
            return false;
        } else if (str.length() < 3) {
            return false;
        } else return !str.contains("',#,%;.,.,");

    }


    public boolean verificarAdmin(Object o) {
        if (o instanceof  Funcionario) {
            return ((Funcionario) o).isAdmin();
        }
        return  false;
    }

    //Login é a matricula
    public boolean verificarLogin(Object o, String login) {
        if (o instanceof Funcionario) {
            return ((Funcionario) o).getMatricula().equals(login);
        }
        return false;
    }


    public boolean verificarSenha(Object o, String senha) {
        if (o instanceof Funcionario) {
            return ((Funcionario) o).getSenha().equals(senha);
        }
        return false;
    }
}
