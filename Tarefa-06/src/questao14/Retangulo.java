package questao14;

public class Retangulo implements Superficie {

    private double altura;
    private double largura;

    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double area() {
        return altura * largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }
}
