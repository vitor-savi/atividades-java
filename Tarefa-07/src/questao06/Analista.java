package tarefa07.questao06;

public class Analista extends Funcionario {
    public Analista(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double getBonus() {
        return getSalario();
    }
}
