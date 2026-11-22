package questao12;

import java.util.Scanner;

// Questão 12 - Soma das diagonais
public class SomaDiagonais {

    public static void preencheMatriz(int[][] matriz, Scanner teclado) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = teclado.nextInt();
            }
        }
    }

    // posição 0 = diagonal principal, posição 1 = diagonal secundária
    public static int[] calculaDiagonais(int[][] matriz) {
        int[] somas = new int[2];
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            somas[0] += matriz[i][i];
            somas[1] += matriz[i][n - 1 - i];
        }

        return somas;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe a dimensão da matriz: ");
        int dimensao = teclado.nextInt();

        int[][] matriz = new int[dimensao][dimensao];
        preencheMatriz(matriz, teclado);

        int[] somas = calculaDiagonais(matriz);
        System.out.println("Soma da diagonal principal: " + somas[0]);
        System.out.println("Soma da diagonal secundária: " + somas[1]);

        teclado.close();
    }
}
