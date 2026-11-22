package questao13;

import java.util.Scanner;

// Questão 13 - Desvio padrão
public class DesvioPadrao {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n;
        do {
            System.out.print("Informe o número de amostras (mínimo 2): ");
            n = teclado.nextInt();
        } while (n < 2);

        double[] amostras = new double[n];
        double soma = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Amostra " + (i + 1) + ": ");
            amostras[i] = teclado.nextDouble();
            soma += amostras[i];
        }

        double media = soma / n;

        double somaQuadrados = 0;
        for (int i = 0; i < n; i++) {
            somaQuadrados += (amostras[i] - media) * (amostras[i] - media);
        }

        double desvio = Math.sqrt(somaQuadrados / (n - 1));

        System.out.printf("Média: %.2f%n", media);
        System.out.printf("Desvio padrão: %.2f%n", desvio);

        teclado.close();
    }
}
