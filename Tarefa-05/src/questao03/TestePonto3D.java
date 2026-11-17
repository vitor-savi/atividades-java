package questao03;

/**
 * Classe de teste que utiliza os métodos de Ponto3D a partir de outra classe.
 */
public class TestePonto3D {

    public static void main(String[] args) {
        Ponto3D p1 = new Ponto3D(1, 2, 3);
        Ponto3D p2 = new Ponto3D();

        System.out.println("p1 = " + p1.imprime());
        System.out.println("p2 = " + p2.imprime());

        p2.mover(4, 6, 3);
        System.out.println("p2 após mover(4, 6, 3) = " + p2.imprime());

        p1.setX(1.5);
        System.out.println("x de p1 após setX(1.5) = " + p1.getX());

        System.out.printf("Distância entre p1 e p2 = %.2f%n", p1.distancia(p2));
    }
}
