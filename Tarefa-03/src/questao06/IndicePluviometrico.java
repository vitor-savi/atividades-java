package questao06;

import java.util.Scanner;

// Questão 6 - Índice pluviométrico da semana
public class IndicePluviometrico {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String[] dias = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        double[] indices = new double[7];

        for (int i = 0; i < indices.length; i++) {
            System.out.print("Índice pluviométrico de " + dias[i] + ": ");
            indices[i] = teclado.nextDouble();
        }

        double soma = 0;
        int diaMaximo = 0;
        int diaMinimo = 0;

        for (int i = 0; i < indices.length; i++) {
            soma += indices[i];

            if (indices[i] > indices[diaMaximo]) {
                diaMaximo = i;
            }
            if (indices[i] < indices[diaMinimo]) {
                diaMinimo = i;
            }
        }

        System.out.printf("Índice médio: %.2f%n", soma / indices.length);
        System.out.printf("Índice máximo: %.2f (%s)%n", indices[diaMaximo], dias[diaMaximo]);
        System.out.printf("Índice mínimo: %.2f (%s)%n", indices[diaMinimo], dias[diaMinimo]);

        teclado.close();
    }
}
