package questao13;

public abstract class VeiculoAereo extends Veiculo {

    private int altitudeMaxima;

    public VeiculoAereo(String modelo, int capacidadePassageiros, int altitudeMaxima) {
        super(modelo, capacidadePassageiros);
        this.altitudeMaxima = altitudeMaxima;
    }

    @Override
    public abstract void andar();

    public int getAltitudeMaxima() {
        return altitudeMaxima;
    }

    public void setAltitudeMaxima(int altitudeMaxima) {
        this.altitudeMaxima = altitudeMaxima;
    }
}
