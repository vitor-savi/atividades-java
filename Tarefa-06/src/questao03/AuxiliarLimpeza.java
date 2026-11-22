package questao03;

public class AuxiliarLimpeza extends Funcionario {

    public AuxiliarLimpeza(String nome, double salario) {
        super(nome, "Auxiliar de Limpeza", salario);
    }

    @Override
    public double getBonus() {
        return 0.5 * getSalario();
    }
}
