package questao08;

import java.util.Scanner;

// Questão 8 - Distância entre dois pontos
public class DistanciaEntrePontos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ponto 1");
        System.out.print("x1: ");
        double x1 = teclado.nextDouble();
        System.out.print("y1: ");
        double y1 = teclado.nextDouble();

        System.out.println("Ponto 2");
        System.out.print("x2: ");
        double x2 = teclado.nextDouble();
        System.out.print("y2: ");
        double y2 = teclado.nextDouble();

        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        System.out.printf("Distância: %.2f%n", distancia);

        teclado.close();
    }
}
