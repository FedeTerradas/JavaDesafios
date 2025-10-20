package desafio10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuArchivo extends JFrame {

    public MenuArchivo() {
        super("Ejercicio 1 – Menú de archivo");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");

        JMenuItem nuevo = new JMenuItem("Nuevo");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem salir = new JMenuItem("Salir");

        nuevo.addActionListener((ActionEvent e) -> JOptionPane.showMessageDialog(this, "Nuevo (placeholder)"));
        guardar.addActionListener((ActionEvent e) -> JOptionPane.showMessageDialog(this, "Guardar (placeholder)"));
        salir.addActionListener((ActionEvent e) -> {
            int opt = JOptionPane.showConfirmDialog(
                    this,
                    "¿Desea cerrar la aplicación?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (opt == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        archivo.add(nuevo);
        archivo.add(guardar);
        archivo.addSeparator();
        archivo.add(salir);

        menuBar.add(archivo);
        setJMenuBar(menuBar);

        add(new JLabel("Menú Archivo con confirmación al salir", SwingConstants.CENTER), BorderLayout.CENTER);
    }
}
