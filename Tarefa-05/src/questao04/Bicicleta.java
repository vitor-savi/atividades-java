package questao04;

public class Bicicleta {

    private int cadencia;
    private int velocidade;
    private int marcha;
    private int numeroMaximoMarchas;

    public Bicicleta() {
        numeroMaximoMarchas = 18;
        cadencia = 0;
        velocidade = 0;
        marcha = 1;
    }

    public Bicicleta(int numeroMaximoMarchas) {
        this.numeroMaximoMarchas = numeroMaximoMarchas;
        cadencia = 0;
        velocidade = 0;
        marcha = 1;
    }

    public void aumentarMarcha() {
        if (marcha < numeroMaximoMarchas) {
            marcha++;
        } else {
            System.out.println("A bicicleta já está na última marcha.");
        }
    }

    public void reduzirMarcha() {
        if (marcha > 1) {
            marcha--;
        } else {
            System.out.println("A bicicleta já está na primeira marcha.");
        }
    }

    public void acelerar(int incremento) {
        velocidade = velocidade + incremento;
    }

    public void frear(int decremento) {
        velocidade = velocidade - decremento;
        if (velocidade < 0) {
            velocidade = 0;
        }
    }

    public int getCadencia() {
        return cadencia;
    }

    public void setCadencia(int cadencia) {
        this.cadencia = cadencia;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getMarcha() {
        return marcha;
    }

    public int getNumeroMaximoMarchas() {
        return numeroMaximoMarchas;
    }

    public void imprime() {
        System.out.println("Cadência: " + cadencia + " Velocidade: " + velocidade + " Marcha: " + marcha);
    }
}
