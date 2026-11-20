package tarefa08.questao04;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class JanelaSistemaAcademico extends JFrame {
    private final JTextField campoNome = new JTextField(15);
    private final JTextField campoMatricula = new JTextField(15);
    private final JTextField campoCurso = new JTextField(15);
    private final JTextField campoPeriodo = new JTextField(15);
    private final JTextField campoIdade = new JTextField(15);
    private final JTextField campoEndereco = new JTextField(15);

    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final JList<String> listaAlunos = new JList<>(modeloLista);
    private final JTextArea areaSaida = new JTextArea(14, 50);

    public JanelaSistemaAcademico() {
        super("Sistema Acadêmico");

        JPanel formulario = new JPanel(new GridLayout(6, 2, 6, 6));
        formulario.setBorder(BorderFactory.createTitledBorder("Cadastro de aluno"));
        adicionarCampo(formulario, "Nome:", campoNome);
        adicionarCampo(formulario, "Matrícula:", campoMatricula);
        adicionarCampo(formulario, "Curso:", campoCurso);
        adicionarCampo(formulario, "Período:", campoPeriodo);
        adicionarCampo(formulario, "Idade:", campoIdade);
        adicionarCampo(formulario, "Endereço:", campoEndereco);

        JButton botaoCadastrar = new JButton("1 - Cadastrar Aluno");
        JButton botaoExcluir = new JButton("2 - Excluir Aluno por Nome");
        JButton botaoMatricular = new JButton("4 - Matricular em Disciplina");
        JButton botaoCancelar = new JButton("5 - Cancelar Matrícula");
        JButton botaoImprimir = new JButton("6 - Imprimir Alunos e Disciplinas");

        JPanel botoes = new JPanel(new GridLayout(5, 1, 6, 6));
        botoes.add(botaoCadastrar);
        botoes.add(botaoExcluir);
        botoes.add(botaoMatricular);
        botoes.add(botaoCancelar);
        botoes.add(botaoImprimir);

        JPanel topo = new JPanel(new BorderLayout(10, 10));
        topo.add(formulario, BorderLayout.CENTER);
        topo.add(botoes, BorderLayout.EAST);

        listaAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane rolagemLista = new JScrollPane(listaAlunos);
        rolagemLista.setBorder(BorderFactory.createTitledBorder("3 - Alunos cadastrados"));
        rolagemLista.setPreferredSize(new Dimension(230, 250));

        areaSaida.setEditable(false);
        areaSaida.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane rolagemSaida = new JScrollPane(areaSaida);
        rolagemSaida.setBorder(BorderFactory.createTitledBorder("Saída"));

        JPanel centro = new JPanel(new BorderLayout(10, 10));
        centro.add(rolagemLista, BorderLayout.WEST);
        centro.add(rolagemSaida, BorderLayout.CENTER);

        JPanel conteudo = new JPanel(new BorderLayout(10, 10));
        conteudo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        conteudo.add(topo, BorderLayout.NORTH);
        conteudo.add(centro, BorderLayout.CENTER);
        setContentPane(conteudo);

        botaoCadastrar.addActionListener(e -> cadastrarAluno());
        botaoExcluir.addActionListener(e -> excluirAlunoPorNome());
        botaoMatricular.addActionListener(e -> matricularAlunoEmDisciplina());
        botaoCancelar.addActionListener(e -> cancelarMatricula());
        botaoImprimir.addActionListener(e -> imprimirListaDeAlunosEDisciplinas());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        areaSaida.setText("Sistema iniciado. Capacidade: " + SistemaAcademico.alunos.length + " aluno(s).\n"
                + "Para matricular ou cancelar, selecione um aluno na lista.");
    }

    private void adicionarCampo(JPanel painel, String rotulo, JTextField campo) {
        painel.add(new JLabel(rotulo));
        painel.add(campo);
    }

    private void cadastrarAluno() {
        String nome = campoNome.getText().trim();
        String matricula = campoMatricula.getText().trim();
        String curso = campoCurso.getText().trim();
        if (nome.isEmpty() || matricula.isEmpty() || curso.isEmpty()) {
            mostrarAviso("Preencha nome, matrícula e curso.");
            return;
        }

        int periodo;
        int idade;
        try {
            periodo = Integer.parseInt(campoPeriodo.getText().trim());
            idade = Integer.parseInt(campoIdade.getText().trim());
        } catch (NumberFormatException ex) {
            mostrarAviso("Período e idade devem ser números inteiros.");
            return;
        }

        Aluno novo = new Aluno(nome, matricula, curso, periodo, idade, 0);
        novo.setEndereco(campoEndereco.getText().trim());

        int antes = SistemaAcademico.quantidadeAlunos;
        SistemaAcademico.cadastrarAluno(novo);
        if (SistemaAcademico.quantidadeAlunos == antes) {
            mostrarAviso("Não é possível cadastrar mais alunos. Limite: " + SistemaAcademico.alunos.length + ".");
            return;
        }

        atualizarLista();
        limparCampos();
        areaSaida.setText("Aluno " + nome + " cadastrado.");
    }

    private void excluirAlunoPorNome() {
        String sugestao = listaAlunos.getSelectedValue();
        String nome = (String) JOptionPane.showInputDialog(this, "Nome do aluno a excluir:",
                "Excluir aluno", JOptionPane.QUESTION_MESSAGE, null, null, sugestao);
        if (nome == null || nome.trim().isEmpty()) {
            return;
        }
        nome = nome.trim();

        int antes = SistemaAcademico.quantidadeAlunos;
        SistemaAcademico.excluirAlunoPorNome(nome);
        if (SistemaAcademico.quantidadeAlunos == antes) {
            mostrarAviso("Aluno não encontrado: " + nome + ".");
            return;
        }

        atualizarLista();
        areaSaida.setText("Aluno " + nome + " excluído.");
    }

    private void matricularAlunoEmDisciplina() {
        Aluno aluno = alunoSelecionado();
        if (aluno == null) {
            return;
        }

        if (aluno.getQuantidadeDisciplinas() == 0) {
            Integer quantidade = pedirInteiro("Em quantas disciplinas " + aluno.getNome() + " deve ser matriculado?");
            if (quantidade == null) {
                return;
            }
            aluno.setQuantidadeDisciplinasPermitidas(quantidade);
        }

        String disciplina = JOptionPane.showInputDialog(this, "Disciplina para matricular " + aluno.getNome() + ":");
        if (disciplina == null || disciplina.trim().isEmpty()) {
            return;
        }
        areaSaida.setText(SistemaAcademico.matricularAlunoEmDisciplina(aluno, disciplina.trim()));
    }

    private void cancelarMatricula() {
        Aluno aluno = alunoSelecionado();
        if (aluno == null) {
            return;
        }
        String disciplina = JOptionPane.showInputDialog(this, "Disciplina para cancelar de " + aluno.getNome() + ":");
        if (disciplina == null || disciplina.trim().isEmpty()) {
            return;
        }
        areaSaida.setText(SistemaAcademico.cancelarMatricula(aluno, disciplina.trim()));
    }

    private void imprimirListaDeAlunosEDisciplinas() {
        String texto = SistemaAcademico.imprimirListaDeAlunoseDisciplinas();
        areaSaida.setText(texto.isEmpty() ? "Nenhum aluno cadastrado." : texto);
        areaSaida.setCaretPosition(0);
    }

    private Aluno alunoSelecionado() {
        int indice = listaAlunos.getSelectedIndex();
        if (indice < 0) {
            mostrarAviso("Selecione um aluno na lista.");
            return null;
        }
        return SistemaAcademico.listarAlunos()[indice];
    }

    private void atualizarLista() {
        modeloLista.clear();
        for (Aluno aluno : SistemaAcademico.listarAlunos()) {
            modeloLista.addElement(aluno.getNome());
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoMatricula.setText("");
        campoCurso.setText("");
        campoPeriodo.setText("");
        campoIdade.setText("");
        campoEndereco.setText("");
        campoNome.requestFocus();
    }

    private void mostrarAviso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    private Integer pedirInteiro(String mensagem) {
        while (true) {
            String texto = JOptionPane.showInputDialog(this, mensagem);
            if (texto == null) {
                return null;
            }
            try {
                int valor = Integer.parseInt(texto.trim());
                if (valor >= 0) {
                    return valor;
                }
            } catch (NumberFormatException ex) {
            }
            mostrarAviso("Digite um número inteiro maior ou igual a zero.");
        }
    }

    private static Integer pedirCapacidade() {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, "Quantos alunos serão cadastrados?");
            if (texto == null) {
                return null;
            }
            try {
                int capacidade = Integer.parseInt(texto.trim());
                if (capacidade > 0) {
                    return capacidade;
                }
            } catch (NumberFormatException ex) {
            }
            JOptionPane.showMessageDialog(null, "Digite um número inteiro maior que zero.",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Integer capacidade = pedirCapacidade();
            if (capacidade != null) {
                SistemaAcademico.alunos = new Aluno[capacidade];
                SistemaAcademico.quantidadeAlunos = 0;
                new JanelaSistemaAcademico().setVisible(true);
            }
        });
    }
}
