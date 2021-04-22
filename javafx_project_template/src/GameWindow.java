
import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

public class GameWindow {

    @FXML
    HBox hbox;
    @FXML
    Pane paneMain;
    @FXML
    Label lblCoord;

    Timeline timeline;
    boolean gameOver;
    boolean cheatMode = false;
    Obstacle obstacle;
    ArrayList<ImageView> imgviewList = new ArrayList<>();
    Road road;
    AllHighScore highScore = AllHighScore.getInstance();

    // final Image humanImage = new Image("/images/human.gif");
    // final Image potholeImage = new Image("/images/blackhole.gif");
    final Image humanImage = new Image("/images/human.png");
    final Image potholeImage = new Image("/images/pothole.png");
    final Image truckImage = new Image("/images/truck.png");
    final Image coneImage = new Image("/images/cone.png");
    final Image carImage = new Image("/images/RoadBlockcar.png");
    final Image player = new Image("/images/player.png");
    final Image roadImage = new Image("/images/road.png");
    final Image expImage = new Image("/images/explosion.gif");

    ImageView imgPlayer = new ImageView(player);

    Stage stage;

    // MainWindow mainwindow;
    ImageView img = new ImageView(player);

    @FXML
    public void initialize(Stage stage, int DL, int LS) {
        road = new Road(DL, LS);
        
        // mainwindow = new MainWindow();
        // mainwindow.mainStage.getScene().setOnKeyPressed( e -> keyPressed(e) );

        // Road picture
        var imgRoad = new ImageView(roadImage);
        imgRoad.setFitWidth(1250);
        imgRoad.setFitHeight(600);
        paneMain.getChildren().add(imgRoad);

        // var imgFire = new ImageView(fireImage) ;
        stage.setMaximized(true);
        stage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                keyPressed(e);
            }
        });

        // Adding Player Image
        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(road.getPlayer().getCoordinate().getdoubleX(), road.getPlayer().getCoordinate().getdoubleY());
        paneMain.getChildren().add(img);
        
        img.layoutXProperty().bindBidirectional(road.getPlayer().getCoordinate().getX());
        img.layoutYProperty().bindBidirectional(road.getPlayer().getCoordinate().getY());

        // img.layoutYProperty().bindBidirectional((road.getPlayer().getY()));
        
        // Road.getInstance().setObserver(this);
        for (int i = 0; i < road.getUsingRB().size(); i++) {
            Obstacle obs = road.getUsingRB().get(i);
            RoadBlock type = road.getObjectType(road.getUsingRB().get(i));

            ImageView image;

            if (type == RoadBlock.PEOPLE) {
                image = setImage(humanImage, obs);
            } else if (type == RoadBlock.POTHOLES) {
                image = setImage(potholeImage, obs);
            } else if (type == RoadBlock.TRUCK) {
                image = setImage(truckImage, obs);
            } else if (type == RoadBlock.CONES) {
                image = setImage(coneImage, obs);
            } else if (type == RoadBlock.CARS) {
                image = setImage(carImage, obs);
            }
            // road.timer();
        }

        // Timeline timeline = new Timeline(new KeyFrame(Duration.millis(9), e -> img.setX(img.getX() + 2)));
        // timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> {
        //     road.updateXPositionOfObstableAndPlayer();
        //     road.detectCollision();
        //     // img.setX(img.getX() + 2);
        // }));
        // timeline.setCycleCount(Timeline.INDEFINITE);
        // timeline.play();
        // //checkCollision();

        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            // img.setX(img.getX() + 2);
            road.updateXPositionOfObstableAndPlayer();
            //checkCollision();
            if(road.getGameOver() == true){
                timeline.stop();
                Alert alert = new Alert(AlertType.INFORMATION, "AHHH");
                alert.show();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        

    }
   

    public void keyPressed(KeyEvent event) {
        KeyCode key = event.getCode();
        switch (key) {
        case UP: 
            Thread thread = road.switchUp();
            thread.start();
            break;
        case DOWN: // down one lane
            Thread thread2 = road.switchDown();
            thread2.start();
            break;
        case SPACE: //cant jump because it collides...
            road.setCollisionDetection(false);
            road.jumpOver();
            break;
        case ESCAPE:
            cheatMode = true;
        case RIGHT: 
            road.setSpeedTrue();
        }
    }

    @FXML
    public ImageView setImage(Image imgs, Obstacle ob) {
        ImageView obstacleImageView = new ImageView(imgs);
        obstacleImageView.setPreserveRatio(true);
        obstacleImageView.setFitWidth(50);
        obstacleImageView.setFitHeight(50);
        obstacleImageView.relocate(ob.getdoubleX(), ob.getdoubleY());
        paneMain.getChildren().add(obstacleImageView);
        imgviewList.add(obstacleImageView);
        obstacleImageView.layoutXProperty().bind(ob.getX());
        obstacleImageView.layoutYProperty().bind(ob.getY());
        return obstacleImageView;

    }

}
