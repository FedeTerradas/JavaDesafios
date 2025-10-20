package desafio9;

import javax.swing.*;

public class ValidacionEdad {

    public static void ejecutar() {
        String input = JOptionPane.showInputDialog(
                null,
                "Ingrese su edad:",
                "Validación de Edad",
                JOptionPane.QUESTION_MESSAGE
        );

        if (input == null) {
            return;
        }

        try {
            int edad = Integer.parseInt(input.trim());
            if (edad < 18) {
                JOptionPane.showMessageDialog(
                        null,
                        "Debes ser mayor de edad para continuar.",
                        "Acceso denegado",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "¡Bienvenido!",
                        "Acceso permitido",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ingrese un número válido para la edad.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
