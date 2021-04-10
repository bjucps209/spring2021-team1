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

public class GameWindow implements ObserverGame{
    @FXML Pane pane;
    @FXML HBox hbox;
    @FXML
    Pane paneMain;
    @FXML
    Label lblCoord;

    final Image IMG_CAR = new Image("/images/player.png");

    Obstacle obstacle;
    ObjectProperty<State> input;

    // final Image humanImage = new Image("/images/human.gif");
    // final Image potholeImage = new Image("/images/blackhole.gif");
    final Image humanImage = new Image("/images/shield.gif");
    final Image potholeImage = new Image("/images/speed.gif");
    final Image truckImage = new Image("/images/truck.png");
    final Image coneImage = new Image("/images/cone.png");
    final Image carImage = new Image("/images/RoadBlockcar.png");



    @FXML
    public void initialize(){

        Road road = new Road();
        ArrayList<Obstacle> usingRB = road.getUsingRB();

        var img = new ImageView(IMG_CAR);
        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(50 , 300);
        pane.getChildren().add(img);

        ImageView obstacleImageView;


        for(int i = 0; i < usingRB.size(); i++){
            RoadBlock type = road.getObjectType(usingRB.get(i));
            
            if(type == RoadBlock.PEOPLE){
                obstacleImageView = new ImageView(humanImage);
                pane.getChildren().add(obstacleImageView);
            }else if (type == RoadBlock.POTHOLES){
                obstacleImageView = new ImageView(potholeImage);
                pane.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.TRUCK){
                obstacleImageView = new ImageView(truckImage);
                pane.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.CONES){
                obstacleImageView = new ImageView(coneImage);
                pane.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.CARS){
                obstacleImageView = new ImageView(carImage);
                pane.getChildren().add(obstacleImageView);
            }

            
        }

    }
    @Override
    public void update(ArrayList<Obstacle> list) {
        //for loop through the arraylist
        //set the image of the obstacle object to the certain x by doing obstacle.getX()
        //after creating a method of separating the lanes by abc, set the y of the same image by obstacle.getY();
        //CHeck for obstacle object type
    }

    public void keyEvent(KeyEvent event){
        // Player player = 

        // State[] state = State.values();
        // for(State s: state){
        // {
        //     switch (s){
        //         case JUMP:
        //             jumpUp();
        //         case SPEEDUP:
        //             break;
        //             // speedUp();
        //         case LEFT:
        //             break;
        //         case RIGHT:
        //             break;
        //         case MOVING:
        //             break;
        //     default:
        //         break;
        //     }
        // }
        // }
        // // if(event.getCode() == KeyCode.SPACE){
        //     input.set(State.JUMP);
        // } else if (event.getCode() == KeyCode.UP){
        //     input.set(State.LEFT);
        // } else if (event.getCode() == KeyCode.DOWN){
        //     input.set(State.RIGHT);
        // } else if (event.getCode() == KeyCode.RIGHT){
        //     input.set(State.SPEEDUP);
        // }

    }

    
}
    
// public class GameWindow {
//     @FXML
//     Pane paneMain;

//     @FXML
//     Label lblCoord;

//     final Image IMG_CAR = new Image("/images/car.png");

//     Obstacle obstacle;

//     public void initialize() {
//         var img = new ImageView(IMG_CAR);
//         img.setPreserveRatio(true);
//         img.setFitWidth(100);
//         img.relocate(50 , 300);
//         paneMain.getChildren().add(img);
//         img.setOnKeyPressed(e -> keyPress(img););
//     }

//     private void keyPress(Node node) {
        

//     }
// }
