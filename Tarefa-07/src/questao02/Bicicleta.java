package tarefa07.questao02;

public class Bicicleta {
    private int cadencia;
    private int velocidade;
    private int marcha;

    public Bicicleta(int cadencia, int velocidade, int marcha)
            throws RpmInvalidoException, VelocidadeInvalidaException, MarchaInvalidaException {
        setRPM(cadencia);
        setVelocidade(velocidade);
        setMarcha(marcha);
    }

    public int getRPM() {
        return cadencia;
    }

    public void setRPM(int rpm) throws RpmInvalidoException {
        if (rpm < 0) {
            throw new RpmInvalidoException("RPM inválido: " + rpm + ". O valor não pode ser negativo.");
        }
        this.cadencia = rpm;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) throws VelocidadeInvalidaException {
        if (velocidade < 0 || velocidade > 100) {
            throw new VelocidadeInvalidaException("Velocidade inválida: " + velocidade
                    + " km/h. O valor deve estar entre 0 e 100 km/h.");
        }
        this.velocidade = velocidade;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) throws MarchaInvalidaException {
        if (marcha < 0 || marcha > 24) {
            throw new MarchaInvalidaException("Marcha inválida: " + marcha
                    + ". O valor deve estar entre 0 e 24.");
        }
        this.marcha = marcha;
    }

    public void mudarCadencia(int novoValor) throws RpmInvalidoException {
        setRPM(novoValor);
    }

    public void mudarMarcha(int novoValor) throws MarchaInvalidaException {
        setMarcha(novoValor);
    }

    public void aumentarVelocidade(int incremento) throws VelocidadeInvalidaException {
        setVelocidade(velocidade + incremento);
    }

    public void aplicarFreios(int decremento) throws VelocidadeInvalidaException {
        setVelocidade(velocidade - decremento);
    }

    public void printStates() {
        System.out.println("cadencia=" + cadencia + " velocidade=" + velocidade + " marcha=" + marcha);
    }
}
