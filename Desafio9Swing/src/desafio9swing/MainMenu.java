package desafio9;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        super("Desafío 9 - Swing (Menú)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 260);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JLabel titulo = new JLabel("Elegí un ejercicio para abrir", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 18f));
        add(titulo, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(2, 2, 10, 10));

        JButton b1 = new JButton("1) Calculadora Simple");
        b1.addActionListener(e -> SwingUtilities.invokeLater(() -> new CalcSimple().setVisible(true)));

        JButton b2 = new JButton("2) Tamaño de Fuente");
        b2.addActionListener(e -> SwingUtilities.invokeLater(() -> new FuenteCombo().setVisible(true)));

        JButton b3 = new JButton("3) Selector de Lenguajes");
        b3.addActionListener(e -> SwingUtilities.invokeLater(() -> new SelectorLenguajes().setVisible(true)));

        JButton b4 = new JButton("4) Validación de Edad");
        b4.addActionListener(e -> ValidacionEdad.ejecutar());

        grid.add(b1);
        grid.add(b2);
        grid.add(b3);
        grid.add(b4);

        add(grid, BorderLayout.CENTER);

        JPanel south = new JPanel();
        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> dispose());
        south.add(salir);
        add(south, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
