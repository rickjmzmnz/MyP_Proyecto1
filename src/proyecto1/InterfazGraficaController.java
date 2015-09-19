
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import jfx.messagebox.MessageBox;

/**
 *
 * @author Ricardo Jiménez Méndez
 */
public class InterfazGraficaController implements Initializable {
    
    @FXML 
    Canvas grafica;
    @FXML
    TextField funcion,ancho,alto,x1,x2,y1,y2;
    @FXML
    Button limpia,svg;
    
    /**
     * Método para poder gráficar la función dada
     * param event - acción al momento de gráficar una función
     */    
    @FXML
    public void dibuja(ActionEvent event) {
        String entrada = funcion.getText();
        Tokenizer token = new Tokenizer(entrada);
        Evaluador eval = new Evaluador(token);
        if (!Numero.numero(alto.getText()) || 
            !Numero.numero(ancho.getText()) ||
            !Numero.numero(x1.getText()) ||
            !Numero.numero(x2.getText()) ||
            !Numero.numero(y1.getText()) ||
            !Numero.numero(y2.getText())) {
            MessageBox.show(null, "Esto no es un numero", "Esto no es un numero", MessageBox.ICON_WARNING | MessageBox.OK);
        }
        double altura = Double.parseDouble(alto.getText());
        double anchura = Double.parseDouble(ancho.getText());
        double numerox1 = Double.parseDouble(x1.getText());
        double numerox2 = Double.parseDouble(x2.getText());
        double numeroy1 = Double.parseDouble(y1.getText());
        double numeroy2 = Double.parseDouble(y2.getText());
        double[][] arreglo = eval.eval(numerox1, numerox2);
        GraphicsContext pintura = grafica.getGraphicsContext2D();
        grafica.setHeight(altura);
        grafica.setWidth(anchura);
        pintura.strokeLine(0, (altura/2), anchura, (altura/2));
        pintura.strokeLine((anchura/2), 0, (anchura/2), altura);
        for(int i = 0;i < Evaluador.tamano-1;i++) {
            double difX = ((numerox2-numerox1)/2);
            double x1 = (anchura/2)+(((anchura/2)*arreglo[i][0])/difX);
            double x2 = (anchura/2)+(((anchura/2)*arreglo[i+1][0])/difX);
            double difY = ((numeroy2-numeroy1)/2);
            double y1 = (altura/2)-(((altura/2)*arreglo[i][1])/difY);
            double y2 = (altura/2)-(((altura/2)*arreglo[i+1][1])/difY);
            pintura.strokeLine(x1,y1,x2,y2);
        }
    }
 
    /**
     * Método para limpiar la gráfica
     * Y poder dibujar una nueva
     * param e - acción al momento de apretar el botón limpiar
     */   
    @FXML
    public void limpiar(ActionEvent e) {
        GraphicsContext pintura = grafica.getGraphicsContext2D();
        pintura.clearRect(0, 0, 
                Double.parseDouble(ancho.getText()), 
                Double.parseDouble(alto.getText()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
    }    
    
    
    
}
