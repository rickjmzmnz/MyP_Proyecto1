/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author ricardo
 */
public class Numero {
    
    public static boolean numero(String numero) {
        try {
            double numeroDoble = Double.parseDouble(numero);
        } catch (NumberFormatException noNumero) {
            return false;
        }
        return true;
            
        }
    }
    

