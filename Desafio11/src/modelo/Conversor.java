package modelo;

/**
 * EL MODELO (Conversor.java)
 *
 * Contiene la lógica de negocio pura y las fórmulas para
 * realizar los cálculos.
 * No sabe nada sobre la interfaz gráfica (Vista) ni sobre
 * quién lo está llamando (Controlador).
 */
public class Conversor {

    /**
     * Convierte un valor de grados Celsius a Fahrenheit.
     * Fórmula: (C * 9/5) + 32
     *
     * @param celsius El valor en grados Celsius.
     * @return El valor equivalente en grados Fahrenheit.
     */
    public double celsiusAFahrenheit(double celsius) {
        // Usamos 9.0 y 5.0 para asegurar una división con decimales
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Convierte un valor de grados Fahrenheit a Celsius.
     * Fórmula: (F - 32) * 5/9
     *
     * @param fahrenheit El valor en grados Fahrenheit.
     * @return El valor equivalente en grados Celsius.
     */
    public double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}
