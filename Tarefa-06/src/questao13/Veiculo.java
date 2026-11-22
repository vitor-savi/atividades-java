// Questão 13 - Hierarquia de veículos
package questao13;

public abstract class Veiculo {

    private String modelo;
    private int capacidadePassageiros;

    public Veiculo(String modelo, int capacidadePassageiros) {
        this.modelo = modelo;
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public abstract void andar();

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }
}
