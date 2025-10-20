package desafio9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalcSimple extends JFrame {

    private final JTextField display = new JTextField();
    private String operadorPendiente = null;
    private Double acumulador = null;
    private boolean limpiadoPorOperacion = false;

    public CalcSimple() {
        super("Calculadora Simple");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 380);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8,8));

        // Panel superior (display)
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(display.getFont().deriveFont(Font.BOLD, 24f));
        add(display, BorderLayout.NORTH);

        // Panel centro (0-9)
        JPanel centro = new JPanel(new GridLayout(4,3,6,6));
        for (int i = 1; i <= 9; i++) {
            centro.add(botonNumero(String.valueOf(i)));
        }
        centro.add(new JLabel()); // hueco
        centro.add(botonNumero("0"));
        centro.add(new JLabel()); // hueco
        add(centro, BorderLayout.CENTER);

        // Panel inferior (operaciones)
        JPanel inferior = new JPanel(new GridLayout(1,5,6,6));
        inferior.add(botonOperacion("+"));
        inferior.add(botonOperacion("-"));
        inferior.add(botonOperacion("*"));
        inferior.add(botonOperacion("/"));
        inferior.add(botonClear());
        add(inferior, BorderLayout.SOUTH);
    }

    private JButton botonNumero(String txt) {
        JButton b = new JButton(txt);
        b.setFont(b.getFont().deriveFont(18f));
        b.addActionListener((ActionEvent e) -> {
            if (limpiadoPorOperacion) {
                display.setText("");
                limpiadoPorOperacion = false;
            }
            display.setText(display.getText() + txt);
        });
        return b;
    }

    private JButton botonOperacion(String op) {
        JButton b = new JButton(op);
        b.setFont(b.getFont().deriveFont(Font.BOLD, 18f));
        b.addActionListener(e -> aplicarOperacion(op));
        return b;
    }

    private JButton botonClear() {
        JButton b = new JButton("C");
        b.setFont(b.getFont().deriveFont(Font.BOLD, 18f));
        b.addActionListener(e -> {
            display.setText("");
            operadorPendiente = null;
            acumulador = null;
            limpiadoPorOperacion = false;
        });
        return b;
    }

    private void aplicarOperacion(String op) {
        String texto = display.getText().trim();
        if (texto.isEmpty()) {
            operadorPendiente = op;
            return;
        }

        double valorActual = Double.parseDouble(texto);

        if (acumulador == null) {
            acumulador = valorActual;
        } else if (operadorPendiente != null) {
            acumulador = resolver(acumulador, valorActual, operadorPendiente);
            display.setText(sinCeros(acumulador));
        }
        operadorPendiente = op;
        limpiadoPorOperacion = true;
    }

    private double resolver(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    JOptionPane.showMessageDialog(this, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                    return a;
                }
                return a / b;
            default: return b;
        }
    }

    private String sinCeros(double v) {
        if (v == (long) v) return String.format("%d", (long) v);
        return String.valueOf(v);
    }
}
