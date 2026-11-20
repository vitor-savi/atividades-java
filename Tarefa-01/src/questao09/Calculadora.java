package questao09;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double a = Double.parseDouble(entrada.nextLine().trim().replace(',', '.'));

        System.out.print("Digite o segundo número: ");
        double b = Double.parseDouble(entrada.nextLine().trim().replace(',', '.'));

        System.out.print("Digite a operação (+, -, /, X): ");
        String operacao = entrada.nextLine().trim();

        switch (operacao) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Não é possível dividir por zero.");
                } else {
                    System.out.println(a / b);
                }
                break;
            case "X":
            case "x":
                System.out.println(a * b);
                break;
            default:
                System.out.println("Operação inválida. Use +, -, / ou X.");
        }

        entrada.close();
    }
}
