package desafio10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DeteccionTeclas extends JFrame {

    private final JLabel info = new JLabel("Teclea algo en el campo...", SwingConstants.CENTER);

    public DeteccionTeclas() {
        super("Ejercicio 5 – Detección de teclas (keyTyped)");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(520, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8,8));

        JTextField campo = new JTextField();
        campo.setFont(campo.getFont().deriveFont(16f));

        info.setFont(info.getFont().deriveFont(Font.BOLD, 16f));

        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String nombre = Character.isISOControl(c)
                        ? "Tecla de control (no imprimible)"
                        : "'" + c + "'";
                info.setText("keyTyped: " + nombre + "  (code=" + (int)c + ")");
            }
        });

        add(info, BorderLayout.NORTH);
        add(campo, BorderLayout.CENTER);
    }
}
