package questao13;

public class Barco extends VeiculoAquatico {

    private String tipoPropulsao;

    public Barco(String modelo, int capacidadePassageiros, int comprimento, String tipoPropulsao) {
        super(modelo, capacidadePassageiros, comprimento);
        this.tipoPropulsao = tipoPropulsao;
    }

    @Override
    public void andar() {
        System.out.println("O barco " + getModelo() + " está navegando na água movido a "
                + tipoPropulsao + ".");
    }

    public String getTipoPropulsao() {
        return tipoPropulsao;
    }

    public void setTipoPropulsao(String tipoPropulsao) {
        this.tipoPropulsao = tipoPropulsao;
    }
}
