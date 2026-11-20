package tarefa07.questao06;

public class TestaRegrasRH {
    public static void main(String[] args) {
        System.out.println("Teste 1: gerente com equipe de 3 pessoas");
        try {
            new Gerente("Carlos", 8000, criarEquipe(3));
            System.out.println("Gerente criado.");
        } catch (EquipeInsuficienteException e) {
            System.out.println("Regra violada: " + e.getMessage());
        }

        System.out.println("\nTeste 2: gerente com equipe de 5 pessoas");
        Gerente gerente = null;
        try {
            gerente = new Gerente("Mariana", 8000, criarEquipe(5));
            System.out.printf("Gerente %s criado. Bônus: R$ %.2f%n", gerente.getNome(), gerente.getBonus());
        } catch (EquipeInsuficienteException e) {
            System.out.println("Regra violada: " + e.getMessage());
        }

        System.out.println("\nTeste 3: trocar a equipe da gerente por 2 pessoas (método set)");
        if (gerente != null) {
            try {
                gerente.setEquipe(criarEquipe(2));
                System.out.println("Equipe alterada.");
            } catch (EquipeInsuficienteException e) {
                System.out.println("Regra violada: " + e.getMessage());
                System.out.println("A equipe continua com " + gerente.getEquipe().length + " pessoas.");
            }
        }

        System.out.println("\nTeste 4: diretor com 1 departamento");
        try {
            new Diretor("Roberto", 15000, criarDepartamentos(1));
            System.out.println("Diretor criado.");
        } catch (DepartamentosInsuficientesException e) {
            System.out.println("Regra violada: " + e.getMessage());
        }

        System.out.println("\nTeste 5: diretor com 2 departamentos");
        Diretor diretor = null;
        try {
            diretor = new Diretor("Fernanda", 15000, criarDepartamentos(2));
            System.out.printf("Diretora %s criada. Bônus: R$ %.2f%n", diretor.getNome(), diretor.getBonus());
        } catch (DepartamentosInsuficientesException e) {
            System.out.println("Regra violada: " + e.getMessage());
        }

        System.out.println("\nTeste 6: trocar os departamentos da diretora por nenhum (método set)");
        if (diretor != null) {
            try {
                diretor.setDepartamentos(new Departamento[0]);
                System.out.println("Departamentos alterados.");
            } catch (DepartamentosInsuficientesException e) {
                System.out.println("Regra violada: " + e.getMessage());
                System.out.println("A diretora continua com " + diretor.getDepartamentos().length + " departamentos.");
            }
        }
    }

    private static Funcionario[] criarEquipe(int quantidade) {
        Funcionario[] equipe = new Funcionario[quantidade];
        for (int i = 0; i < quantidade; i++) {
            equipe[i] = new Analista("Analista " + (i + 1), 4000);
        }
        return equipe;
    }

    private static Departamento[] criarDepartamentos(int quantidade) {
        Departamento[] departamentos = new Departamento[quantidade];
        for (int i = 0; i < quantidade; i++) {
            departamentos[i] = new Departamento("Departamento " + (i + 1));
        }
        return departamentos;
    }
}
