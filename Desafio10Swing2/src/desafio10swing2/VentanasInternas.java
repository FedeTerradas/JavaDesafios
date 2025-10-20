package desafio10;

import javax.swing.*;
import java.awt.*;

public class VentanasInternas extends JFrame {

    private final JDesktopPane desktop = new JDesktopPane();
    private int contador = 0;

    public VentanasInternas() {
        super("Ejercicio 4 – Eventos del mouse (JDesktopPane + JInternalFrame)");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(720, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8,8));

        JButton nueva = new JButton("Nueva ventana");
        nueva.addActionListener(e -> crearInternal());

        JPanel norte = new JPanel();
        norte.add(nueva);

        add(norte, BorderLayout.NORTH);
        add(desktop, BorderLayout.CENTER);
    }

    private void crearInternal() {
        contador++;
        String titulo = "Ventana #" + contador;
        JInternalFrame internal = new JInternalFrame(titulo, true, true, true, true);
        internal.setSize(260, 160);
        internal.setVisible(true);
        internal.add(new JLabel("Soy " + titulo, SwingConstants.CENTER), BorderLayout.CENTER);

        // Distribuir un poco en cascada
        int offset = 30 * (contador - 1);
        internal.setLocation(20 + offset % 200, 20 + offset % 150);

        desktop.add(internal);
        try { internal.setSelected(true); } catch (Exception ignored) {}
    }
}
