package questao13;

import java.util.Scanner;

// item b: o usuário escolhe o tipo de veículo e ele se movimenta
public class EscolheVeiculo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Veiculo veiculo = lerVeiculo(teclado);
        if (veiculo != null) {
            veiculo.andar();
        }
    }

    public static Veiculo lerVeiculo(Scanner teclado) {
        System.out.println("1 - Carro");
        System.out.println("2 - Trem");
        System.out.println("3 - Avião");
        System.out.println("4 - Barco");
        System.out.print("Tipo de veículo: ");
        int tipo = Integer.parseInt(teclado.nextLine());

        if (tipo < 1 || tipo > 4) {
            System.out.println("Tipo inválido.");
            return null;
        }

        System.out.print("Modelo: ");
        String modelo = teclado.nextLine();
        System.out.print("Capacidade de passageiros: ");
        int capacidade = Integer.parseInt(teclado.nextLine());

        Veiculo veiculo = null;
        switch (tipo) {
            case 1:
                System.out.print("Quantidade de portas: ");
                int portas = Integer.parseInt(teclado.nextLine());
                veiculo = new Carro(modelo, capacidade, portas);
                break;
            case 2:
                System.out.print("Quantidade de rodas: ");
                int rodas = Integer.parseInt(teclado.nextLine());
                System.out.print("Quantidade de vagões: ");
                int vagoes = Integer.parseInt(teclado.nextLine());
                veiculo = new Trem(modelo, capacidade, rodas, vagoes);
                break;
            case 3:
                System.out.print("Altitude máxima (m): ");
                int altitude = Integer.parseInt(teclado.nextLine());
                System.out.print("Quantidade de motores: ");
                int motores = Integer.parseInt(teclado.nextLine());
                veiculo = new Aviao(modelo, capacidade, altitude, motores);
                break;
            case 4:
                System.out.print("Comprimento (m): ");
                int comprimento = Integer.parseInt(teclado.nextLine());
                System.out.print("Tipo de propulsão (vela, motor, remo...): ");
                String propulsao = teclado.nextLine();
                veiculo = new Barco(modelo, capacidade, comprimento, propulsao);
                break;
        }
        return veiculo;
    }
}
