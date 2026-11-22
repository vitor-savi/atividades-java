package questao04;

public class Aluno extends Pessoa {

    private String matricula;
    private String curso;
    private int periodo;
    private Disciplina[] disciplinasMatriculadas;
    private int quantidadeDisciplinas;

    public Aluno(String nome, String matricula, String curso, int periodo, int idade,
            int quantidadeDisciplinasPermitidadas) {
        super(nome, idade, null);
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
        this.disciplinasMatriculadas = new Disciplina[quantidadeDisciplinasPermitidadas];
        this.quantidadeDisciplinas = 0;
    }

    public String fazMatricula(Disciplina disciplina) {
        if (disciplinasMatriculadas.length == 0) {
            return "Este aluno não pode ser matriculado em nenhuma disciplina, por favor, fale com a secretaria.";
        }
        if (quantidadeDisciplinas == disciplinasMatriculadas.length) {
            return "Quantidade de disciplinas excedida. O limite de disciplinas para este aluno é de "
                    + disciplinasMatriculadas.length + " disciplina(s). Se desejar, cancele a matrícula "
                    + "de uma das disciplinas e faça a nova matrícula.";
        }
        disciplinasMatriculadas[quantidadeDisciplinas] = disciplina;
        quantidadeDisciplinas++;
        return "Matrícula na disciplina \"" + disciplina.getNome() + "\" executada.";
    }

    public String cancelarMatricula(String disciplina) {
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            if (disciplinasMatriculadas[i].getNome().equals(disciplina)) {
                // puxa as disciplinas seguintes uma posição para trás
                for (int j = i; j < quantidadeDisciplinas - 1; j++) {
                    disciplinasMatriculadas[j] = disciplinasMatriculadas[j + 1];
                }
                quantidadeDisciplinas--;
                disciplinasMatriculadas[quantidadeDisciplinas] = null;
                return "Cancelamento da matrícula da disciplina " + disciplina + " executado com sucesso.";
            }
        }
        return "Aluno não está matriculado na disciplina " + disciplina
                + ", portanto não é possível cancelar esta matrícula.";
    }

    @Override
    public String imprime() {
        String disciplinas = "";
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            if (i > 0) {
                disciplinas += "; ";
            }
            disciplinas += disciplinasMatriculadas[i].getNome();
        }
        return "-----------------------------------------------------------------\n"
                + "Nome do Aluno: " + getNome() + "\n"
                + "Matricula: " + matricula + "\n"
                + "Curso: " + curso + "\n"
                + "Periodo: " + periodo + "\n"
                + "Idade: " + getIdade() + "\n"
                + "Endereco: " + getEndereco() + "\n"
                + "Disciplinas Matriculadas: " + disciplinas + "\n"
                + "-----------------------------------------------------------------\n";
    }

    public void setQuantidadeDisciplinasPermitidas(int quantidade) {
        disciplinasMatriculadas = new Disciplina[quantidade];
        quantidadeDisciplinas = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Disciplina[] getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public int getQuantidadeDisciplinas() {
        return quantidadeDisciplinas;
    }
}
