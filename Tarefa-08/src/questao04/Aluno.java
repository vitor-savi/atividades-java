package tarefa08.questao04;

public class Aluno {

    private String nome;
    private String matricula;
    private String curso;
    private int periodo;
    private int idade;
    private String endereco;
    private String[] disciplinasMatriculadas;
    private int quantidadeDisciplinas;

    public Aluno(String nome, String matricula, String curso, int periodo, int idade,
            int quantidadeDisciplinasPermitidadas) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
        this.idade = idade;
        this.disciplinasMatriculadas = new String[quantidadeDisciplinasPermitidadas];
        this.quantidadeDisciplinas = 0;
    }

    public String fazMatricula(String disciplina) {
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
        return "Matrícula na disciplina \"" + disciplina + "\" executada.";
    }

    public String cancelarMatricula(String disciplina) {
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            if (disciplinasMatriculadas[i].equals(disciplina)) {
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

    public String imprime() {
        String disciplinas = "";
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            if (i > 0) {
                disciplinas += "; ";
            }
            disciplinas += disciplinasMatriculadas[i];
        }
        return "-----------------------------------------------------------------\n"
                + "Nome do Aluno: " + nome + "\n"
                + "Matricula: " + matricula + "\n"
                + "Curso: " + curso + "\n"
                + "Periodo: " + periodo + "\n"
                + "Idade: " + idade + "\n"
                + "Endereco: " + endereco + "\n"
                + "Disciplinas Matriculadas: " + disciplinas + "\n"
                + "-----------------------------------------------------------------\n";
    }

    // usado na primeira matrícula para definir o tamanho do array de disciplinas
    public void setQuantidadeDisciplinasPermitidas(int quantidade) {
        disciplinasMatriculadas = new String[quantidade];
        quantidadeDisciplinas = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String[] getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public int getQuantidadeDisciplinas() {
        return quantidadeDisciplinas;
    }
}
