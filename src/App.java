import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("************************************************");
            System.out.println("***     Manipulando Cadeia de Caracteres       ***".toUpperCase());
            System.out.println("*______________________________________________*");
            System.out.println("*Escolha umas das opções abaixo:               *");
            System.out.println("* (1) - Contar quantas vezes a letra 'a'       *");
            System.out.println("* (2) - Inverter uma palavra digitada          *");
            System.out.println("* (3) - Verificar se a palavra é um palíndromo *");
            System.out.println("* (4) - Substituir uma letra por outra         *");
            System.out.println("* (5) - Contar número de vogais na palavra     *");
            System.out.println("* (0) - Para sair                              *");
            System.out.println("************************************************");

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Escreva o texto: ");
            String texto = scanner.nextLine();

            switch (opcao) {
                case 1:
                    int quantidade = contarLetras(texto.toLowerCase(), 'a');
                    System.out.println("Existem " + quantidade + " de letras 'a'");
                    break;
                case 2:
                    String invertido = inverter(texto);
                    System.out.println("O texto invertido é: " + invertido);
                    break;
                case 3:
                    boolean resposta = palindromo(texto);
                    if (resposta) {
                        System.out.println("A palavra é um palíndromo");
                    } else {
                        System.out.println("A palavra não é um palíndromo");
                    }
                    break;
                case 4:
                    System.out.print("Escreva a letra que você gostaria de substituir: ");
                    String letraAntiga = scanner.nextLine();
                    System.out.print("Escreva a nova letra: ");
                    String letraNova = scanner.nextLine();
                    System.out.println("A letras foram trocadas: " + texto.replace(letraAntiga, letraNova));
                    break;
                case 5:
                    contarVogais(texto.toLowerCase());
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }
        scanner.close();
    }

    public static int contarLetras(String cadeia, char palavra) {
        int contador = 0;
        if (cadeia.trim().length() == 0) {
            return 0;
        } else {
            for (int i = 0; i < cadeia.length(); i++) {
                if (cadeia.charAt(i) == palavra) {
                    contador += 1;
                }
            }
        }
        return contador;

    }

    public static String inverter(String cadeia) {
        String invertida = "";
        if (cadeia.trim().length() == 0) {
            return "ERRO: Texto não informado.";
        } else {
             StringBuilder reversedStrBuilder = new StringBuilder(cadeia);
             invertida = reversedStrBuilder.reverse().toString();
        }
        return invertida;
    }

    public static boolean palindromo(String cadeia) {
        String palindromo;
        if (cadeia.trim().length() == 0) {
            return false;
        } else {
            StringBuilder reversedStrBuilder = new StringBuilder(cadeia.trim().toLowerCase());
            palindromo = reversedStrBuilder.reverse().toString();

        }
        return cadeia.trim().toLowerCase().equals(palindromo);
    }

    public static void contarVogais(String cadeia) {
        int[] contador = new int[5];
        if (cadeia.trim().length() == 0) {
            System.out.println("Erro: Texto não existe !");
        } else {
            for (int i = 0; i < cadeia.length(); i++) {
                if (cadeia.charAt(i) == 'a') {
                    contador[0] += 1;
                } else if (cadeia.charAt(i) == 'e') {
                    contador[1] += 1;
                } else if (cadeia.charAt(i) == 'i') {
                    contador[2] += 1;
                } else if (cadeia.charAt(i) == 'o') {
                    contador[3] += 1;
                } else if (cadeia.charAt(i) == 'u') {
                    contador[4] += 1;
                }
            }
        }
        System.out.println("O número de vogais 'a' é: " + contador[0]);
        System.out.println("O número de vogais 'e' é: " + contador[1]);
        System.out.println("O número de vogais 'i' é: " + contador[2]);
        System.out.println("O número de vogais 'o' é: " + contador[3]);
        System.out.println("O número de vogais 'u' é: " + contador[4]);

    }
}
