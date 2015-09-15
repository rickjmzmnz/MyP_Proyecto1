
package proyecto1;

import com.sun.glass.ui.Pixels;
import java.awt.Graphics2D;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author Ricardo Jiménez Méndez
 */
public class InterfazGraficaController implements Initializable {
    
    @FXML 
    ImageView grafica;
    @FXML
    TextField funcion;
    
    
    @FXML
    public void dibuja(ActionEvent event) {
        String entrada = funcion.getText();
        Tokenizer token = new Tokenizer(entrada);
        Evaluador eval = new Evaluador(token);
        //INTERFAZ
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        String p = "(^ x 2)";
        Tokenizer token = new Tokenizer(p);
        Evaluador eval = new Evaluador(token);
        double[][] arreglo = eval.eval(0,100);
        for(int i=0;i<1000;i++) {
            System.out.println("x = "+arreglo[i][0] +" "+"y = "+arreglo[i][1]);
        }*/        
    }    
    
    
    
}
