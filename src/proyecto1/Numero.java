
package proyecto1;

/**
 * Clase para verificar si un número es válido
 * @author Ricardo Jiménez Méndez
 */
public class Numero {
    
    /**
     * Método para verificar
     * Si un número es válido
     * @param numero - número a verificar
     * @return true - si el número es válido
     * false - en otro caso
     */
    public static boolean numero(String numero) {
        try {
            double numeroDoble = Double.parseDouble(numero);
        } catch (NumberFormatException noNumero) {
            return false;
        }
        return true;            
        }
    }
    

