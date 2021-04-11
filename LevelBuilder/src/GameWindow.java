import model.*;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.ObserverGame;
import model.Obstacle;
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
    final Image humanImage = new Image("/images/human.png");
    final Image potholeImage = new Image("/images/pothole.png");
    final Image truckImage = new Image("/images/truck.png");
    final Image coneImage = new Image("/images/cone.png");
    final Image carImage = new Image("/images/RoadBlockcar.png");
    final Image player = new Image("/images/player.png");

    ImageView imgPlayer = new ImageView(player);
    public void initialize(){
        
        imgPlayer.setPreserveRatio(true);
        imgPlayer.setFitWidth(100);
        imgPlayer.relocate(50 , 300);
        paneMain.getChildren().add(imgPlayer);

        ImageView obstacleImageView;
        
        Road road = new Road();

        Random rand = new Random();

        for(int i = 0; i < road.getUsingRB().size(); i++){
            RoadBlock type = road.getObjectType(road.getUsingRB().get(i));
            int x = road.getUsingRB().get(i).getX();
            int y = rand.nextInt(500);

            if(type == RoadBlock.PEOPLE){
                obstacleImageView = new ImageView(humanImage);
               // img.setPreserveRatio(true);
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(50);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            }else if (type == RoadBlock.POTHOLES){
                obstacleImageView = new ImageView(potholeImage);
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(50);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.TRUCK){
                obstacleImageView = new ImageView(truckImage);
                obstacleImageView.setFitWidth(75);
                obstacleImageView.setFitHeight(75);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.CONES){
                obstacleImageView = new ImageView(coneImage);
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(50);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.CARS){
                obstacleImageView = new ImageView(carImage);
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(50);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            }


        }
    }

    @Override
    public void update(ArrayList<Obstacle> list) {
        // TODO Auto-generated method stub

    }

     public void KeyEvent(KeyEvent event){


        if(event.getCode() == KeyCode.SPACE){
            input.set(State.JUMP);
           // imgPlayer.relocate(, );
            System.out.print("blah");
        } else if (event.getCode() == KeyCode.UP){
            input.set(State.LEFT);
            imgPlayer.relocate(100, 600);
            System.out.print("blah");
        } else if (event.getCode() == KeyCode.DOWN){
            input.set(State.RIGHT);
            System.out.print("blah");
        } else if (event.getCode() == KeyCode.RIGHT){
            input.set(State.SPEEDUP);
        } 
    

    // public int setLanes(int y){
    //     if(y <= 600 && y){

    //     }
    // }

    }
}