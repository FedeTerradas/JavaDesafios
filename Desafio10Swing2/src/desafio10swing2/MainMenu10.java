package desafio10;

import javax.swing.*;
import java.awt.*;

public class MainMenu10 extends JFrame {

    public MainMenu10() {
        super("Desafío 10 - Swing 2 (Menú)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 320);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JLabel titulo = new JLabel("Elegí un ejercicio para abrir", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 18f));
        add(titulo, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(3, 2, 10, 10));

        JButton b1 = new JButton("1) Menú de archivo");
        b1.addActionListener(e -> SwingUtilities.invokeLater(() -> new MenuArchivo().setVisible(true)));

        JButton b2 = new JButton("2) Menú contextual");
        b2.addActionListener(e -> SwingUtilities.invokeLater(() -> new MenuContextual().setVisible(true)));

        JButton b3 = new JButton("3) Escritorio de usuarios (clic muestra x,y)");
        b3.addActionListener(e -> SwingUtilities.invokeLater(() -> new EscritorioClickPos().setVisible(true)));

        JButton b4 = new JButton("4) JDesktopPane + Nueva ventana");
        b4.addActionListener(e -> SwingUtilities.invokeLater(() -> new VentanasInternas().setVisible(true)));

        JButton b5 = new JButton("5) Detección de teclas (keyTyped)");
        b5.addActionListener(e -> SwingUtilities.invokeLater(() -> new DeteccionTeclas().setVisible(true)));

        grid.add(b1);
        grid.add(b2);
        grid.add(b3);
        grid.add(b4);
        grid.add(b5);

        add(grid, BorderLayout.CENTER);

        JPanel south = new JPanel();
        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> dispose());
        south.add(salir);
        add(south, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu10().setVisible(true));
    }
}
