

import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LevelBuilder {

    @FXML Slider sldLevel;
    @FXML FlowPane pane;
    IntegerProperty roadLength;
   
    

    final Image IMG_CONE = new Image("/images/cone.png");
    final Image IMG_POT_HOLE = new Image("/images/blackhole.gif");
    final Image IMG_HUMAN = new Image("/images/human.png");

    @FXML void initialize(){
        
        roadLength.bind(sldLevel.valueProperty());
        pane.setTranslateX((1000) * roadLength.get());
    }

    @FXML 
    void onPotholeClicked(ActionEvent e){
        var img = new ImageView(IMG_POT_HOLE);
    }

    @FXML 

    void onConeClicked(ActionEvent e){
        var img = new ImageView(IMG_CONE);
    }

    @FXML 

    void onHumanClicked(ActionEvent e){
        var img = new ImageView(IMG_HUMAN);
    }


}
