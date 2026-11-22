package questao13;

public abstract class VeiculoTerrestre extends Veiculo {

    private int quantidadeRodas;

    public VeiculoTerrestre(String modelo, int capacidadePassageiros, int quantidadeRodas) {
        super(modelo, capacidadePassageiros);
        this.quantidadeRodas = quantidadeRodas;
    }

    @Override
    public abstract void andar();

    public int getQuantidadeRodas() {
        return quantidadeRodas;
    }

    public void setQuantidadeRodas(int quantidadeRodas) {
        this.quantidadeRodas = quantidadeRodas;
    }
}
