package questao04;

public class TesteBicicleta {

    public static void main(String[] args) {
        Bicicleta bike1 = new Bicicleta();
        Bicicleta bike2 = new Bicicleta(3);

        System.out.println("Bicicleta 1 (" + bike1.getNumeroMaximoMarchas() + " marchas):");
        bike1.imprime();
        System.out.println("Bicicleta 2 (" + bike2.getNumeroMaximoMarchas() + " marchas):");
        bike2.imprime();

        System.out.println();
        System.out.println("Subindo as marchas da bicicleta 2:");
        bike2.setCadencia(60);
        bike2.acelerar(10);
        bike2.aumentarMarcha();
        bike2.aumentarMarcha();
        bike2.aumentarMarcha(); // não deve passar da marcha 3
        bike2.imprime();

        System.out.println();
        System.out.println("Descendo as marchas da bicicleta 2:");
        bike2.reduzirMarcha();
        bike2.reduzirMarcha();
        bike2.reduzirMarcha(); // não deve ir abaixo da marcha 1
        bike2.imprime();

        System.out.println();
        System.out.println("Freando a bicicleta 2:");
        bike2.frear(10);
        bike2.imprime();
    }
}
