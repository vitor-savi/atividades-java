package tarefa07.questao06;

public class Diretor extends Funcionario {
    public static final int MINIMO_DEPARTAMENTOS = 2;

    private Departamento[] departamentos;

    public Diretor(String nome, double salario, Departamento[] departamentos)
            throws DepartamentosInsuficientesException {
        super(nome, "Diretor", salario);
        setDepartamentos(departamentos);
    }

    public Departamento[] getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamento[] departamentos) throws DepartamentosInsuficientesException {
        int tamanho = (departamentos == null) ? 0 : departamentos.length;
        if (tamanho < MINIMO_DEPARTAMENTOS) {
            throw new DepartamentosInsuficientesException("O diretor " + getNome()
                    + " precisa dirigir no mínimo " + MINIMO_DEPARTAMENTOS
                    + " departamentos. Departamentos informados: " + tamanho + ".");
        }
        this.departamentos = departamentos;
    }

    @Override
    public double getBonus() {
        return 4 * getSalario() + 3000 * departamentos.length;
    }
}
