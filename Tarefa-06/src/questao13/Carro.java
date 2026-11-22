package questao13;

public class Carro extends VeiculoTerrestre {

    private int quantidadePortas;

    public Carro(String modelo, int capacidadePassageiros, int quantidadePortas) {
        super(modelo, capacidadePassageiros, 4);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void andar() {
        System.out.println("O carro " + getModelo() + " está rodando pela estrada sobre "
                + getQuantidadeRodas() + " rodas.");
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}
