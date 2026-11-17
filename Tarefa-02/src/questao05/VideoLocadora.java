package questao05;

import java.util.Scanner;

/**
 * Questão 5 - Calcula o faturamento anual e o valor ganho com multas por mês
 * de uma vídeo locadora.
 *
 * <p>Regras consideradas:</p>
 * <ul>
 *   <li>Um terço dos DVDs da locadora são alugados por mês;</li>
 *   <li>Um décimo dos DVDs alugados no mês são devolvidos com atraso;</li>
 *   <li>A multa por atraso é de 10% sobre o valor do aluguel.</li>
 * </ul>
 *
 * @author Vitor Savi do Nascimento
 * @author Felipe Fernandes de Azevedo
 * @author Lucas Matheus Dutra da Silva
 * @author Lucas Dourado Martins
 * @version 1.0
 */
public class VideoLocadora {

    /** Fração dos DVDs que são alugados por mês (um terço). */
    public static final double FRACAO_ALUGADA_POR_MES = 1.0 / 3.0;

    /** Fração dos DVDs alugados que são devolvidos com atraso (um décimo). */
    public static final double FRACAO_DEVOLVIDA_COM_ATRASO = 1.0 / 10.0;

    /** Percentual da multa cobrada sobre o valor do aluguel (10%). */
    public static final double PERCENTUAL_MULTA = 0.10;

    /** Construtor privado: a classe possui apenas métodos estáticos. */
    private VideoLocadora() {
    }

    /**
     * Calcula a quantidade de DVDs alugados por mês.
     *
     * @param quantidadeDvds quantidade total de DVDs da locadora
     * @return quantidade de DVDs alugados no mês
     */
    public static double calcularDvdsAlugadosPorMes(int quantidadeDvds) {
        return quantidadeDvds * FRACAO_ALUGADA_POR_MES;
    }

    /**
     * Calcula o faturamento anual da locadora com os aluguéis.
     *
     * @param quantidadeDvds quantidade total de DVDs da locadora
     * @param valorAluguel   valor cobrado por cada aluguel
     * @return faturamento anual (12 meses de aluguéis)
     */
    public static double calcularFaturamentoAnual(int quantidadeDvds, double valorAluguel) {
        double faturamentoMensal = calcularDvdsAlugadosPorMes(quantidadeDvds) * valorAluguel;
        return faturamentoMensal * 12;
    }

    /**
     * Calcula o valor ganho com multas por atraso em um mês.
     *
     * @param quantidadeDvds quantidade total de DVDs da locadora
     * @param valorAluguel   valor cobrado por cada aluguel
     * @return valor ganho com multas por mês
     */
    public static double calcularMultasPorMes(int quantidadeDvds, double valorAluguel) {
        double dvdsAtrasados = calcularDvdsAlugadosPorMes(quantidadeDvds) * FRACAO_DEVOLVIDA_COM_ATRASO;
        return dvdsAtrasados * valorAluguel * PERCENTUAL_MULTA;
    }

    /**
     * Método principal: lê a quantidade de DVDs e o valor do aluguel do teclado
     * e exibe o faturamento anual e o valor ganho com multas por mês.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe a quantidade de DVDs da locadora: ");
        int quantidadeDvds = teclado.nextInt();

        System.out.print("Informe o valor cobrado por aluguel: ");
        double valorAluguel = teclado.nextDouble();

        double faturamentoAnual = calcularFaturamentoAnual(quantidadeDvds, valorAluguel);
        double multasPorMes = calcularMultasPorMes(quantidadeDvds, valorAluguel);

        System.out.printf("Faturamento anual: R$ %.2f%n", faturamentoAnual);
        System.out.printf("Valor ganho com multas por mês: R$ %.2f%n", multasPorMes);

        teclado.close();
    }
}
