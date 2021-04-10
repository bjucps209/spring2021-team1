import java.util.ArrayList;

import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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

<<<<<<< HEAD
    public void initialize(){
=======
<<<<<<< HEAD


    @FXML
=======
>>>>>>> 2ae60a483e2a4c45dfe6811dfaa2b0831c76a2b6
    public void initialize(){
        Road road = Road.getInstance();

<<<<<<< HEAD
        Road road = new Road();
        ArrayList<Obstacle> usingRB = road.getUsingRB();

=======
>>>>>>> 2ae60a483e2a4c45dfe6811dfaa2b0831c76a2b6
>>>>>>> 95c9169235f664b1941e3440351b8ebdc7f223c6
        var img = new ImageView(player);
        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(300 , 300);
        paneMain.getChildren().add(img);

        ImageView obstacleImageView;
        
        for(int i = 0; i < road.getUsingRB().size(); i++){
            RoadBlock type = road.getObjectType(road.getUsingRB().get(i));
            int x = road.getUsingRB().get(i).getX();

            if(type == RoadBlock.PEOPLE){
                obstacleImageView = new ImageView(humanImage);
                img.setPreserveRatio(true);
                obstacleImageView.setFitWidth(150);
                obstacleImageView.setFitHeight(150);
                obstacleImageView.relocate(x, 100);
                paneMain.getChildren().add(obstacleImageView);
            }else if (type == RoadBlock.POTHOLES){
                obstacleImageView = new ImageView(potholeImage);
                obstacleImageView.setFitWidth(150);
                obstacleImageView.setFitHeight(150);
                obstacleImageView.relocate(x, 100);
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.TRUCK){
                obstacleImageView = new ImageView(truckImage);
                obstacleImageView.setFitWidth(150);
                obstacleImageView.setFitHeight(150);
                obstacleImageView.relocate(x, 200);
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.CONES){
                obstacleImageView = new ImageView(coneImage);
                obstacleImageView.setFitWidth(150);
                obstacleImageView.setFitHeight(150);
                obstacleImageView.relocate(x, 200);
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.CARS){
                obstacleImageView = new ImageView(carImage);
                obstacleImageView.setFitWidth(150);
                obstacleImageView.setFitHeight(150);
                obstacleImageView.relocate(x, 300);
                paneMain.getChildren().add(obstacleImageView);
            }


        }
    }

    @Override
    public void update(ArrayList<Obstacle> list) {
        for(Obstacle i: list){
            
        }

        //for loop through the arraylist
        //set the image of the obstacle object to the certain x by doing obstacle.getX()
        //after creating a method of separating the lanes by abc, set the y of the same image by obstacle.getY();
        //CHeck for obstacle object type
    }

    public void KeyEvent(KeyEvent event){

        if(event.getCode() == KeyCode.SPACE){
            input.set(State.JUMP);
        } else if (event.getCode() == KeyCode.UP){
            input.set(State.LEFT);
        } else if (event.getCode() == KeyCode.DOWN){
            input.set(State.RIGHT);
        } else if (event.getCode() == KeyCode.RIGHT){
            input.set(State.SPEEDUP);
        }
    }

    public void getEachObject(){

        
    }  

}
