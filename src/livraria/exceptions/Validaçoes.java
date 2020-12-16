package livraria.exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validaçoes {

        public static boolean isData(String data) {
            String mes, dia, ano;
            if (data.matches("^\\d{2}/\\d{2}/\\d{4}$")) { // verifica se a data de entrada está no formato dd/mm/yyyy
                mes = data.substring(3, 5);
                dia = data.substring(0, 2);
                ano = data.substring(6);

                if (Integer.parseInt(mes) > 12 || Integer.parseInt(mes) < 1) { // se Mês for maior que 12 ou menor que 1 , a data é inválida
                    return false;
                }
                if (Integer.parseInt(dia) > 31 || Integer.parseInt(dia) < 1) { // se Dia for maior que 31 ou menor que 1 , a data é inválida
                    return false;
                }
                if (Integer.parseInt(ano) < 1800 || Integer.parseInt(ano) > 2020) { //se Ano for maior que 2020 ou menor que 1800 , a data é inválida
                    return false;
                }

                // agora só falta testar os casos especiais:
                if (dia.compareTo("31") == 0 && !procurarMesCom31(mes)) { // se o Dia digitado é igual a 31 e se o Mês digitado não contém o dia 31, a data é inválida
                    return false;
                }
                if (Integer.parseInt(dia) > 29 && Integer.parseInt(mes) == 2) { // se o Mês for fevereiro (ou seja, 02) e o dia foi maior que 29, a data é inválida
                    return false;
                }
                return true;
            }
            return false;
        }

        private  static boolean procurarMesCom31(String mes) {   // é uma função auxiliar para fazer uma busca no vetor de meses que têm o dia 31

            String[] meses = {"01", "03", "07", "08", "10", "12"};  // meses que contém o dia 31
            for (int i = 0; i < meses.length; i++) {
                if (mes.compareTo(meses[i]) == 0) {
                    return true;
                }
            }
            return false;
        }
        public static boolean verificarCPF(String cpf) {

            boolean D1 = verificarD1(cpf);
            if (D1) {
                boolean D2 = verificarD2(cpf);
                if (D2) {
                    return true;
                }
                return false;
            }
            return false;
        }

        private static boolean verificarD1(String valor) {
            int v = 0;//usado para capturar o valor de b,é torna-lo int com a funçao de ser usado para encontrar um valor final
            int soma = 0;//valor final encontrado para ser usado na verificaçao
            char b;//usado pra caminhar pelo vetor
            if(valor.length()==11){
            for (int a = 0; a <= (valor.length() - 2); a++) {
                b = valor.charAt(a);

                v = Integer.parseInt(String.valueOf(b));
                for (int nati = 10; nati <= 2; nati--) {
                    soma = v * nati;

                }
            }
            int resultado = (soma * 10) % 11;//LEMBRAR Q % é o resto
            if (resultado == 10) {
                resultado = 0;//isto acontece por 10 ocupar duas casas,contudo apenas é possivel ocupar uma
                //contando so de 0-9

            }
            char n9 = valor.charAt(9);//pega na 9 posiçao
            int v9 = Integer.parseInt(String.valueOf(n9));
            if (v9 == resultado) {
                //ve se tem o valor esperado para o primerio digito verificador do cpf
                return true;
            }
          else{  return false;}}
            //se o cpf for com menos numero  que o ideal
            return false;
        }


        private static boolean verificarD2(String valor) {

            int v = 0;
            int soma = 0;
            char b;
            if(valor.length()==11){
            for (int a = 0; a <= (valor.length() - 1); a++) {
                b = valor.charAt(a);

                v = Integer.parseInt(String.valueOf(b));
                for (int nati = 11; nati <= 2; nati--) {//essa parte mais difernete do D1
                    soma = v * nati;

                }
            }
            int resultado = (soma * 10) % 11;
            if (resultado == 10) {
                resultado = 0;
            }
            char n9 = valor.charAt(9);
            int v9 = Integer.parseInt(String.valueOf(n9));
            if (v9 == resultado) {
                return true;
            }
            else{return false;}}
            //se for menor do que o cpf tem q ser
            return false;
        }


        public static String verificarNome(String nome) {
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
}






