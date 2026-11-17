package questao02;

/**
 * Representa um aluno com seus dados e as disciplinas em que está matriculado.
 */
public class Aluno {

    private String nome;
    private String matricula;
    private String curso;
    private int periodo;
    private int idade;
    private String endereco;
    private String[] disciplinasMatriculadas;
    private int quantidadeDisciplinas;

    /**
     * Cria um aluno.
     *
     * @param nome                              nome do aluno
     * @param matricula                         matrícula do aluno
     * @param curso                             curso do aluno
     * @param periodo                           período em que o aluno está
     * @param idade                             idade do aluno
     * @param quantidadeDisciplinasPermitidadas quantidade de disciplinas em que o
     *                                          aluno pode se matricular (tamanho do array)
     */
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

    /**
     * Inclui uma disciplina no array de disciplinas matriculadas.
     *
     * @param disciplina nome da disciplina
     * @return mensagem informando o resultado da matrícula
     */
    public String fazMatricula(String disciplina) {
        if (disciplinasMatriculadas.length == 0) {
            return "Este aluno não pode ser matriculado em nenhuma disciplina, por favor, fale com a secretaria.";
        }
        if (estaMatriculado(disciplina)) {
            return "Aluno já está matriculado na disciplina " + disciplina + ".";
        }
        if (quantidadeDisciplinas >= disciplinasMatriculadas.length) {
            return "Quantidade de disciplinas excedida. O limite de disciplinas para este aluno é de "
                    + disciplinasMatriculadas.length + " disciplina(s). Se desejar, cancele a matrícula "
                    + "de uma das disciplinas e faça a nova matrícula.";
        }
        disciplinasMatriculadas[quantidadeDisciplinas] = disciplina;
        quantidadeDisciplinas++;
        return "Matrícula na disciplina \"" + disciplina + "\" executada.";
    }

    /**
     * Exclui uma disciplina do array de disciplinas matriculadas.
     *
     * @param disciplina nome da disciplina
     * @return mensagem informando o resultado do cancelamento
     */
    public String cancelarMatricula(String disciplina) {
        int posicao = buscarDisciplina(disciplina);
        if (posicao == -1) {
            return "Aluno não está matriculado na disciplina " + disciplina
                    + ", portanto não é possível cancelar esta matrícula.";
        }
        // Desloca as disciplinas seguintes uma posição para a esquerda
        for (int i = posicao; i < quantidadeDisciplinas - 1; i++) {
            disciplinasMatriculadas[i] = disciplinasMatriculadas[i + 1];
        }
        quantidadeDisciplinas--;
        disciplinasMatriculadas[quantidadeDisciplinas] = null;
        return "Cancelamento da matrícula da disciplina " + disciplina + " executado com sucesso.";
    }

    /**
     * Retorna os dados do aluno e as disciplinas matriculadas de forma legível.
     *
     * @return texto com os dados do aluno
     */
    public String imprime() {
        String linha = "-----------------------------------------------------------------\n";
        String disciplinas = "";
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            if (i > 0) {
                disciplinas += "; ";
            }
            disciplinas += disciplinasMatriculadas[i];
        }
        return linha
                + "Nome do Aluno: " + nome + "\n"
                + "Matricula: " + matricula + "\n"
                + "Curso: " + curso + "\n"
                + "Periodo: " + periodo + "\n"
                + "Idade: " + idade + "\n"
                + "Endereco: " + (endereco == null ? "" : endereco) + "\n"
                + "Disciplinas Matriculadas: " + disciplinas + "\n"
                + linha;
    }

    /**
     * Redimensiona o array de disciplinas, mantendo as disciplinas já matriculadas
     * que couberem no novo tamanho.
     *
     * @param quantidadeDisciplinasPermitidadas nova quantidade de disciplinas permitidas
     */
    public void setQuantidadeDisciplinasPermitidas(int quantidadeDisciplinasPermitidadas) {
        String[] novoArray = new String[quantidadeDisciplinasPermitidadas];
        quantidadeDisciplinas = Math.min(quantidadeDisciplinas, quantidadeDisciplinasPermitidadas);
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            novoArray[i] = disciplinasMatriculadas[i];
        }
        disciplinasMatriculadas = novoArray;
    }

    public boolean estaMatriculado(String disciplina) {
        return buscarDisciplina(disciplina) != -1;
    }

    private int buscarDisciplina(String disciplina) {
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            if (disciplinasMatriculadas[i].equalsIgnoreCase(disciplina)) {
                return i;
            }
        }
        return -1;
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
        String[] copia = new String[quantidadeDisciplinas];
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            copia[i] = disciplinasMatriculadas[i];
        }
        return copia;
    }

    public int getQuantidadeDisciplinas() {
        return quantidadeDisciplinas;
    }

    public int getQuantidadeDisciplinasPermitidas() {
        return disciplinasMatriculadas.length;
    }
}
