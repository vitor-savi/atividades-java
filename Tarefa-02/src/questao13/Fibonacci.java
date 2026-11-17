package questao13;

import java.util.Scanner;

/**
 * Questão 13 - Lê um número inteiro positivo e imprime a série de Fibonacci
 * (0, 1, 1, 2, 3, 5, 8, 13, 21, ...) até que o número da série seja maior
 * que o número fornecido pelo usuário.
 */
public class Fibonacci {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe um número inteiro positivo: ");
        long limite = teclado.nextLong();

        while (limite < 0) {
            System.out.print("O número deve ser positivo. Informe novamente: ");
            limite = teclado.nextLong();
        }

        long anterior = 0;
        long atual = 1;

        System.out.print("Série de Fibonacci: " + anterior);

        while (atual <= limite) {
            System.out.print(", " + atual);
            long proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        System.out.println();

        teclado.close();
    }
}
