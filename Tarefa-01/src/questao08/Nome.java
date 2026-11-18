package questao08;

import java.util.Scanner;

public class Nome {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu nome completo: ");
        String nomeCompleto = entrada.nextLine().trim();

        if (nomeCompleto.isEmpty()) {
            System.out.println("Nenhum nome foi digitado.");
            entrada.close();
            return;
        }

        String[] partes = nomeCompleto.split("\\s+");

        System.out.println("\nNome ao contrario:");
        for (int i = partes.length - 1; i >= 0; i--) {
            System.out.println(partes[i]);
        }

        entrada.close();
    }
}