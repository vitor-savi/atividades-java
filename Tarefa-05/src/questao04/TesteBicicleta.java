package questao04;

/**
 * Demonstra o uso da classe Bicicleta e dos seus dois construtores.
 */
public class TesteBicicleta {

    public static void main(String[] args) {
        Bicicleta padrao = new Bicicleta();
        Bicicleta bmx = new Bicicleta(3);

        System.out.println("Bicicleta padrão: " + padrao.imprime() + " | Parada? " + padrao.estaParada());
        System.out.println("BMX:              " + bmx.imprime() + " | Parada? " + bmx.estaParada());

        System.out.println();
        System.out.println("Pedalando a BMX e subindo as marchas:");
        bmx.setCadencia(60);
        bmx.acelerar(10);
        for (int i = 0; i < 3; i++) {
            bmx.aumentarMarcha();
            System.out.println("  " + bmx.imprime());
        }

        System.out.println();
        System.out.println("Descendo as marchas da BMX:");
        for (int i = 0; i < 3; i++) {
            bmx.reduzirMarcha();
            System.out.println("  " + bmx.imprime());
        }

        System.out.println();
        System.out.println("Tentando colocar a bicicleta padrão na marcha 20:");
        padrao.mudarMarcha(20);
        padrao.mudarMarcha(18);
        System.out.println("  " + padrao.imprime());

        System.out.println();
        bmx.frear(15);
        System.out.println("BMX após frear: " + bmx.imprime() + " | Parada? " + bmx.estaParada());
    }
}
