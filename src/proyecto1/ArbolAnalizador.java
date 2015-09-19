
package proyecto1;

/**
 * Clase para crear un árbol
 * Con el proposito de guardar la cadena de entrada
 * Para despues evaluarla
 * @author Ricardo Jiménez Méndez
 */
public class ArbolAnalizador {

    //Nodo raíz del árbol
    private Nodo raiz;

    public class Nodo {
        
        //Nodo izquierdo
        private Nodo izq;
        //Nodo derecho
        private Nodo der;
        //Nodo padre
        private Nodo padre;
        //Token con la cadena
        private String token;

        /**
         * Constructor vacío de la clase Nodo
         */
        public Nodo() {
            this.izq = null;
            this.der = null;
            this.padre = null;
            this.token = "";
        }

        /**
         * Constructor de la clase Nodo
         * @param token - cadena de entrada
         */
        public Nodo(String token) {
            this.izq = null;
            this.der = null;
            this.padre = null;
            this.token = token;
        }
        
        /**
         * Método para obtener
         * El valor del nodo izquierdo
         * @return el valor del nodo izquierdo
         */
        public Nodo getIzq() {
            return this.izq;
        }
        
        /**
         * Método para darle
         * Un valor al nodo izquierdo
         * @param izq - nodo izquierdo
         */
        public void setIzq(Nodo izq) {
            this.izq = izq;
        }
        
        /**
         * Método para obtener
         * El valor del nodo derecho
         * @return el valor del nodo derecho
         */
        public Nodo getDer() {
            return this.der;
        }
        
        /**
         * Método para darle
         * Un valor al nodo derecho
         * @param der - nodo derecho
         */
        public void setDer(Nodo der) {
            this.der = der;
        }

        /**
         * Método para obtener
         * El valor del nodo padre
         * @return el valor del padre
         */
        public Nodo getPadre() {
            return this.padre;
        }

        /**
         * Método para darle
         * Un valor al nodo padre
         * @param padre - nodo padre
         */
        public void setPadre(Nodo padre) {
            this.padre = padre;
        }
        
        /**
         * Método para obtener
         * El valor del token
         * @return el valor del token
         */ 
        public String getToken() {
            return this.token;
        }

        /**
         * Método para darle
         * Un valor al token
         * @param token - token con la cadena
         */
        public void setToken(String token) {
            this.token = token;
        }
    }

    /**
     * Constructor de la clase ArbolAnalizador
     */
    public ArbolAnalizador() {
        this.raiz = null;
    }

    /**
     * Método para obtener
     * El valor de la raíz
     * @return el valor de la raíz
     */
    public Nodo getRaiz() {
        return this.raiz;
    }

    /**
     * Método para agregar
     * Elementos al árbol
     * @param entrada - cadena a agregar
     * @param nodo - nodo donde guardamos la cadena
     * @return nodo agregado con la cadena
     */
    public Nodo agrega(String entrada, Nodo nodo) {
        if (this.raiz == null) {
            Nodo nodoRaiz = new Nodo(entrada);
            raiz = nodoRaiz;
            return this.raiz;
        } else if (nodo.getIzq() == null) {
            Nodo nodoIzq = new Nodo(entrada);
            nodoIzq.setPadre(nodo);
            nodo.setIzq(nodoIzq);
            return nodoIzq;
        } else {
            Nodo nodoDer = new Nodo(entrada);
            nodoDer.setPadre(nodo);
            nodo.setDer(nodoDer);
            return nodoDer;
        }
    }

}


