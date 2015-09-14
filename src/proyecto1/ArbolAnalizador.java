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
public class ArbolAnalizador {

    private Nodo raiz;

    protected class Nodo {

        private Nodo izq;
        private Nodo der;
        private Nodo padre;
        private String token;

        /**
        * Constructor de la clase Nodo
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
        
        /*
        * Método para obtener
        * El valor del nodo derecho
        */
        public Nodo getDer() {
            return this.der;
        }
        
        /*
        * Método para darle
        * Un valor al nodo derecho
        * @param der 
        */
        public void setDer(Nodo der) {
            this.der = der;
        }

        /*
        * Método para obtener
        * El valor del nodo padre
        */
        public Nodo getPadre() {
            return this.padre;
        }

        /*
        * Método para darle
        * Un valor al nodo padre
        */
        public void setPadre(Nodo padre) {
            this.padre = padre;
        }

        public String getToken() {
            return this.token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    /*
    Constructor de la clase ArbolAnalizador
    */
    public ArbolAnalizador() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return this.raiz;
    }

    /*
    @param 
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


