package questao09;

import java.util.Scanner;

// Questão 9 - Palíndromo
public class Palindromo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite uma frase (sem acentos): ");
        String frase = teclado.nextLine();

        // fica só com as letras, em minúsculo
        String letras = "";
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (Character.isLetter(c)) {
                letras += Character.toLowerCase(c);
            }
        }

        boolean palindromo = true;
        for (int i = 0; i < letras.length() / 2; i++) {
            if (letras.charAt(i) != letras.charAt(letras.length() - 1 - i)) {
                palindromo = false;
                break;
            }
        }

        if (palindromo) {
            System.out.println("A frase é um palíndromo.");
        } else {
            System.out.println("A frase não é um palíndromo.");
        }

        teclado.close();
    }
}
