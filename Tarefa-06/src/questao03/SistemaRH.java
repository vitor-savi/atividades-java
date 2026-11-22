package questao03;

public class SistemaRH {

    public static void main(String[] args) {
        Analista ana = new Analista("Ana", 5000);
        Programador bruno = new Programador("Bruno", 4500);
        Programador carla = new Programador("Carla", 4800);
        AuxiliarLimpeza daniel = new AuxiliarLimpeza("Daniel", 1800);

        Funcionario[] equipe = { ana, bruno, carla, daniel };
        Gerente eduardo = new Gerente("Eduardo", 9000, equipe);

        Departamento[] departamentos = { new Departamento("TI"), new Departamento("Financeiro") };
        Diretor fernanda = new Diretor("Fernanda", 15000, departamentos);

        Funcionario[] funcionarios = { fernanda, eduardo, ana, bruno, carla, daniel };
        imprimeRelatorio(funcionarios);
    }

    public static void imprimeRelatorio(Funcionario[] listaFuncionarios) {
        double totalBonus = 0;
        System.out.println("===== Relatório de Funcionários =====");
        for (int i = 0; i < listaFuncionarios.length; i++) {
            Funcionario f = listaFuncionarios[i];
            System.out.println("Nome: " + f.getNome());
            System.out.println("Cargo: " + f.getCargo());
            System.out.printf("Salário: R$ %.2f%n", f.getSalario());
            System.out.printf("Bônus anual: R$ %.2f%n", f.getBonus());
            System.out.println("-------------------------------------");
            totalBonus += f.getBonus();
        }
        System.out.printf("Total de bônus pagos: R$ %.2f%n", totalBonus);
    }
}
