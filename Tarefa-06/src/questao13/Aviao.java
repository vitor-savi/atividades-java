package questao13;

public class Aviao extends VeiculoAereo {

    private int quantidadeMotores;

    public Aviao(String modelo, int capacidadePassageiros, int altitudeMaxima, int quantidadeMotores) {
        super(modelo, capacidadePassageiros, altitudeMaxima);
        this.quantidadeMotores = quantidadeMotores;
    }

    @Override
    public void andar() {
        System.out.println("O avião " + getModelo() + " está voando a até " + getAltitudeMaxima()
                + " metros de altitude com " + quantidadeMotores + " motor(es).");
    }

    public int getQuantidadeMotores() {
        return quantidadeMotores;
    }

    public void setQuantidadeMotores(int quantidadeMotores) {
        this.quantidadeMotores = quantidadeMotores;
    }
}
