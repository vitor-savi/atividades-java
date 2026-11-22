package questao13;

public class Trem extends VeiculoTerrestre {

    private int quantidadeVagoes;

    public Trem(String modelo, int capacidadePassageiros, int quantidadeRodas, int quantidadeVagoes) {
        super(modelo, capacidadePassageiros, quantidadeRodas);
        this.quantidadeVagoes = quantidadeVagoes;
    }

    @Override
    public void andar() {
        System.out.println("O trem " + getModelo() + " está andando sobre os trilhos puxando "
                + quantidadeVagoes + " vagões.");
    }

    public int getQuantidadeVagoes() {
        return quantidadeVagoes;
    }

    public void setQuantidadeVagoes(int quantidadeVagoes) {
        this.quantidadeVagoes = quantidadeVagoes;
    }
}
