
package proyecto1;
import jfx.messagebox.MessageBox;

/**
 * Clase para evaluar el árbol con la cadena
 * Ya partida en tokens
 * @author Ricardo Jiménez Méndez
 */
public class Evaluador {
    
    protected static final int tamano = 10000;
    //token con los caracteres
    private Tokenizer token;
    
    /**
     * Constructor vacío de la clase Evaluador
     */
    public Evaluador() {
        this.token = new Tokenizer();
    }
    
    /**
     * Constructor de la clase Evaluador
     * @param token - token con caracteres
     */
    public Evaluador(Tokenizer token) {
        this.token = token;
    }
    
    /**
     * Método que obtiene todos los valores que querramos evaluar
     * A partir de un intervalo dado
     * Regresamos todos los valores que se encuentren dentro del intervalo
     * @param numero1 - inicio del intervalo
     * @param numero2 - fin del intervalo
     * @return el arreglo con todos los valores evaluados
     */
    public double[][] eval(double numero1,double numero2) {
         double[][] arregloDoble = new double[tamano][2];
         ArbolAnalizador arbol = this.token.getTree();
         ArbolAnalizador.Nodo nodo = arbol.getRaiz(); 
         double intervalo = (numero2 - numero1)/tamano;
         for(int i = 0;i<tamano;i++) {
             arregloDoble[i][0] = numero1;
             arregloDoble[i][1] = ayudaEval(nodo, numero1);
             numero1 += intervalo;
         }         
         return arregloDoble; 
    }
    
    /**
     * Método auxiliar para obetern el valor de los tokens
     * Evaluamos de acuerdo al token que sea
     * Y regresamos el valor de las operaciones
     * @param nodo - nodo con el caracter a evaluar
     * @param numero - número a evaluar
     * @return el valor de los tokens
     */
    private double ayudaEval(ArbolAnalizador.Nodo nodo,double numero) {        
        switch(nodo.getToken()) {
            case "x" :
                return numero;
            case "-x" :
                return numero * (-1);
            case "sin" :
                double sin = ayudaEval(nodo.getDer(), numero);
                return Math.sin(sin);
            case "sec" :
                double sec = ayudaEval(nodo.getDer(), numero);
                return (1.0/(Math.cos(sec)));
            case "cos" :
                double cos = ayudaEval(nodo.getDer(), numero);
                return Math.cos(cos);
            case "csc" :
                double csc = ayudaEval(nodo.getDer(), numero);
                return (1.0/(Math.sin(csc)));
            case "tan" :
                double tan = ayudaEval(nodo.getDer(), numero);
                return Math.tan(tan);
            case "cot" :
                double cot = ayudaEval(nodo.getDer(), numero);
                return (1.0/(Math.tan(cot)));
            case "sqr" :
                double sqr = ayudaEval(nodo.getDer(), numero);
                return Math.sqrt(sqr);
            case "+" :
                double suma1 = ayudaEval(nodo.getIzq(), numero);
                double suma2 = ayudaEval(nodo.getDer(), numero);
                return (suma1 + suma2);
            case "-" :
                double resta1 = ayudaEval(nodo.getIzq(), numero);
                double resta2 = ayudaEval(nodo.getDer(), numero);
                return (resta1 - resta2);
            case "*" :
                double mult1 = ayudaEval(nodo.getIzq(), numero);
                double mult2 = ayudaEval(nodo.getDer(), numero);
                return (mult1 * mult2);     
            case "/" :
                double div1 = ayudaEval(nodo.getIzq(), numero);
                double div2 = ayudaEval(nodo.getDer(), numero);
                if(div2 == 0) {
                    return (div1 / 0.00001);
//return MessageBox.show(null, "División entre cero, (te vas a ir al infierno)", "División inválida", MessageBox.ICON_ERROR | MessageBox.OK);
                } else {                    
                return (div1 / div2);
                }
            case "^" :
                double pot1 = ayudaEval(nodo.getIzq(), numero);
                double pot2 = ayudaEval(nodo.getDer(), numero);
                return Math.pow(pot1, pot2);
            default :               
                if(Numero.numero(nodo.getToken())) {
                return Double.parseDouble(nodo.getToken());
                }else{
                return MessageBox.show(null, "Tu número no es correcto.", "Número inválida", MessageBox.ICON_ERROR | MessageBox.OK);
                }
        }    
    }
}
