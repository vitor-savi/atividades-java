package questao03;

// Questão 3 - Testes com Ponto3D
public class UsaPonto3D {

    public static void main(String[] args) {
        Ponto3D origem = new Ponto3D(0, 0, 0, "Preto", 1.0);
        Ponto3D p1 = new Ponto3D(1, 2, 2, "Vermelho", 0.5);
        Ponto3D p2 = new Ponto3D(4, 6, 3, "Azul", 0.8);

        System.out.printf("Distância da origem até p1: %.2f%n", origem.calculaDistancia(p1));
        System.out.printf("Distância entre p1 e p2: %.2f%n", p1.calculaDistancia(p2));
        System.out.printf("Distância de p1 até ele mesmo: %.2f%n", p1.calculaDistancia(p1));

        p2.setX(1);
        p2.setY(2);
        p2.setZ(5);
        System.out.printf("Distância entre p1 e p2 depois de mover p2: %.2f%n", p1.calculaDistancia(p2));
    }
}
