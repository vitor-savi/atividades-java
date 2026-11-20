package tarefa07.questao02;

public class UsaBicicleta {
    public static void main(String[] args) {
        System.out.println("Teste 1: criar bicicleta com marcha 30");
        try {
            new Bicicleta(0, 0, 30);
            System.out.println("Bicicleta criada.");
        } catch (RpmInvalidoException e) {
            System.out.println("Erro de RPM: " + e.getMessage());
        } catch (VelocidadeInvalidaException e) {
            System.out.println("Erro de velocidade: " + e.getMessage());
        } catch (MarchaInvalidaException e) {
            System.out.println("Erro de marcha: " + e.getMessage());
        }

        Bicicleta bike;
        try {
            bike = new Bicicleta(0, 0, 1);
        } catch (RpmInvalidoException e) {
            System.out.println("Erro de RPM: " + e.getMessage());
            return;
        } catch (VelocidadeInvalidaException e) {
            System.out.println("Erro de velocidade: " + e.getMessage());
            return;
        } catch (MarchaInvalidaException e) {
            System.out.println("Erro de marcha: " + e.getMessage());
            return;
        }

        System.out.print("\nBicicleta válida criada: ");
        bike.printStates();

        System.out.println("\nTeste 2: velocidade 120 km/h");
        try {
            bike.setVelocidade(120);
        } catch (VelocidadeInvalidaException e) {
            System.out.println("Erro de velocidade: " + e.getMessage());
        }

        System.out.println("\nTeste 3: aumentar para 40 km/h e frear 50 km/h");
        try {
            bike.aumentarVelocidade(40);
            System.out.print("Depois de acelerar: ");
            bike.printStates();
            bike.aplicarFreios(50);
        } catch (VelocidadeInvalidaException e) {
            System.out.println("Erro de velocidade: " + e.getMessage());
        }

        System.out.println("\nTeste 4: RPM -5");
        try {
            bike.setRPM(-5);
        } catch (RpmInvalidoException e) {
            System.out.println("Erro de RPM: " + e.getMessage());
        }

        System.out.println("\nTeste 5: marcha 25");
        try {
            bike.setMarcha(25);
        } catch (MarchaInvalidaException e) {
            System.out.println("Erro de marcha: " + e.getMessage());
        }

        System.out.println("\nTeste 6: marcha -1");
        try {
            bike.mudarMarcha(-1);
        } catch (MarchaInvalidaException e) {
            System.out.println("Erro de marcha: " + e.getMessage());
        }

        System.out.println("\nTeste 7: valores válidos (RPM 80, marcha 12, velocidade 30)");
        try {
            bike.setRPM(80);
            bike.setMarcha(12);
            bike.setVelocidade(30);
            System.out.println("Alterações feitas sem erro.");
        } catch (RpmInvalidoException e) {
            System.out.println("Erro de RPM: " + e.getMessage());
        } catch (MarchaInvalidaException e) {
            System.out.println("Erro de marcha: " + e.getMessage());
        } catch (VelocidadeInvalidaException e) {
            System.out.println("Erro de velocidade: " + e.getMessage());
        }

        System.out.print("\nEstado final: ");
        bike.printStates();
    }
}
