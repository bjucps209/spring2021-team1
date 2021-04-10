import javax.swing.Action;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LevelBuilder {

    final Image IMG_CONE = new Image("/images/cone.png");
    final Image IMG_POT_HOLE = new Image("/images/blackhole.gif");
    final Image IMG_HUMAN = new Image("/images/human.png");

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
