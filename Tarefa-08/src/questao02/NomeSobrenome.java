package tarefa08.questao02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NomeSobrenome extends JFrame {
    private final JTextField campoNome = new JTextField(20);
    private final JTextField campoSobrenome = new JTextField(20);
    private final JLabel rodape = new JLabel(" ");

    public NomeSobrenome() {
        super("Nome e Sobrenome");

        JPanel campos = new JPanel(new GridLayout(2, 2, 8, 8));
        campos.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        campos.add(new JLabel("Nome:"));
        campos.add(campoNome);
        campos.add(new JLabel("Sobrenome:"));
        campos.add(campoSobrenome);

        rodape.setBorder(BorderFactory.createEmptyBorder(8, 12, 12, 12));

        KeyAdapter atualizador = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                atualizarRodape();
            }
        };
        campoNome.addKeyListener(atualizador);
        campoSobrenome.addKeyListener(atualizador);

        add(campos, BorderLayout.CENTER);
        add(rodape, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 180);
        setLocationRelativeTo(null);
    }

    private void atualizarRodape() {
        String completo = (campoNome.getText().trim() + " " + campoSobrenome.getText().trim()).trim();
        rodape.setText(completo.isEmpty() ? " " : completo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NomeSobrenome().setVisible(true));
    }
}
