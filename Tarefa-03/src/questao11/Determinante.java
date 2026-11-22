package questao11;

import java.util.Scanner;

// Questão 11 - Determinante de matriz 3x3
public class Determinante {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double[][] m = new double[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                m[i][j] = teclado.nextDouble();
            }
        }

        // regra de Sarrus
        double determinante = m[0][0] * m[1][1] * m[2][2]
                + m[0][1] * m[1][2] * m[2][0]
                + m[0][2] * m[1][0] * m[2][1]
                - m[0][2] * m[1][1] * m[2][0]
                - m[0][0] * m[1][2] * m[2][1]
                - m[0][1] * m[1][0] * m[2][2];

        System.out.printf("Determinante: %.2f%n", determinante);

        teclado.close();
    }
}
