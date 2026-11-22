package questao09;

import java.util.Scanner;

// Questão 9 - Usa a classe Circunferencia
public class UsaCircunferencia {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe o raio da circunferência: ");
        double raio = teclado.nextDouble();

        Circunferencia circunferencia = new Circunferencia(raio);
        System.out.printf("Área: %.2f%n", circunferencia.calculaArea());

        circunferencia.setRaio(10);
        System.out.printf("Área com raio %.2f: %.2f%n", circunferencia.getRaio(), circunferencia.calculaArea());

        teclado.close();
    }
}
