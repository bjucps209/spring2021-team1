import java.util.ArrayList;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.ObserverGame;
import model.Obstacle;
import model.Road;
import model.RoadBlock;
import model.State;

public class GameWindow implements ObserverGame {

    @FXML
    HBox hbox;
    @FXML
    Pane paneMain;
    @FXML
    Label lblCoord;

    Obstacle obstacle;
    ObjectProperty<State> input;

    // final Image humanImage = new Image("/images/human.gif");
    // final Image potholeImage = new Image("/images/blackhole.gif");
    final Image humanImage = new Image("/images/shield.png");
    final Image potholeImage = new Image("/images/speed.png");
    final Image truckImage = new Image("/images/truck.png");
    final Image coneImage = new Image("/images/cone.png");
    final Image carImage = new Image("/images/RoadBlockcar.png");
    final Image player = new Image("/images/player.png");

    public void initialize(){
        var img = new ImageView(player);
        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(50 , 300);
        paneMain.getChildren().add(img);
    }

    @Override
    public void update(ArrayList<Obstacle> list) {
        // TODO Auto-generated method stub

    }

}

// public class GameWindow {
// @FXML
// Pane paneMain;

// @FXML
// Label lblCoord;

// final Image IMG_CAR = new Image("/images/car.png");

// Obstacle obstacle;

// public void initialize() {
// var img = new ImageView(IMG_CAR);
// img.setPreserveRatio(true);
// img.setFitWidth(100);
// img.relocate(50 , 300);
// paneMain.getChildren().add(img);
// img.setOnKeyPressed(e -> keyPress(img););
// }

// private void keyPress(Node node) {

// }
// }
