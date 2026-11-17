package questao11;

import java.util.Scanner;

// Questão 11 - Bônus anual do funcionário
public class BonusAnual {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Cargos:");
        System.out.println("1 - Diretor");
        System.out.println("2 - Gerente");
        System.out.println("3 - Analista");
        System.out.println("4 - Programador");
        System.out.println("5 - Auxiliar de Limpeza");
        System.out.print("Informe o cargo do funcionário: ");
        int cargo = teclado.nextInt();

        System.out.print("Informe o salário atual: ");
        double salario = teclado.nextDouble();

        double bonus = 0;

        switch (cargo) {
            case 1:
                System.out.print("Informe a quantidade de departamentos gerenciados: ");
                int departamentos = teclado.nextInt();
                bonus = 4 * salario + 3000.00 * departamentos;
                break;
            case 2:
                System.out.print("Informe a quantidade de pessoas gerenciadas: ");
                int pessoas = teclado.nextInt();
                bonus = 2 * salario + 100.00 * pessoas;
                break;
            case 3:
                bonus = salario;
                break;
            case 4:
                bonus = 0.8 * salario;
                break;
            case 5:
                bonus = 0.5 * salario;
                break;
            default:
                System.out.println("Cargo inválido.");
        }

        System.out.printf("Bônus anual: R$ %.2f%n", bonus);

        teclado.close();
    }
}
