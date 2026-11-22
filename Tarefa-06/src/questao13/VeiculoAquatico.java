package questao13;

public abstract class VeiculoAquatico extends Veiculo {

    private int comprimento;

    public VeiculoAquatico(String modelo, int capacidadePassageiros, int comprimento) {
        super(modelo, capacidadePassageiros);
        this.comprimento = comprimento;
    }

    @Override
    public abstract void andar();

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }
}
