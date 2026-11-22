package questao04;

import java.util.Scanner;

public class SistemaAcademico {

    static Aluno[] alunos;
    static int quantidadeAlunos = 0;
    static Professor[] professores;
    static int quantidadeProfessores = 0;
    static Disciplina[] disciplinas;
    static int quantidadeDisciplinas = 0;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Quantos alunos serão cadastrados? ");
        alunos = new Aluno[Integer.parseInt(teclado.nextLine())];
        System.out.print("Quantos professores serão cadastrados? ");
        professores = new Professor[Integer.parseInt(teclado.nextLine())];
        System.out.print("Quantas disciplinas serão cadastradas? ");
        disciplinas = new Disciplina[Integer.parseInt(teclado.nextLine())];

        int opcao;
        do {
            System.out.println();
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Excluir aluno por nome");
            System.out.println("3 - Listar Alunos");
            System.out.println("4 - Matricular Aluno em Disciplina");
            System.out.println("5 - Cancelar Matrícula");
            System.out.println("6 - Imprimir lista Alunos e Disciplinas Matriculadas");
            System.out.println("7 - Cadastrar Disciplina");
            System.out.println("8 - Cadastrar Professor");
            System.out.println("9 - Relacionar Disciplina ao Professor");
            System.out.println("10 - Imprimir lista Professores e Disciplinas Ministradas");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {
                case 1: {
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = teclado.nextLine();
                    System.out.print("Curso: ");
                    String curso = teclado.nextLine();
                    System.out.print("Período: ");
                    int periodo = Integer.parseInt(teclado.nextLine());
                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(teclado.nextLine());
                    System.out.print("Endereço: ");
                    String endereco = teclado.nextLine();

                    // a quantidade de disciplinas é definida na primeira matrícula (opção 4)
                    Aluno novo = new Aluno(nome, matricula, curso, periodo, idade, 0);
                    novo.setEndereco(endereco);
                    cadastrarAluno(novo);
                    break;
                }
                case 2:
                    System.out.print("Nome do aluno: ");
                    excluirAlunoPorNome(teclado.nextLine());
                    break;
                case 3: {
                    Aluno[] lista = listarAlunos();
                    for (int i = 0; i < lista.length; i++) {
                        System.out.println((i + 1) + " - " + lista[i].getNome());
                    }
                    break;
                }
                case 4: {
                    Aluno aluno = buscarAluno();
                    if (aluno != null) {
                        Disciplina disciplina = buscarDisciplina();
                        if (disciplina != null) {
                            if (aluno.getQuantidadeDisciplinas() == 0) {
                                System.out.print("Em quantas disciplinas o aluno deve ser matriculado? ");
                                aluno.setQuantidadeDisciplinasPermitidas(Integer.parseInt(teclado.nextLine()));
                            }
                            System.out.println(matricularAlunoEmDisciplina(aluno, disciplina));
                        }
                    }
                    break;
                }
                case 5: {
                    Aluno aluno = buscarAluno();
                    if (aluno != null) {
                        System.out.print("Disciplina: ");
                        System.out.println(cancelarMatricula(aluno, teclado.nextLine()));
                    }
                    break;
                }
                case 6:
                    System.out.println(imprimirListaDeAlunoseDisciplinas());
                    break;
                case 7: {
                    System.out.print("Nome da disciplina: ");
                    String nome = teclado.nextLine();
                    System.out.print("Carga horária: ");
                    int cargaHoraria = Integer.parseInt(teclado.nextLine());
                    cadastrarDisciplina(new Disciplina(nome, cargaHoraria));
                    break;
                }
                case 8: {
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(teclado.nextLine());
                    System.out.print("Endereço: ");
                    String endereco = teclado.nextLine();
                    System.out.print("Titulação: ");
                    String titulacao = teclado.nextLine();
                    System.out.print("Quantas disciplinas o professor pode ministrar? ");
                    int maximo = Integer.parseInt(teclado.nextLine());
                    cadastrarProfessor(new Professor(nome, idade, endereco, titulacao, maximo));
                    break;
                }
                case 9: {
                    Professor professor = buscarProfessor();
                    if (professor != null) {
                        Disciplina disciplina = buscarDisciplina();
                        if (disciplina != null) {
                            System.out.println(professor.adicionarDisciplina(disciplina));
                        }
                    }
                    break;
                }
                case 10:
                    System.out.println(imprimirListaDeProfessoresEDisciplinas());
                    break;
                case 0:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void cadastrarAluno(Aluno aluno) {
        if (quantidadeAlunos == alunos.length) {
            System.out.println("Não é possível cadastrar mais alunos.");
        } else {
            alunos[quantidadeAlunos] = aluno;
            quantidadeAlunos++;
            System.out.println("Aluno cadastrado.");
        }
    }

    public static void excluirAlunoPorNome(String nomeAluno) {
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i].getNome().equals(nomeAluno)) {
                for (int j = i; j < quantidadeAlunos - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                quantidadeAlunos--;
                alunos[quantidadeAlunos] = null;
                System.out.println("Aluno excluído.");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public static Aluno[] listarAlunos() {
        Aluno[] lista = new Aluno[quantidadeAlunos];
        for (int i = 0; i < quantidadeAlunos; i++) {
            lista[i] = alunos[i];
        }
        return lista;
    }

    public static String matricularAlunoEmDisciplina(Aluno aluno, Disciplina disciplina) {
        return aluno.fazMatricula(disciplina);
    }

    public static String cancelarMatricula(Aluno aluno, String disciplina) {
        return aluno.cancelarMatricula(disciplina);
    }

    public static String imprimirListaDeAlunoseDisciplinas() {
        String texto = "";
        for (int i = 0; i < quantidadeAlunos; i++) {
            texto += alunos[i].imprime();
        }
        return texto;
    }

    public static void cadastrarDisciplina(Disciplina disciplina) {
        if (quantidadeDisciplinas == disciplinas.length) {
            System.out.println("Não é possível cadastrar mais disciplinas.");
        } else {
            disciplinas[quantidadeDisciplinas] = disciplina;
            quantidadeDisciplinas++;
            System.out.println("Disciplina cadastrada.");
        }
    }

    public static void cadastrarProfessor(Professor professor) {
        if (quantidadeProfessores == professores.length) {
            System.out.println("Não é possível cadastrar mais professores.");
        } else {
            professores[quantidadeProfessores] = professor;
            quantidadeProfessores++;
            System.out.println("Professor cadastrado.");
        }
    }

    public static String imprimirListaDeProfessoresEDisciplinas() {
        String texto = "";
        for (int i = 0; i < quantidadeProfessores; i++) {
            texto += professores[i].imprime();
        }
        return texto;
    }

    static Aluno buscarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = teclado.nextLine();
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (alunos[i].getNome().equals(nome)) {
                return alunos[i];
            }
        }
        System.out.println("Aluno não encontrado.");
        return null;
    }

    static Professor buscarProfessor() {
        System.out.print("Nome do professor: ");
        String nome = teclado.nextLine();
        for (int i = 0; i < quantidadeProfessores; i++) {
            if (professores[i].getNome().equals(nome)) {
                return professores[i];
            }
        }
        System.out.println("Professor não encontrado.");
        return null;
    }

    static Disciplina buscarDisciplina() {
        System.out.print("Disciplina: ");
        String nome = teclado.nextLine();
        for (int i = 0; i < quantidadeDisciplinas; i++) {
            if (disciplinas[i].getNome().equals(nome)) {
                return disciplinas[i];
            }
        }
        System.out.println("Disciplina não encontrada.");
        return null;
    }
}
