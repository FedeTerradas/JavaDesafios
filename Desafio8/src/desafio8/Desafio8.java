package desafio8;

// 1. Importa la clase Formulario que está en el OTRO paquete
import Formulario.Formulario;

/**
 *
 * @author Fede
 */
public class Desafio8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // 2. Crea una nueva instancia de tu formulario
        Formulario miVentana = new Formulario();

        // 3. Hazla visible
        miVentana.setVisible(true);
    }
}