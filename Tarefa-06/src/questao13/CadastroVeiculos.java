package questao13;

import java.util.Scanner;

// itens c e d: lê vários veículos em um único vetor e chama andar() de todos
public class CadastroVeiculos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Quantos veículos deseja informar? ");
        int quantidade = Integer.parseInt(teclado.nextLine());
        Veiculo[] veiculos = new Veiculo[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.println();
            System.out.println("Veículo " + (i + 1));
            do {
                veiculos[i] = EscolheVeiculo.lerVeiculo(teclado);
            } while (veiculos[i] == null);
        }

        System.out.println();
        System.out.println("Movimentando todos os veículos:");
        for (int i = 0; i < veiculos.length; i++) {
            veiculos[i].andar();
        }
    }
}
