
package proyecto1;

import jfx.messagebox.MessageBox;

/**
 * Clase para partir la cadena de entrada en tokens
 * Para ser guarados en el árbol 
 * @author Ricardo Jiménez Méndez
 */
public class Tokenizer {

    //Cadena a partir en tokens
    private String entrada;
    //Árbol para guardar los tokens
    private ArbolAnalizador arbol;

    /**
     * Constructor vacío de la clase Tokenizer
     */
    public Tokenizer() {
        this.entrada = "";
        this.arbol = new ArbolAnalizador();
    }

    /**
     * Constructor de la clase Tokenizer
     *
     * @param entrada - cadena de entrada
     */
    public Tokenizer(String entrada) {
        this.entrada = entrada;
        this.arbol = new ArbolAnalizador();
    }
    
    /**
     * Método que obtiene el árbol de tokens
     * A partir de la cadena de entrada
     * @return arbol - el árbol con los tokens
     */
    public ArbolAnalizador getTree() {
        ArbolAnalizador.Nodo nodo = this.arbol.getRaiz();
        String[] cadenaPartida = this.entrada.split("");
        tokenizar(cadenaPartida,nodo,0);
        return this.arbol;
    }
        
    /**
     * Método auxiliar para guardar la cadena partida en tokens en el árbol
     * De acuerdo a la gramática dada
     * Generamos los tokens a partir de la cadena de entrada
     * @param cadenaPartida - arreglo con la cadena de entrada
     * @param nodo - nodo para guardar los tokens
     * @param index - posición de los caracteres
     * @return int - la posición de los caracteres
     */
    private int tokenizar(String[] cadenaPartida, ArbolAnalizador.Nodo nodo,int index) {     
        for (int i = index; i < cadenaPartida.length; i++) {
            switch (cadenaPartida[i]) {
                case "x":
                    this.arbol.agrega("x", nodo);
                    return i+1;
                case " ":
                    break;
                case "(":
                    break;
                case ")":
                    break;
                case "-":
                    if (cadenaPartida[i + 1].equals("x")) {
                        this.arbol.agrega("-x", nodo);
                        i++;
                        return i+2;
                    }
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case ".":
                    int j = noNumber(cadenaPartida, i);
                    String nuevaCadena = this.entrada.substring(i, j);
                    this.arbol.agrega(nuevaCadena, nodo);
                    return j;
                case "s":
                    if (cadenaPartida[i + 1].equals("i") && cadenaPartida[i + 2].equals("n")) {
                        nodo = this.arbol.agrega("sin", nodo);
                        this.arbol.agrega("", nodo);
                        return tokenizar(cadenaPartida,nodo,i+3); 
                    } else if (cadenaPartida[i + 1].equals("q") && cadenaPartida[i + 2].equals("r")) {
                        nodo = this.arbol.agrega("sqr", nodo);
                        this.arbol.agrega("", nodo);
                        return tokenizar(cadenaPartida,nodo,i+3);
                    } else if (cadenaPartida[i + 1].equals("e") && cadenaPartida[i + 2].equals("c")) {
                        nodo = this.arbol.agrega("sec", nodo);
                        this.arbol.agrega("", nodo);
                        return tokenizar(cadenaPartida,nodo,i+3);
                    } else {
                       MessageBox.show(null, "Tu función no es correcta", "Función inválida", MessageBox.ICON_ERROR | MessageBox.OK);
                       break;
                    }
                case "c" :
                    if (cadenaPartida[i + 1].equals("o") && cadenaPartida[i + 2].equals("s")) {
                        nodo = this.arbol.agrega("cos", nodo);
                        this.arbol.agrega("", nodo);
                        return tokenizar(cadenaPartida,nodo,i+3);
                    } else if (cadenaPartida[i + 1].equals("o") && cadenaPartida[i + 2].equals("t")) {
                        nodo = this.arbol.agrega("cot", nodo);
                        this.arbol.agrega("", nodo);
                        return tokenizar(cadenaPartida,nodo,i+3);
                    } else if (cadenaPartida[i + 1].equals("s") && cadenaPartida[i + 2].equals("c")) {
                        nodo = this.arbol.agrega("csc", nodo);
                        this.arbol.agrega("", nodo);
                        return tokenizar(cadenaPartida,nodo,i+3);
                    } else {
                        MessageBox.show(null, "Tu función no es correcta", "Función inválida", MessageBox.ICON_ERROR | MessageBox.OK);
                        break;
                    }
                case "t" :
                    if (cadenaPartida[i + 1].equals("a") && cadenaPartida[i + 2].equals("n")) {
                        nodo = this.arbol.agrega("tan", nodo);
                        this.arbol.agrega("",nodo);    
                        return tokenizar(cadenaPartida,nodo,i+3);
                    } else {
                        MessageBox.show(null, "Tu función no es correcta", "Función inválida", MessageBox.ICON_ERROR | MessageBox.OK);
                        break;
                    }
                case "+" :
                    nodo = this.arbol.agrega("+", nodo);
                    int segundoMas = tokenizar(cadenaPartida,nodo,i+1);
                    return tokenizar(cadenaPartida,nodo,segundoMas);
                case "^" :
                    nodo = this.arbol.agrega("^", nodo);
                    int segundoElevar = tokenizar(cadenaPartida,nodo,i+1);
                    return tokenizar(cadenaPartida,nodo,segundoElevar);
                case "*" :
                    nodo = this.arbol.agrega("*", nodo);
                    int segundoPor = tokenizar(cadenaPartida,nodo,i+1);
                    return tokenizar(cadenaPartida,nodo,segundoPor);
                case "/" :
                    nodo = this.arbol.agrega("/", nodo);
                    int segundoEntre = tokenizar(cadenaPartida,nodo,i+1);
                    return tokenizar(cadenaPartida,nodo,segundoEntre);    
            }
        }

    return 0;    
    }
    
    /**
     * Método auxiliar para tokenizar
     * Nos ayúda a reconocer a un número en la cadena
     * @param arreglo - arreglo para guardar el número
     * @param i - inicio del arreglo
     * @return j+1 - índice que indíca el siguiente caracter
     * despues del número
     */
    private int noNumber(String[] arreglo, int i) {
        int j;
        for (j = i; j < arreglo.length; j++) {
            switch (arreglo[j]) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case ".":
                    break;
                default:
                    return j;
            }
        }
        return j + 1;
    }
}

