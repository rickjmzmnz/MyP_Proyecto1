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
public class Evaluador {
    
    private Tokenizer token;
    
    public Evaluador() {
        this.token = new Tokenizer();
    }
    
    public Evaluador(Tokenizer token) {
        this.token = token;
    }
    
    public double eval(double numero) {
         ArbolAnalizador arbol = this.token.getTree();
         ArbolAnalizador.Nodo nodo = arbol.getRaiz();    
         return ayudaEval(nodo,numero);
    }
    
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
                    //error
                } 
                return (div1 / div2);
            case "^" :
                double pot1 = ayudaEval(nodo.getIzq(), numero);
                double pot2 = ayudaEval(nodo.getDer(), numero);
                return Math.pow(pot1, pot2);
            default :               
                if(Numero.numero(nodo.getToken())) {
                return Double.parseDouble(nodo.getToken());
        }else{//mandar error
                
                }
        }
    return numero;
    }
}
