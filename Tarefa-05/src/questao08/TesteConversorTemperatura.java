package questao08;

import java.util.Scanner;

public class TesteConversorTemperatura {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("===== CONVERSOR DE TEMPERATURA =====");
            System.out.println("1 - Celsius para Fahrenheit");
            System.out.println("2 - Celsius para Kelvin");
            System.out.println("3 - Fahrenheit para Celsius");
            System.out.println("4 - Fahrenheit para Kelvin");
            System.out.println("5 - Kelvin para Celsius");
            System.out.println("6 - Kelvin para Fahrenheit");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = teclado.nextInt();

            if (opcao < 0 || opcao > 6) {
                System.out.println("Opção inválida.");
                continue;
            }
            if (opcao == 0) {
                break;
            }

            System.out.print("Informe a temperatura: ");
            double valor = teclado.nextDouble();

            switch (opcao) {
                case 1:
                    System.out.printf("%.2f °C = %.2f °F%n", valor, ConversorTemperatura.celsiusParaFahrenheit(valor));
                    break;
                case 2:
                    System.out.printf("%.2f °C = %.2f K%n", valor, ConversorTemperatura.celsiusParaKelvin(valor));
                    break;
                case 3:
                    System.out.printf("%.2f °F = %.2f °C%n", valor, ConversorTemperatura.fahrenheitParaCelsius(valor));
                    break;
                case 4:
                    System.out.printf("%.2f °F = %.2f K%n", valor, ConversorTemperatura.fahrenheitParaKelvin(valor));
                    break;
                case 5:
                    System.out.printf("%.2f K = %.2f °C%n", valor, ConversorTemperatura.kelvinParaCelsius(valor));
                    break;
                case 6:
                    System.out.printf("%.2f K = %.2f °F%n", valor, ConversorTemperatura.kelvinParaFahrenheit(valor));
                    break;
            }
        } while (opcao != 0);

        System.out.println("Saindo...");
        teclado.close();
    }
}
