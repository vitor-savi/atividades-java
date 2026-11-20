package tarefa07.questao05;

import java.util.Scanner;

public class SomaMedia {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double soma = 0;
        int quantidade = 0;

        System.out.println("Informe os números na sequencia solicitada.");
        System.out.println("Para sair digite 'S'");

        while (true) {
            System.out.print("Numero " + (quantidade + 1) + "=");
            String texto = entrada.nextLine().trim();

            if (texto.equalsIgnoreCase("S")) {
                break;
            }

            try {
                double numero = Double.parseDouble(texto.replace(',', '.'));
                soma += numero;
                quantidade++;
            } catch (NumberFormatException e) {
                System.out.println("Erro de entrada.");
                System.out.println(texto + " não é um numérico válido. Tente novamente ou digite S para sair.");
            }
        }

        System.out.println("A soma dos números digitados é=" + soma);
        if (quantidade > 0) {
            System.out.println("A média dos números digitados é=" + (soma / quantidade));
        } else {
            System.out.println("Nenhum número foi digitado, não é possível calcular a média.");
        }

        entrada.close();
    }
}
