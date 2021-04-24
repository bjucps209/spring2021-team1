
import java.io.File;
import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

public class GameWindow {

    @FXML
    VBox hbox;
    @FXML
    Pane paneMain;
    @FXML
    Label lblLife, lblScore;

    Timeline timeline;
    boolean gameOver;
    boolean cheatMode = false;
    Obstacle obstacle;
    IntegerProperty score = new SimpleIntegerProperty(); 
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
    final Image roadGif = new Image("/images/recording.gif");
    final Image expImage = new Image("/images/explosion.gif");

    ImageView imgPlayer = new ImageView(player);

    Stage stage;

    // MainWindow mainwindow;
    ImageView img = new ImageView(player);
    ImageView explosion = new ImageView(expImage);

    public final void setScores(int value){
        score.set(value);
    }
    public IntegerProperty getPropertyScores() {
        return score;
    }
    public final int getScores(){
        return score.get();
    }

    @FXML
    public void initialize(Stage stage, int DL, int LS) {
       // initializingObjects(DL, LS);
        // lblScore.textProperty().bind(road.getPlayer().getPropertyScores());

        // mainwindow = new MainWindow();
        // mainwindow.mainStage.getScene().setOnKeyPressed( e -> keyPressed(e) );

        // Road picture
        ImageView imgView = new ImageView();
        imgView.setImage(roadImage);
        imgView.setFitWidth(1250);
        imgView.setFitHeight(600);

        paneMain.getChildren().add(imgView);

        // var imgFire = new ImageView(fireImage) ;
        stage.setMaximized(true);
        Scene scene = stage.getScene();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
        road.getPlayer().getPropertyScores().bind(score);

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

        // Timeline timeline = new Timeline(new KeyFrame(Duration.millis(9), e ->
        // img.setX(img.getX() + 2)));
        // timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> {
        // road.updateXPositionOfObstableAndPlayer();
        // road.detectCollision();
        // // img.setX(img.getX() + 2);
        // }));
        // timeline.setCycleCount(Timeline.INDEFINITE);
        // timeline.play();
        // //checkCollision();

        timeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {
            // img.setX(img.getX() + 2);
            score.set(score.get() + 2);;
            System.out.println(score.get());
            road.updateXPositionOfObstableAndPlayer();
            // checkCollision();
            if (road.getGameOver() == true) {
                timeline.stop();
                explosion.relocate(road.getPlayer().getCoordinate().getdoubleX(), road.getPlayer().getCoordinate().getdoubleY());
                paneMain.getChildren().add(explosion);
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
        case SPACE: // cant jump because it collides...
            road.setCollisionDetection(false);
            road.jumpOver();
           // img.setFitWidth();
            break;
        case ESCAPE:
            cheatMode = true;
            road.immunity(cheatMode);
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
