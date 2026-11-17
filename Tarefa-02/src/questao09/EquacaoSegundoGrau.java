package questao09;

import java.util.Scanner;

// Questão 9 - Equação do segundo grau (Bhaskara)
public class EquacaoSegundoGrau {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Equação: ax² + bx + c = 0");
        System.out.print("Informe o coeficiente a: ");
        double a = teclado.nextDouble();
        System.out.print("Informe o coeficiente b: ");
        double b = teclado.nextDouble();
        System.out.print("Informe o coeficiente c: ");
        double c = teclado.nextDouble();

        double delta = Math.pow(b, 2) - 4 * a * c;

        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);

        System.out.printf("x = %.2f e x = %.2f%n", x1, x2);

        teclado.close();
    }
}
