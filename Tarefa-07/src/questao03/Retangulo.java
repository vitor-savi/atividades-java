package tarefa07.questao03;

public class Retangulo {
    private double altura;
    private double largura;

    public Retangulo(double altura, double largura) {
        setAltura(altura);
        setLargura(largura);
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura < 0) {
            throw new IllegalArgumentException("A altura não pode ser negativa: " + altura);
        }
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura < 0) {
            throw new IllegalArgumentException("A largura não pode ser negativa: " + largura);
        }
        this.largura = largura;
    }

    public double area() {
        return altura * largura;
    }
}
