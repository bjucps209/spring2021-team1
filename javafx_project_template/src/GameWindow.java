
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
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
import javafx.stage.Stage;
import model.ObserverGame;
import model.Obstacle;
import model.Road;
import model.RoadBlock;
import model.State;

public class GameWindow extends Application {

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

    double xImg = 0;
    double yImg = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        ImageView cImage = new ImageView(player);
        cImage.setPreserveRatio(true);
        cImage.relocate(50, 300);
        pane.getChildren().add(cImage);
        Scene scene = new Scene(pane, 600 , 1200);
    
        cImage.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.RIGHT)) {
                    cImage.setLayoutX(cImage.getLayoutX() + 50);
                }
                if (ke.getCode().equals(KeyCode.UP)) {
                    cImage.setLayoutY(cImage.getLayoutY() + 100);
                }
            }
        });

        cImage.setFocusTraversable(true);
        primaryStage.setTitle("Car"); 
        primaryStage.setScene(scene); 
        primaryStage.show();


        Road road = Road.getInstance();
        ArrayList<Obstacle> usingRB = road.getUsingRB();

        ImageView obstacleImageView;

        Random rand = new Random();

        for (int i = 0; i < usingRB.size(); i++) {
            RoadBlock type = road.getObjectType(usingRB.get(i));
            int x = usingRB.get(i).getX();
            int y = rand.nextInt(500);

            if (type == RoadBlock.PEOPLE) {
                obstacleImageView = new ImageView(humanImage);
                
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(50);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.POTHOLES) {
                obstacleImageView = new ImageView(potholeImage);
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(50);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.TRUCK) {
                obstacleImageView = new ImageView(truckImage);
                obstacleImageView.setFitWidth(75);
                obstacleImageView.setFitHeight(75);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.CONES) {
                obstacleImageView = new ImageView(coneImage);
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(50);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            } else if (type == RoadBlock.CARS) {
                obstacleImageView = new ImageView(carImage);
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(50);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
            }
        }
    }

    public void update(ArrayList<Obstacle> list) {
        for (Obstacle i : list) {

        }

        // for loop through the arraylist
        // set the image of the obstacle object to the certain x by doing
        // obstacle.getX()
        // after creating a method of separating the lanes by abc, set the y of the same
        // image by obstacle.getY();
        // CHeck for obstacle object type
    }

    // public void KeyEvent(KeyEvent event, Node node) {

    // if (event.getCode() == KeyCode.SPACE) {
    // } else if (event.getCode() == KeyCode.UP) {
    // input.set(State.LEFT);
    // } else if (event.getCode() == KeyCode.DOWN) {
    // input.set(State.RIGHT);
    // } else if (event.getCode() == KeyCode.RIGHT) {
    // input.set(State.SPEEDUP);
    // }
    // }

    // public int setLanes(int y){
    // if(y <= 600 && y){

    // }
    // }

}
