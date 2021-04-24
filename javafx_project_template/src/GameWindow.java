
import java.io.File;
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
    final Image gifRoad = new Image("/images/recording.gif");
    final Image expImage = new Image("/images/explosion.gif");

    ImageView imgPlayer = new ImageView(player);

    Stage stage;

    // MainWindow mainwindow;
    ImageView img = new ImageView(player);

    @FXML
    public void initialize(Stage stage, int DL, int LS) {
        initializingObjects(DL, LS);
        // lblScore.textProperty().bind(road.getPlayer().getPropertyScores());

        // mainwindow = new MainWindow();
        // mainwindow.mainStage.getScene().setOnKeyPressed( e -> keyPressed(e) );

        // Road picture
        loadRoadImages();

        // var imgFire = new ImageView(fireImage) ;
        stage.setMaximized(true);
        stage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                keyPressed(e);
            }
        });

        // Adding Player Image

        // img.layoutYProperty().bindBidirectional((road.getPlayer().getY()));

        // Road.getInstance().setObserver(this);
        for (int i = 0; i < road.getUsingRB().size(); i++) {
            Obstacle obs = road.getUsingRB().get(i);
            RoadBlock type = road.getObjectType(road.getUsingRB().get(i));

            ImageView image;

            if (type == RoadBlock.PEOPLE) {
                image = setImage(humanImage, obs, 55);
            } else if (type == RoadBlock.POTHOLES) {
                image = setImage(potholeImage, obs, 100);
            } else if (type == RoadBlock.TRUCK) {
                image = setImage(truckImage, obs, 150);
            } else if (type == RoadBlock.CONES ) {
                image = setImage(coneImage, obs, 50);
            } else if (type == RoadBlock.CARS) {
                image = setImage(carImage, obs, 90);
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

        timeline = new Timeline(new KeyFrame(Duration.millis(9), e -> {
            // img.setX(img.getX() + 2);
            road.updateXPositionOfObstableAndPlayer();
            checkOver();
            // checkCollision();
            showOver();
        }));
        timeline.setCycleCount(1000);
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
            break;
        case ESCAPE:
            cheatMode = true;
            road.immunity(cheatMode);
        case RIGHT:
            road.setSpeedTrue();
        }
    }

    @FXML
    public ImageView setImage(Image imgs, Obstacle ob, int width) {
        ImageView obstacleImageView = new ImageView(imgs);
        obstacleImageView.setPreserveRatio(true);
        obstacleImageView.setFitWidth(width);
        obstacleImageView.setPreserveRatio(true);
        obstacleImageView.relocate(ob.getdoubleX(), ob.getdoubleY());
        paneMain.getChildren().add(obstacleImageView);
        imgviewList.add(obstacleImageView);
        obstacleImageView.layoutXProperty().bind(ob.getX());
        obstacleImageView.layoutYProperty().bind(ob.getY());
        return obstacleImageView;

    }

    public void initializingObjects(int DL, int LS){
        road = new Road(DL, LS);
        img.layoutXProperty().bindBidirectional(road.getPlayer().getCoordinate().getX());
        img.layoutYProperty().bindBidirectional(road.getPlayer().getCoordinate().getY());
        lblLife.textProperty().bind(road.getPlayer().getPropertyLives().asString());
        lblScore.textProperty().bind(road.getPlayer().getPropertyScores().asString());
    }

    public void loadRoadImages(){
        ImageView imgView = new ImageView();
        imgView.setImage(roadImage);
        imgView.setFitWidth(1250);
        imgView.setFitHeight(600);

        paneMain.getChildren().add(imgView);

        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(road.getPlayer().getCoordinate().getdoubleX(), road.getPlayer().getCoordinate().getdoubleY());

        paneMain.getChildren().add(img);
    }

    public void checkOver(){
        if(timeline.getCycleCount() == 0){
            gameOver = true;
        }
        
        // timeline.setOnFinished(event -> gameOver = true);
    }

    public void showOver(){
        if (road.getGameOver() == true) {
            timeline.stop();
            Alert alert = new Alert(AlertType.INFORMATION, "AHHH");
            alert.show();
        }
    }
}
