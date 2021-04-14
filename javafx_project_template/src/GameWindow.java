
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

public class GameWindow/*  implements ObserverGame */ {

    @FXML
    HBox hbox;
    @FXML
    Pane paneMain;
    @FXML
    Label lblCoord;
    Timeline timeline;

    Obstacle obstacle;
    // ObjectProperty<STATE> input;
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
    final Image roadImage = new Image("/images/road.png");
    final Image fireImage = new Image("/images/fire.gif");

    ImageView imgPlayer = new ImageView(player);

    @FXML
    public void initialize() {
        Road road = new Road();
        Random rand = new Random();

        
        
      // paneMain.setOnKeyPressed( e -> keyPressed(e) );
       
        var imgRoad = new ImageView(roadImage);
        imgRoad.setFitWidth(1250);
        imgRoad.setFitHeight(600);
        paneMain.getChildren().add(imgRoad);


        var img = new ImageView(player);
        //var imgFire = new ImageView(fireImage) ; 
        img.setOnKeyPressed( e -> keyPressed(e) );
        img.setPreserveRatio(true);
        img.setFitWidth(200);
        img.relocate(50, 300);
        paneMain.getChildren().add(img);


        // Road.getInstance().setObserver(this);

       
    

        for (int i = 0; i < road.getUsingRB().size(); i++) {
            RoadBlock type = road.getObjectType(road.getUsingRB().get(i));
            int x = road.getUsingRB().get(i).getX();
            int y = road.getUsingRB().get(i).getY();


            if (type == RoadBlock.PEOPLE) {
                setImage(humanImage, x, y);
            } else if (type == RoadBlock.POTHOLES) {
                setImage(potholeImage, x, y);
            } else if (type == RoadBlock.TRUCK) {
                setImage(truckImage, x, y);
            } else if (type == RoadBlock.CONES) {
                setImage(coneImage, x, y);
            } else if (type == RoadBlock.CARS) {
                setImage(carImage, x, y);
            }
            // road.timer();
        }

        // img.setOnKeyPressed( e -> keyPressed(e) );;
        timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> img.setX(img.getX() + 2)));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        
        for (int i = 2; i < paneMain.getChildren().size(); i++) {
            ImageView image = (ImageView)paneMain.getChildren().get(i);
            timeline = new Timeline(new KeyFrame(Duration.millis(50), 
        e -> image.setX(image.getX() - 2)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        }

    }

    

    /* @FXML
    public void KeyEventJump(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            road.getPlayer().jumpUp();
        } */
        // switch(event.getCode()){

        // case KeyCode.SPACE
        // }

        // if(event.getCode() == KeyCode.SPACE){

        // } else if (event.getCode() == KeyCode.UP){
        // input.set(State.LEFT);
        // } else if (event.getCode() == KeyCode.DOWN){
        // input.set(State.RIGHT);
        // } else if (event.getCode() == KeyCode.RIGHT){
        // input.set(State.SPEEDUP);
        // }
    }

   /*  @FXML public void keyPressed(KeyEvent event){

        KeyCode key = event.getCode();   
        System.out.println("Key Pressed: " + key);

    }
 */
   /*  @FXML
    public void KeyEventLeft(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {
            road.getPlayer().jumpUp();
        }
    }
 */
   /*  @FXML
    public void KeyEventRight(KeyEvent event) {
        if (event.getCode() == KeyCode.DOWN) {
            road.getPlayer().rightLane();
        }
    } */


    

    @FXML
    public void setImage(Image imgs, int x, int y) {
        obstacleImageView = new ImageView(imgs);
        obstacleImageView.setPreserveRatio(true);
        obstacleImageView.setFitWidth(50);
        obstacleImageView.setFitHeight(50);
        obstacleImageView.relocate(x, y);
        paneMain.getChildren().add(obstacleImageView);
        imageViews.add(obstacleImageView);

    }
}
