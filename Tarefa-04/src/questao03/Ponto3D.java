package questao03;

// Questão 3 - Classe Ponto3D
public class Ponto3D {

    private double x;
    private double y;
    private double z;
    private String cor;
    private double intensidade;

    public Ponto3D(double x, double y, double z, String cor, double intensidade) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cor = cor;
        this.intensidade = intensidade;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(double intensidade) {
        this.intensidade = intensidade;
    }

    public double calculaDistancia(Ponto3D p) {
        double dx = x - p.getX();
        double dy = y - p.getY();
        double dz = z - p.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
