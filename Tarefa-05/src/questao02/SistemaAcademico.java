package questao02;

import java.util.Scanner;

/**
 * Sistema acadêmico que gerencia um array de alunos por meio de um menu.
 */
public class SistemaAcademico {

    private static Aluno[] alunos;
    private static int quantidadeAlunos = 0;
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Informe a quantidade de alunos que serão cadastrados: ");
        int tamanho = Integer.parseInt(teclado.nextLine().trim());
        alunos = new Aluno[tamanho];

        int opcao;
        do {
            System.out.println();
            System.out.println("========== SISTEMA ACADÊMICO ==========");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Excluir aluno por nome");
            System.out.println("3 - Listar Alunos");
            System.out.println("4 - Matricular Aluno em Disciplina");
            System.out.println("5 - Cancelar Matrícula");
            System.out.println("6 - Imprimir lista Alunos e Disciplinas Matriculadas");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(teclado.nextLine().trim());

            switch (opcao) {
                case 1:
                    opcaoCadastrarAluno();
                    break;
                case 2:
                    System.out.print("Nome do aluno a ser excluído: ");
                    excluirAlunoPorNome(teclado.nextLine());
                    break;
                case 3:
                    opcaoListarAlunos();
                    break;
                case 4:
                    opcaoMatricularAluno();
                    break;
                case 5:
                    opcaoCancelarMatricula();
                    break;
                case 6:
                    System.out.println(imprimirListaDeAlunoseDisciplinas());
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        teclado.close();
    }

    /**
     * Adiciona um aluno no array de alunos.
     *
     * @param aluno aluno a ser cadastrado
     */
    public static void cadastrarAluno(Aluno aluno) {
        if (quantidadeAlunos >= alunos.length) {
            System.out.println("Não é possível cadastrar: limite de " + alunos.length + " aluno(s) atingido.");
            return;
        }
        alunos[quantidadeAlunos] = aluno;
        quantidadeAlunos++;
        System.out.println("Aluno " + aluno.getNome() + " cadastrado com sucesso.");
    }

    /**
     * Exclui do array o aluno com o nome informado.
     *
     * @param nomeAluno nome do aluno a ser excluído
     */
    public static void excluirAlunoPorNome(String nomeAluno) {
        int posicao = buscarPosicaoAluno(nomeAluno);
        if (posicao == -1) {
            System.out.println("Aluno " + nomeAluno + " não encontrado.");
            return;
        }
        // Desloca os alunos seguintes uma posição para a esquerda
        for (int i = posicao; i < quantidadeAlunos - 1; i++) {
            alunos[i] = alunos[i + 1];
        }
        quantidadeAlunos--;
        alunos[quantidadeAlunos] = null;
        System.out.println("Aluno " + nomeAluno + " excluído com sucesso.");
    }

    /**
     * Retorna os alunos cadastrados.
     *
     * @return array somente com os alunos cadastrados
     */
    public static Aluno[] listarAlunos() {
        Aluno[] lista = new Aluno[quantidadeAlunos];
        for (int i = 0; i < quantidadeAlunos; i++) {
            lista[i] = alunos[i];
        }
        return lista;
    }

    /**
     * Matricula o aluno em uma disciplina.
     *
     * @param aluno      aluno a ser matriculado
     * @param disciplina nome da disciplina
     * @return mensagem informando o que ocorreu com a matrícula
     */
    public static String matricularAlunoEmDisciplina(Aluno aluno, String disciplina) {
        return aluno.fazMatricula(disciplina);
    }

    /**
     * Cancela a matrícula do aluno em uma disciplina.
     *
     * @param aluno      aluno que terá a matrícula cancelada
     * @param disciplina nome da disciplina
     * @return mensagem informando o que ocorreu com o cancelamento
     */
    public static String cancelarMatricula(Aluno aluno, String disciplina) {
        return aluno.cancelarMatricula(disciplina);
    }

    /**
     * Monta o texto com todos os alunos e suas disciplinas matriculadas.
     *
     * @return texto com os dados de todos os alunos
     */
    public static String imprimirListaDeAlunoseDisciplinas() {
        if (quantidadeAlunos == 0) {
            return "Nenhum aluno cadastrado.";
        }
        String texto = "";
        for (Aluno aluno : listarAlunos()) {
            texto += aluno.imprime();
        }
        return texto;
    }

    private static void opcaoCadastrarAluno() {
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Matrícula: ");
        String matricula = teclado.nextLine();
        System.out.print("Curso: ");
        String curso = teclado.nextLine();
        System.out.print("Período: ");
        int periodo = Integer.parseInt(teclado.nextLine().trim());
        System.out.print("Idade: ");
        int idade = Integer.parseInt(teclado.nextLine().trim());
        System.out.print("Endereço: ");
        String endereco = teclado.nextLine();

        // A quantidade de disciplinas é definida na primeira matrícula (opção 4)
        Aluno aluno = new Aluno(nome, matricula, curso, periodo, idade, 0);
        aluno.setEndereco(endereco);
        cadastrarAluno(aluno);
    }

    private static void opcaoListarAlunos() {
        Aluno[] lista = listarAlunos();
        if (lista.length == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (int i = 0; i < lista.length; i++) {
            System.out.println((i + 1) + " - " + lista[i].getNome() + " (" + lista[i].getMatricula() + ")");
        }
    }

    private static void opcaoMatricularAluno() {
        Aluno aluno = lerAluno();
        if (aluno == null) {
            return;
        }
        if (aluno.getQuantidadeDisciplinas() == 0) {
            System.out.print("Em quantas disciplinas o aluno deve ser matriculado? ");
            int quantidade = Integer.parseInt(teclado.nextLine().trim());
            aluno.setQuantidadeDisciplinasPermitidas(quantidade);
        }
        System.out.print("Disciplina: ");
        String disciplina = teclado.nextLine();
        System.out.println(matricularAlunoEmDisciplina(aluno, disciplina));
    }

    private static void opcaoCancelarMatricula() {
        Aluno aluno = lerAluno();
        if (aluno == null) {
            return;
        }
        System.out.print("Disciplina: ");
        String disciplina = teclado.nextLine();
        System.out.println(cancelarMatricula(aluno, disciplina));
    }

    private static Aluno lerAluno() {
        System.out.print("Nome do aluno: ");
        String nome = teclado.nextLine();
        int posicao = buscarPosicaoAluno(nome);
        if (posicao == -1) {
            System.out.println("Aluno " + nome + " não encontrado.");
            return null;
        }
        return alunos[posicao];
    }

    private static int buscarPosicaoAluno(String nome) {
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i].getNome().equalsIgnoreCase(nome.trim())) {
                return i;
            }
        }
        return -1;
    }
}
