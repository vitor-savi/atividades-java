package questao09;

import java.util.Scanner;

/**
 * Questão 9 - Lê os coeficientes a, b e c de uma equação do segundo grau
 * (ax² + bx + c = 0) e mostra os valores de x usando a fórmula de Bhaskara.
 *
 * Fórmula: x = (-b ± raiz(b² - 4ac)) / 2a
 */
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

        // Somar 0.0 evita que o resultado seja exibido como "-0,00"
        double x1 = (-b + Math.sqrt(delta)) / (2 * a) + 0.0;
        double x2 = (-b - Math.sqrt(delta)) / (2 * a) + 0.0;

        System.out.printf("x = %.2f e x = %.2f%n", x1, x2);

        teclado.close();
    }
}
