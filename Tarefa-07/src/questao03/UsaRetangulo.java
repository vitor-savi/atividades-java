package tarefa07.questao03;

import java.util.Scanner;

public class UsaRetangulo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Retangulo retangulo = null;

        while (retangulo == null) {
            try {
                System.out.print("Altura: ");
                double altura = Double.parseDouble(entrada.nextLine().trim().replace(',', '.'));

                System.out.print("Largura: ");
                double largura = Double.parseDouble(entrada.nextLine().trim().replace(',', '.'));

                retangulo = new Retangulo(altura, largura);
            } catch (NumberFormatException e) {
                System.out.println("Erro: digite apenas números.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
        }

        System.out.printf("Área do retângulo: %.2f%n", retangulo.area());
        entrada.close();
    }
}
