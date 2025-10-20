package desafio9;

import javax.swing.*;
import java.awt.*;

public class FuenteCombo extends JFrame {

    private final JLabel label = new JLabel("Texto de ejemplo", SwingConstants.CENTER);
    private final Integer[] tamanios = {12, 14, 16, 18, 20};

    public FuenteCombo() {
        super("Tamaño de Fuente");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(360, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8,8));

        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(label, BorderLayout.CENTER);

        JComboBox<Integer> combo = new JComboBox<>(tamanios);
        combo.setSelectedItem(16);
        combo.addActionListener(e -> {
            Integer size = (Integer) combo.getSelectedItem();
            if (size != null) {
                label.setFont(label.getFont().deriveFont((float) size));
            }
        });

        JPanel sur = new JPanel();
        sur.add(new JLabel("Tamaño:"));
        sur.add(combo);
        add(sur, BorderLayout.SOUTH);
    }
}
