package questao14;

public class Circunferencia implements Superficie {

    private double raio;

    public Circunferencia(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
