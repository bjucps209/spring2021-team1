import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Obstacle;

public class GameWindow {
    @FXML Pane pane;

    @FXML Label lblCoord;

    Obstacle obstacle;

    public void initialize(){
        Image image = new Image("\\images\\pngfind.com-skateboard-side-view-png-6935593.png");
        ImageView imageview = new ImageView(image);
        imageview.setX(50);
        imageview.setY(50);

        pane.getChildren().add(imageview);
    }

    
}
