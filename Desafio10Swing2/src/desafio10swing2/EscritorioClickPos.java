package desafio10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EscritorioClickPos extends JFrame {

    private final JLabel coord = new JLabel("Click para ver coordenadas (x, y)", SwingConstants.CENTER);

    public EscritorioClickPos() {
        super("Ejercicio 3 – Escritorio de usuarios");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(520, 360);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        coord.setFont(coord.getFont().deriveFont(Font.BOLD, 18f));
        add(coord, BorderLayout.CENTER);

        // Escuchar clics en todo el frame (content pane)
        getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                coord.setText("Posición: (" + e.getX() + ", " + e.getY() + ")");
            }
        });
    }
}
