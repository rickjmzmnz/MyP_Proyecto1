/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author ricardo
 */
public class InterfazGraficaController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String p = "(^ x 2)";
        Tokenizer token = new Tokenizer(p);
        Evaluador eval = new Evaluador(token);
        double[][] arreglo = eval.eval(0,100);
        for(int i=0;i<1000;i++) {
            System.out.println("x = "+arreglo[i][0] +" "+"y = "+arreglo[i][1]);
        }
        
    }    
    
    
    
}
