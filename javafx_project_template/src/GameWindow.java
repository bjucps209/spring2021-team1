import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Obstacle;

public class GameWindow {
    @FXML
    Pane paneMain;

    @FXML
    Label lblCoord;

    final Image IMG_CAR = new Image("/images/car.png");

    Obstacle obstacle;

    public void initialize() {
        var img = new ImageView(IMG_CAR);
        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(50 , 300);
        paneMain.getChildren().add(img);
        img.setOnKeyPressed(e -> keyPress(img););
    }

    private void keyPress(Node node) {
        

    }
}
