package questao11;

public class Quadrado implements Superficie {

    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double perimetro() {
        return 4 * lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
