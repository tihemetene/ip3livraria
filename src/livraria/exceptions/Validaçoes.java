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
       
        
            public static  boolean verificarCPF(String valor) {
                boolean D1 = verificarD1(valor);
                boolean D2 = verificarD2(valor);
                System.out.println("D1" + D1);
                System.out.println("D2" + D2);

                if (D1 && D2) {
                    return true;
                }
                return false;
            }
        
        private static boolean verificarD1(String valor) {
                int v = 0;
                int soma = 0;
                char b;
                int nati = 10;
                if (valor.length() == 11) {
                    for (int a = 0; a <= 8; a++) {
                        b = valor.charAt(a);
                        v = Integer.parseInt(String.valueOf(b));
                        soma = soma + (v * nati);
                        nati--;
                    }
                    int resultado = (soma * 10) % 11;//LEMBRAR Q % é o resto
                    if (resultado == 10) {
                        resultado = 0;
                    }
                    char n9 = valor.charAt(9);//pega na 9 posiçao
                    int v9 = Integer.parseInt(String.valueOf(n9));
                    if (v9 == resultado) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }

                    private static boolean verificarD2(String valor) {

                        int v = 0;
                        int soma = 0;
                        char b;
                        int nati = 11;
                        if (valor.length() == 11) {
                            for (int a = 0; a <= 9; a++) {
                                b = valor.charAt(a);
                                v = Integer.parseInt(String.valueOf(b));
                                soma = soma + (v * nati);
                                nati--;

                            }
                            int resultado = (soma * 10) % 11;
                            if (resultado == 10) {
                                resultado = 0;
                            }
                            char n9 = valor.charAt(10);
                            int v9 = Integer.parseInt(String.valueOf(n9));
                            if (v9 == resultado) {
                                return true;
                            } else {
                                return false;
                            }
                        }
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






