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
        String p = "(+ 1 2.123456789.09876)";
        Tokenizer token = new Tokenizer(p);
        Evaluador eval = new Evaluador(token);
        System.out.println(eval.eval(3.14/2));
    }    
    
    
    
}
