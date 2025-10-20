package desafio9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public class SelectorLenguajes extends JFrame {

    private final DefaultListModel<String> modelo = new DefaultListModel<>();
    private final JList<String> lista = new JList<>(modelo);
    private final Map<String, String> info = new LinkedHashMap<>();

    public SelectorLenguajes() {
        super("Selector de Lenguajes");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(360, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8,8));

        info.put("Java", "Orientado a objetos. JVM. Muy usado en backend, Android, enterprise.");
        info.put("Python", "Sintaxis simple. Data science, scripting, IA, backend.");
        info.put("C++", "Alto rendimiento. Sistemas, motores de juego, embebidos.");
        info.put("JavaScript", "Web frontend/back (Node.js). React, Vue, Angular.");
        info.put("C#", ".NET, Windows, Unity. Similar a Java en sintaxis.");
        info.put("Go", "Concurrencia fácil. Backend y servicios de alto rendimiento.");

        info.keySet().forEach(modelo::addElement);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String sel = lista.getSelectedValue();
                    if (sel != null) {
                        JOptionPane.showMessageDialog(
                                SelectorLenguajes.this,
                                info.get(sel),
                                sel,
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }
        });

        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(new JLabel("Doble clic para ver info", SwingConstants.CENTER), BorderLayout.SOUTH);
    }
}
