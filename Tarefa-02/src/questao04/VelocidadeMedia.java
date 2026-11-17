package questao04;

import java.util.Scanner;

// Questão 4 - Velocidade média
public class VelocidadeMedia {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe a distância percorrida (Km): ");
        double distancia = teclado.nextDouble();

        System.out.print("Informe o tempo gasto na viagem (horas): ");
        double tempo = teclado.nextDouble();

        double velocidade = distancia / tempo;
        System.out.printf("Velocidade média: %.2f Km/h%n", velocidade);

        teclado.close();
    }
}
