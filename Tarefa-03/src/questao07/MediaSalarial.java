package questao07;

import java.util.Scanner;

// Questão 7 - Média salarial da empresa
public class MediaSalarial {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int quantidade;
        System.out.print("Quantos funcionários existem na empresa? ");
        while (true) {
            if (teclado.hasNextInt()) {
                quantidade = teclado.nextInt();
                teclado.nextLine();
                if (quantidade > 0) {
                    break;
                }
                System.out.println("A quantidade deve ser maior que zero.");
            } else {
                System.out.println("Valor inválido: " + teclado.nextLine());
            }
            System.out.print("Quantos funcionários existem na empresa? ");
        }

        String[] nomes = new String[quantidade];
        double[] salarios = new double[quantidade];
        double soma = 0;

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Nome do funcionário " + (i + 1) + ": ");
            String nome = teclado.nextLine().trim();
            while (nome.length() < 3) {
                System.out.println("O nome deve ter ao menos 3 caracteres.");
                System.out.print("Nome do funcionário " + (i + 1) + ": ");
                nome = teclado.nextLine().trim();
            }
            nomes[i] = nome;

            System.out.print("Salário de " + nome + ": ");
            while (true) {
                if (teclado.hasNextDouble()) {
                    salarios[i] = teclado.nextDouble();
                    teclado.nextLine();
                    if (salarios[i] > 0) {
                        break;
                    }
                    System.out.println("Salário inválido. Informe novamente.");
                } else {
                    System.out.println("Salário inválido: " + teclado.nextLine() + ". Informe novamente.");
                }
                System.out.print("Salário de " + nome + ": ");
            }

            soma += salarios[i];
        }

        double media = soma / quantidade;
        System.out.printf("Média salarial: %.2f%n", media);

        System.out.println("Funcionários com salário acima da média:");
        for (int i = 0; i < quantidade; i++) {
            if (salarios[i] > media) {
                System.out.printf("%s - %.2f%n", nomes[i], salarios[i]);
            }
        }

        teclado.close();
    }
}
