package tarefa07.questao06;

public class Gerente extends Funcionario {
    public static final int MINIMO_EQUIPE = 5;

    private Funcionario[] equipe;

    public Gerente(String nome, double salario, Funcionario[] equipe) throws EquipeInsuficienteException {
        super(nome, salario);
        setEquipe(equipe);
    }

    public Funcionario[] getEquipe() {
        return equipe;
    }

    public void setEquipe(Funcionario[] equipe) throws EquipeInsuficienteException {
        int tamanho = (equipe == null) ? 0 : equipe.length;
        if (tamanho < MINIMO_EQUIPE) {
            throw new EquipeInsuficienteException("O gerente " + getNome()
                    + " precisa de uma equipe de no mínimo " + MINIMO_EQUIPE
                    + " pessoas. Equipe informada: " + tamanho + ".");
        }
        this.equipe = equipe;
    }

    @Override
    public double getBonus() {
        return 2 * getSalario() + 100 * equipe.length;
    }
}
