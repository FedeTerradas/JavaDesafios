package desafio10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuContextual extends JFrame {

    public MenuContextual() {
        super("Ejercicio 2 – Menú contextual");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(520, 360);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8,8));

        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setText("Hacé clic derecho para ver el menú contextual...");

        // Menú emergente
        JPopupMenu popup = new JPopupMenu();
        popup.add(new JMenuItem("Copiar"));
        popup.add(new JMenuItem("Cortar"));
        popup.add(new JMenuItem("Pegar"));

        // Mostrar popup en clic derecho
        MouseAdapter ma = new MouseAdapter() {
            private void showIfPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
            @Override public void mousePressed(MouseEvent e) { showIfPopup(e); }
            @Override public void mouseReleased(MouseEvent e) { showIfPopup(e); }
        };
        area.addMouseListener(ma);

        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
