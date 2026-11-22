package questao03;

public class Gerente extends Funcionario {

    private Funcionario[] equipe;

    public Gerente(String nome, double salario, Funcionario[] equipe) {
        super(nome, "Gerente", salario);
        this.equipe = equipe;
    }

    @Override
    public double getBonus() {
        return 2 * getSalario() + 100 * equipe.length;
    }

    public Funcionario[] getEquipe() {
        return equipe;
    }

    public void setEquipe(Funcionario[] equipe) {
        this.equipe = equipe;
    }
}
