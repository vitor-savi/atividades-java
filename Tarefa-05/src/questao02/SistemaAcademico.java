package questao02;

import java.util.Scanner;

public class SistemaAcademico {

    static Aluno[] alunos;
    static int quantidadeAlunos = 0;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Quantos alunos serão cadastrados? ");
        int tamanho = Integer.parseInt(teclado.nextLine());
        alunos = new Aluno[tamanho];

        int opcao;
        do {
            System.out.println();
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Excluir aluno por nome");
            System.out.println("3 - Listar Alunos");
            System.out.println("4 - Matricular Aluno em Disciplina");
            System.out.println("5 - Cancelar Matrícula");
            System.out.println("6 - Imprimir lista Alunos e Disciplinas Matriculadas");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {
                case 1:
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
                case 2:
                    System.out.print("Nome do aluno: ");
                    excluirAlunoPorNome(teclado.nextLine());
                    break;
                case 3:
                    Aluno[] lista = listarAlunos();
                    for (int i = 0; i < lista.length; i++) {
                        System.out.println((i + 1) + " - " + lista[i].getNome());
                    }
                    break;
                case 4: {
                    Aluno aluno = buscarAluno();
                    if (aluno != null) {
                        if (aluno.getQuantidadeDisciplinas() == 0) {
                            System.out.print("Em quantas disciplinas o aluno deve ser matriculado? ");
                            aluno.setQuantidadeDisciplinasPermitidas(Integer.parseInt(teclado.nextLine()));
                        }
                        System.out.print("Disciplina: ");
                        System.out.println(matricularAlunoEmDisciplina(aluno, teclado.nextLine()));
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

    public static String matricularAlunoEmDisciplina(Aluno aluno, String disciplina) {
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
}
