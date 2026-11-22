package questao04;

public class Professor extends Pessoa {

    private String titulacao;
    private Disciplina[] disciplinasMinistradas;
    private int quantidadeDisciplinas;

    public Professor(String nome, int idade, String endereco, String titulacao, int maximoDisciplinas) {
        super(nome, idade, endereco);
        this.titulacao = titulacao;
        this.disciplinasMinistradas = new Disciplina[maximoDisciplinas];
        this.quantidadeDisciplinas = 0;
    }

    public String adicionarDisciplina(Disciplina disciplina) {
        if (disciplina.getProfessor() != null) {
            return "A disciplina " + disciplina.getNome() + " já é ministrada pelo professor "
                    + disciplina.getProfessor().getNome() + ".";
        }
        if (quantidadeDisciplinas == disciplinasMinistradas.length) {
            return "O professor " + getNome() + " já atingiu o limite de "
                    + disciplinasMinistradas.length + " disciplina(s).";
        }
        disciplinasMinistradas[quantidadeDisciplinas] = disciplina;
        quantidadeDisciplinas++;
        disciplina.setProfessor(this);
        return "Disciplina " + disciplina.getNome() + " atribuída ao professor " + getNome() + ".";
    }

    @Override
    public String imprime() {
        String disciplinas = "";
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            if (i > 0) {
                disciplinas += "; ";
            }
            disciplinas += disciplinasMinistradas[i].getNome();
        }
        return "-----------------------------------------------------------------\n"
                + "Professor\n"
                + super.imprime()
                + "Titulacao: " + titulacao + "\n"
                + "Disciplinas Ministradas: " + disciplinas + "\n"
                + "-----------------------------------------------------------------\n";
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Disciplina[] getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public int getQuantidadeDisciplinas() {
        return quantidadeDisciplinas;
    }
}
