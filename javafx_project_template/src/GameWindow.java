
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Obstacle;
import model.Road;
import model.RoadBlock;

<<<<<<< HEAD


public class GameWindow implements ObserverGame {
=======
public class GameWindow{
>>>>>>> 9132190cb54ed0857fdafddbcd9a7b6a1c0ca0b8

    @FXML
    HBox hbox;
    @FXML
    Pane paneMain;
    @FXML
    Label lblCoord;

    Obstacle obstacle;
  //  ObjectProperty<STATE> input;
    ArrayList<ImageView> imageViews = new ArrayList<>();
    ImageView obstacleImageView;
    Road road;




    // final Image humanImage = new Image("/images/human.gif");
    // final Image potholeImage = new Image("/images/blackhole.gif");
    final Image humanImage = new Image("/images/human.png");
    final Image potholeImage = new Image("/images/pothole.png");
    final Image truckImage = new Image("/images/truck.png");
    final Image coneImage = new Image("/images/cone.png");
    final Image carImage = new Image("/images/RoadBlockcar.png");
    final Image player = new Image("/images/player.png");

<<<<<<< HEAD
=======
    double xImg = 0;
    double yImg = 0;
>>>>>>> 9132190cb54ed0857fdafddbcd9a7b6a1c0ca0b8

    ImageView imgPlayer = new ImageView(player);

    @FXML
    public void initialize(){
        Road road = new Road();
        Random rand = new Random();

        var img = new ImageView(player);
        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(50, 300);
        paneMain.getChildren().add(img);
<<<<<<< HEAD
        
        Road road = new Road();

        Random rand = new Random();
        Road.getInstance().setObserver(this);
=======
>>>>>>> 9132190cb54ed0857fdafddbcd9a7b6a1c0ca0b8

        for (int i = 0; i < road.getUsingRB().size(); i++) {
            RoadBlock type = road.getObjectType(road.getUsingRB().get(i));
            int x = road.getUsingRB().get(i).getX();
            int y = road.getUsingRB().get(i).getY();

            if(type == RoadBlock.PEOPLE){
                setImage(humanImage, x, y);
            }else if (type == RoadBlock.POTHOLES){
                setImage(potholeImage, x, y);
            } else if (type == RoadBlock.TRUCK){
                setImage(truckImage, x, y);
            } else if (type == RoadBlock.CONES){
                setImage(coneImage, x, y);
            } else if (type == RoadBlock.CARS){
                setImage(carImage, x, y);
            }
        // road.timer();
        }
    }

    @Override
    public void update(ArrayList<Obstacle> list) {
        for (int i=0; i < imageViews.size(); i ++){
            imageViews.get(i).setX(list.get(i).getX());
        }

    }
    @FXML
    public void KeyEventJump(KeyEvent event){
        if(event.getCode() == KeyCode.SPACE){
            road.getPlayer().jumpUp();
        }
        // switch(event.getCode()){

        //     case KeyCode.SPACE
        // }

        // if(event.getCode() == KeyCode.SPACE){
            
        // } else if (event.getCode() == KeyCode.UP){
        //     input.set(State.LEFT);
        // } else if (event.getCode() == KeyCode.DOWN){
        //     input.set(State.RIGHT);
        // } else if (event.getCode() == KeyCode.RIGHT){
        //     input.set(State.SPEEDUP);
        // }
    }

    @FXML
    public void KeyEventLeft(KeyEvent event){
        if(event.getCode() == KeyCode.UP){
            road.getPlayer().jumpUp();
        }
    }
    @FXML
    public void KeyEventRight(KeyEvent event){
        if(event.getCode() == KeyCode.DOWN){
            road.getPlayer().rightLane();
        } 
    }

    @FXML
    public void setImage(Image imgs, int x, int y){
        obstacleImageView = new ImageView(imgs);
        obstacleImageView.setFitWidth(50);
        obstacleImageView.setFitHeight(50);
        obstacleImageView.relocate(x, y);
        paneMain.getChildren().add(obstacleImageView);
        imageViews.add(obstacleImageView);

    }
