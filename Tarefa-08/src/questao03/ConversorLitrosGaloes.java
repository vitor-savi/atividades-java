package tarefa08.questao03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ConversorLitrosGaloes extends JFrame {
    private static final double LITROS_POR_GALAO = 3.785;

    private final JTextField campoLitros = new JTextField(10);
    private final JButton botaoConverter = new JButton("Converter");
    private final JLabel rotuloResultado = new JLabel("Informe um volume em litros.");

    public ConversorLitrosGaloes() {
        super("Conversor de Litros para Galões");

        JPanel entrada = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        entrada.add(new JLabel("Litros:"));
        entrada.add(campoLitros);
        entrada.add(botaoConverter);

        rotuloResultado.setBorder(BorderFactory.createEmptyBorder(8, 14, 14, 14));

        botaoConverter.addActionListener(e -> converter());

        add(entrada, BorderLayout.NORTH);
        add(rotuloResultado, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 140);
        setLocationRelativeTo(null);
    }

    private void converter() {
        try {
            double litros = Double.parseDouble(campoLitros.getText().trim().replace(',', '.'));
            if (litros < 0) {
                rotuloResultado.setText("Informe um valor positivo.");
                return;
            }
            double galoes = litros / LITROS_POR_GALAO;
            rotuloResultado.setText(String.format("%.2f litros = %.3f galões", litros, galoes));
        } catch (NumberFormatException ex) {
            rotuloResultado.setText("Valor inválido. Digite um número.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConversorLitrosGaloes().setVisible(true));
    }
}
