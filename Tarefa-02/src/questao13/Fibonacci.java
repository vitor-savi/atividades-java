package questao13;

import java.util.Scanner;

// Questão 13 - Série de Fibonacci
public class Fibonacci {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe um número inteiro positivo: ");
        int limite = teclado.nextInt();

        int anterior = 0;
        int atual = 1;

        System.out.print("Série de Fibonacci: " + anterior);

        while (atual <= limite) {
            System.out.print(", " + atual);
            int proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        System.out.println();

        teclado.close();
    }
}
