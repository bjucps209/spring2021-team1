import java.util.ArrayList;
import java.util.Random;

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
    final Image humanImage = new Image("/images/human.png");
    final Image potholeImage = new Image("/images/pothole.png");
    final Image truckImage = new Image("/images/truck.png");
    final Image coneImage = new Image("/images/cone.png");
    final Image carImage = new Image("/images/RoadBlockcar.png");
    final Image player = new Image("/images/player.png");



    @FXML
    public void initialize(){
        Road road = Road.getInstance();

        ArrayList<Obstacle> usingRB = road.getUsingRB();

        var img = new ImageView(player);
        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(50 , 300);
        paneMain.getChildren().add(img);

        ImageView obstacleImageView;
        
        Random rand = new Random();

        for(int i = 0; i < road.getUsingRB().size(); i++){
            RoadBlock type = road.getObjectType(road.getUsingRB().get(i));
            int x = road.getUsingRB().get(i).getX();
            int y = rand.nextInt(500);

            if(type == RoadBlock.PEOPLE){
                obstacleImageView = new ImageView(humanImage);
                img.setPreserveRatio(true);
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

    // public int setLanes(int y){
    //     if(y <= 600 && y){

    //     }
    // }

}
