package questao02;

import java.util.Scanner;

// Questão 2 - Média dos valores digitados
public class MediaArgumentos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double soma = 0;
        int quantidade = 0;
        String valores = "";

        while (true) {
            System.out.print("Informe um valor (S para encerrar): ");

            if (teclado.hasNextDouble()) {
                double valor = teclado.nextDouble();
                soma += valor;
                quantidade++;
                valores += String.format("%.2f ", valor);
            } else {
                String entrada = teclado.next();
                if (entrada.equalsIgnoreCase("S")) {
                    break;
                }
                System.out.println("Valor inválido: " + entrada + ". Informe novamente.");
            }
        }

        if (quantidade == 0) {
            System.out.println("Nenhum valor válido foi informado.");
        } else {
            System.out.println("Valores digitados: " + valores);
            System.out.printf("Média: %.2f%n", soma / quantidade);
        }

        teclado.close();
    }
}
