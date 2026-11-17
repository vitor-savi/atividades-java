package questao05;

import java.util.Scanner;

/**
 * Questão 5 - Calcula o faturamento anual e o valor ganho com multas por mês
 * de uma vídeo locadora.
 *
 * @author Vitor Savi do Nascimento
 * @author Felipe Fernandes de Azevedo
 * @author Lucas Matheus Dutra da Silva
 * @author Lucas Dourado Martins
 */
public class VideoLocadora {

    /**
     * Calcula o faturamento anual, sabendo que um terço dos DVDs são alugados por mês.
     *
     * @param quantidadeDvds quantidade de DVDs da locadora
     * @param valorAluguel   valor de cada aluguel
     * @return faturamento anual
     */
    public static double calcularFaturamentoAnual(int quantidadeDvds, double valorAluguel) {
        double alugadosPorMes = quantidadeDvds / 3.0;
        return alugadosPorMes * valorAluguel * 12;
    }

    /**
     * Calcula o valor ganho com multas por mês. Um décimo dos DVDs alugados no mês
     * são devolvidos com atraso e a multa é de 10% sobre o valor do aluguel.
     *
     * @param quantidadeDvds quantidade de DVDs da locadora
     * @param valorAluguel   valor de cada aluguel
     * @return valor ganho com multas por mês
     */
    public static double calcularMultasPorMes(int quantidadeDvds, double valorAluguel) {
        double alugadosPorMes = quantidadeDvds / 3.0;
        double atrasados = alugadosPorMes / 10;
        return atrasados * valorAluguel * 0.10;
    }

    /**
     * Lê a quantidade de DVDs e o valor do aluguel e mostra os resultados.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe a quantidade de DVDs da locadora: ");
        int quantidadeDvds = teclado.nextInt();

        System.out.print("Informe o valor cobrado por aluguel: ");
        double valorAluguel = teclado.nextDouble();

        System.out.printf("Faturamento anual: R$ %.2f%n", calcularFaturamentoAnual(quantidadeDvds, valorAluguel));
        System.out.printf("Valor ganho com multas por mês: R$ %.2f%n", calcularMultasPorMes(quantidadeDvds, valorAluguel));

        teclado.close();
    }
}
