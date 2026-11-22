package questao11;

public class TesteSuperficie {

    public static void main(String[] args) {
        Superficie superficie;

        superficie = new Quadrado(4);
        System.out.printf("Área do quadrado de lado 4: %.2f%n", superficie.area());

        superficie = new Circunferencia(3);
        System.out.printf("Área da circunferência de raio 3: %.2f%n", superficie.area());
    }
}
