package questao14;

public class Triangulo implements Superficie {

    private int lado1;
    private int lado2;
    private int lado3;

    public Triangulo(int l1, int l2, int l3) {
        lado1 = l1;
        lado2 = l2;
        lado3 = l3;
    }

    public boolean ehEscaleno() {
        return lado1 != lado2 && lado1 != lado3 && lado2 != lado3;
    }

    public boolean ehEquilatero() {
        return lado1 == lado2 && lado2 == lado3;
    }

    public boolean ehIsosceles() {
        return lado1 == lado2 || lado1 == lado3 || lado2 == lado3;
    }

    // fórmula de Heron, usando o semiperímetro
    @Override
    public double area() {
        double s = (lado1 + lado2 + lado3) / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public void setLado3(int lado3) {
        this.lado3 = lado3;
    }
}
