package questao03;

public class Ponto3D {

    private double x;
    private double y;
    private double z;

    public Ponto3D() {
        this(0, 0, 0);
    }

    public Ponto3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public void mover(double dx, double dy, double dz) {
        x += dx;
        y += dy;
        z += dz;
    }

    public double distancia(Ponto3D outro) {
        double dx = x - outro.x;
        double dy = y - outro.y;
        double dz = z - outro.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public String imprime() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
