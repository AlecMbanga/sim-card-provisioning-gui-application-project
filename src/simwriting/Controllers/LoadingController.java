package simwriting.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author alec
 */
public class LoadingController implements Initializable 
{

    @FXML
    private ImageView loadImg;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(loadImg);
        rotate.setDuration(Duration.seconds(160));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setByAngle(36000);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
    }
}