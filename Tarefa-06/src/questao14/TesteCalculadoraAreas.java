package questao14;

public class TesteCalculadoraAreas {

    public static void main(String[] args) {
        Superficie[] figuras = new Superficie[4];
        figuras[0] = new Retangulo(2, 5);
        figuras[1] = new Triangulo(3, 4, 5);
        figuras[2] = new Circunferencia(1);
        figuras[3] = new Retangulo(3, 3);

        System.out.printf("Retângulo 2 x 5: %.2f%n", figuras[0].area());
        System.out.printf("Triângulo 3, 4, 5: %.2f%n", figuras[1].area());
        System.out.printf("Circunferência de raio 1: %.2f%n", figuras[2].area());
        System.out.printf("Retângulo 3 x 3: %.2f%n", figuras[3].area());
        System.out.printf("Soma das áreas: %.2f%n", CalculadoraAreas.somaAreas(figuras));
    }
}
