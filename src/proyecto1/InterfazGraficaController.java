
package proyecto1;

import com.sun.glass.ui.Pixels;
import java.awt.Graphics2D;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Ricardo Jiménez Méndez
 */
public class InterfazGraficaController implements Initializable {
    
    @FXML 
    Canvas grafica;
    @FXML
    TextField funcion,ancho,alto,x1,x2;
    
    
    @FXML
    public void dibuja(ActionEvent event) {
        String entrada = funcion.getText();
        Tokenizer token = new Tokenizer(entrada);
        Evaluador eval = new Evaluador(token);
        double altura = Double.parseDouble(alto.getText());
        double anchura = Double.parseDouble(ancho.getText());
        double numero1 = Double.parseDouble(x1.getText());
        double numero2 = Double.parseDouble(x2.getText());
        double[][] arreglo = eval.eval(numero1, numero2);
        GraphicsContext pintura = grafica.getGraphicsContext2D();
        grafica.setHeight(altura);
        grafica.setWidth(anchura);
        pintura.clearRect(0, 0,anchura,altura);
        pintura.strokeLine(0, (altura/2), anchura, (altura/2));
        pintura.strokeLine((anchura/2), 0, (anchura/2), altura);
        //pintura.
        for(int i = 0;i < Evaluador.tamano-1;i++) {
            pintura.strokeLine((anchura/2) + arreglo[i][0],
                    (altura/2) - arreglo[i][1],
                    (anchura/2) + arreglo[i+1][0],
                    (altura/2) - arreglo[i+1][1]);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
    }    
    
    
    
}
