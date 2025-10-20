package controlador;

import modelo.Conversor;
import vista.InterfazConversor; // Asegúrate de importar tu vista

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * EL CONTROLADOR (Actualizado para la Vista de NetBeans)
 *
 * Conecta el Modelo con la Vista (InterfazConversor)
 */
public class LogicaConversor implements ActionListener {

    private Conversor modelo;
    private InterfazConversor vista;

    /**
     * Constructor del Controlador.
     */
    public LogicaConversor(Conversor modelo, InterfazConversor vista) {
        this.modelo = modelo;
        this.vista = vista;

        // --- Conexión ---
        // Le decimos al ComboBox de la vista (obtenido con el getter)
        // que este Controlador (this) escuchará sus acciones.
        this.vista.getJComboBox1().addActionListener(this);
    }

    /**
     * Se ejecuta cuando el usuario cambia la selección del JComboBox.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // 1. OBTENER DATOS DE LA VISTA (usando los getters)
        String textoInput = vista.getJTextField1().getText();
        String opcionSeleccionada = (String) vista.getJComboBox1().getSelectedItem();

        if (textoInput.isEmpty() || textoInput.equals("______")) {
            vista.getJTextField2().setText(""); // Limpia el resultado
            return; // No hagas nada si no hay entrada
        }

        try {
            // 2. PROCESAR DATOS
            double valorInput = Double.parseDouble(textoInput);
            double resultado = 0.0;

            // 3. PEDIR AL MODELO QUE CALCULE
            if ("Celsius".equals(opcionSeleccionada)) {
                // Si quiere convertir A Celsius, la entrada es Fahrenheit
                resultado = modelo.fahrenheitACelsius(valorInput);
                
            } else if ("Fahrenheit".equals(opcionSeleccionada)) {
                // Si quiere convertir A Fahrenheit, la entrada es Celsius
                resultado = modelo.celsiusAFahrenheit(valorInput);
            }

            // 4. MOSTRAR RESULTADO EN LA VISTA (usando el getter)
            vista.getJTextField2().setText(String.format("%.2f", resultado));

        } catch (NumberFormatException ex) {
            // Manejo de error si la entrada no es un número
            vista.getJTextField2().setText("Error");
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese solo números.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            vista.getJTextField1().setText("______"); // Limpia la entrada
        }
    }

    /**
     * MÉTODO PRINCIPAL (MAIN)
     *
     * Este es el ÚNICO main que debe haber.
     * Arranca la aplicación.
     */
    public static void main(String[] args) {
        // 1. Crear el Modelo
        Conversor modelo = new Conversor();
        
        // 2. Crear la Vista (tu interfaz)
        InterfazConversor vista = new InterfazConversor();
        
        // 3. Crear el Controlador (y conectarlos)
        LogicaConversor controlador = new LogicaConversor(modelo, vista);
        
        // 4. Iniciar la aplicación
        vista.setVisible(true);
        vista.setLocationRelativeTo(null); // Centra la ventana
    }
}
