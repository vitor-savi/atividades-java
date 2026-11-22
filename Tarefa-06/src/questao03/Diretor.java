package questao03;

public class Diretor extends Funcionario {

    private Departamento[] departamentos;

    public Diretor(String nome, double salario, Departamento[] departamentos) {
        super(nome, "Diretor", salario);
        this.departamentos = departamentos;
    }

    @Override
    public double getBonus() {
        return 4 * getSalario() + 3000 * departamentos.length;
    }

    public Departamento[] getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamento[] departamentos) {
        this.departamentos = departamentos;
    }
}
