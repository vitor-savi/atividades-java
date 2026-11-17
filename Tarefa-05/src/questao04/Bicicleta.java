package questao04;

/**
 * Representa uma bicicleta com cadência, velocidade e marcha atual.
 * Os atributos são privados e acessados apenas pelos métodos da classe.
 */
public class Bicicleta {

    private int cadencia;
    private int velocidade;
    private int marcha;
    private int numeroMaximoMarchas;

    /**
     * Cria uma bicicleta parada com 18 marchas.
     */
    public Bicicleta() {
        this(18);
    }

    /**
     * Cria uma bicicleta parada com o número máximo de marchas informado.
     *
     * @param numeroMaximoMarchas número máximo de marchas da bicicleta
     */
    public Bicicleta(int numeroMaximoMarchas) {
        this.numeroMaximoMarchas = numeroMaximoMarchas;
        this.cadencia = 0;
        this.velocidade = 0;
        this.marcha = 1;
    }

    /**
     * Muda para a marcha informada, se ela estiver entre 1 e o número máximo de marchas.
     *
     * @param novaMarcha marcha desejada
     * @return true se a marcha foi alterada, false caso contrário
     */
    public boolean mudarMarcha(int novaMarcha) {
        if (novaMarcha < 1 || novaMarcha > numeroMaximoMarchas) {
            System.out.println("Marcha " + novaMarcha + " inválida. A bicicleta possui marchas de 1 a "
                    + numeroMaximoMarchas + ".");
            return false;
        }
        marcha = novaMarcha;
        return true;
    }

    /**
     * Sobe uma marcha, se o número máximo de marchas ainda não foi alcançado.
     *
     * @return true se a marcha foi alterada, false caso contrário
     */
    public boolean aumentarMarcha() {
        return mudarMarcha(marcha + 1);
    }

    /**
     * Desce uma marcha, se a bicicleta não estiver na primeira marcha.
     *
     * @return true se a marcha foi alterada, false caso contrário
     */
    public boolean reduzirMarcha() {
        return mudarMarcha(marcha - 1);
    }

    public void acelerar(int incremento) {
        velocidade += incremento;
    }

    public void frear(int decremento) {
        velocidade = Math.max(0, velocidade - decremento);
    }

    public boolean estaParada() {
        return velocidade == 0;
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

    public String imprime() {
        return "Cadência: " + cadencia + " | Velocidade: " + velocidade + " | Marcha: " + marcha
                + "/" + numeroMaximoMarchas;
    }
}
