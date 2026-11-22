package questao03;

import java.util.Scanner;

// Questão 3 - Soma dos números pares
public class SomaPares {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[20];
        int soma = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Informe o número " + (i + 1) + " de 20: ");

            while (!teclado.hasNextInt()) {
                System.out.println("Valor inválido: " + teclado.next() + ". Digite um número inteiro.");
                System.out.print("Informe o número " + (i + 1) + " de 20: ");
            }

            numeros[i] = teclado.nextInt();

            if (numeros[i] % 2 == 0) {
                soma += numeros[i];
            }
        }

        System.out.println("Soma dos números pares: " + soma);

        teclado.close();
    }
}
