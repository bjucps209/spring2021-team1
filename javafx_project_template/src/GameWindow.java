
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    BooleanProperty gameOver = new SimpleBooleanProperty();
    BooleanProperty collisionDetection = new SimpleBooleanProperty();
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

    public final int getScores() {
        return score.get();
    }

    @FXML
    public void initialize(Stage stage, int DL, int LS, ArrayList<Obstacle> obstacles) {

        bindsAndInitializing(DL, LS);

        //William's levelbuilder purposes
        if(obstacles != null){
            road.setUsingRB(obstacles);
        }

        loadRoadImages(paneMain);

        StageSetKeyPressed(stage);

        setRoad(road);

        timeline = new Timeline(new KeyFrame(Duration.millis(9), e -> {
            // img.setX(img.getX() + 2);
            score.set(score.get() + 2);
            road.updateXPositionOfObstableAndPlayer();
            checkOver();
            // checkCollision();
            try {
                showOver();
            } catch (IOException e1) {
                System.out.println("showOver error");
            }
        }));
        timeline.setCycleCount(1000);
        timeline.play();

    }

    void StageSetKeyPressed(Stage s) {
        s.setMaximized(true);
        Scene scene = s.getScene();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                keyPressed(e);
            }
        });
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
        case SPACE:
            if(collisionDetection.get() == true){ // cant jump because it collides...
                road.setCollisionDetection(false);
            }
            road.jumpOver();
            // img.setFitWidth();
            break;
        case ESCAPE:
            cheatMode = true;
            road.immunity(cheatMode);
        case RIGHT:
            road.setSpeedTrue();
        case W:
            road.immunity(true);
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

    public void bindsAndInitializing(int DL, int LS){
        road = new Road(DL, LS);
        img.layoutXProperty().bindBidirectional(road.getPlayer().getCoordinate().getX());
        img.layoutYProperty().bindBidirectional(road.getPlayer().getCoordinate().getY());
        gameOver.bind(road.getPropertyGameOver());
        collisionDetection.bind(road.getPropertyCollisionDetection());
        lblLife.textProperty().bind(road.getPlayer().getPropertyLives().asString());
        road.getPlayer().getPropertyScores().bind(score);
        lblLife.textProperty().bind(road.getPlayer().getPropertyLives().asString());
        lblScore.textProperty().bind(road.getPlayer().getPropertyScores().asString());
        
    }

    public void loadRoadImages(Pane pane) {
        ImageView imgView = new ImageView();
        imgView.setImage(roadImage);
        imgView.setFitWidth(1250);
        imgView.setFitHeight(600);

        pane.getChildren().add(imgView);

        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(road.getPlayer().getCoordinate().getdoubleX(), road.getPlayer().getCoordinate().getdoubleY());

        pane.getChildren().add(img);

    }

    public void checkOver(){
        if(timeline.getCycleCount() == 0){
            road.setGameOver(true);
        }

        // timeline.setOnFinished(event -> gameOver = true);
    }

    public void showOver() throws IOException {
        if (road.getGameOver() == true) {
            var gLoader = new FXMLLoader(getClass().getResource("GameOver.fxml"));
            var gScene = new Scene(gLoader.load());
            var gStage = new Stage();
            GameOver window = gLoader.getController();
            gStage.setScene(gScene);
            gStage.show();
        }
    }

    void setRoad(Road r) {
        for (int i = 0; i < r.getUsingRB().size(); i++) {
            Obstacle obs = r.getUsingRB().get(i);
            RoadBlock type = r.getObjectType(r.getUsingRB().get(i));

            ImageView image;

            if (type == RoadBlock.PEOPLE) {
                image = setImage(humanImage, obs, 55);
            } else if (type == RoadBlock.POTHOLES) {
                image = setImage(potholeImage, obs, 100);
            } else if (type == RoadBlock.TRUCK) {
                image = setImage(truckImage, obs, 150);
            } else if (type == RoadBlock.CONES) {
                image = setImage(coneImage, obs, 50);
            } else if (type == RoadBlock.CARS) {
                image = setImage(carImage, obs, 90);
            }
            // road.timer();
        }
    }
}

// COMMENTED CODE

// lblScore.textProperty().bind(Bindings.createStringBinding(
// () -> String.valueOf(score.getValue())), );

// lblScore.textProperty().bind(road.getPlayer().getPropertyScores());

// mainwindow = new MainWindow();
// mainwindow.mainStage.getScene().setOnKeyPressed( e -> keyPressed(e) );

// Road picture

// var imgFire = new ImageView(fireImage) ;

// img.layoutYProperty().bindBidirectional((road.getPlayer().getY()));

// Road.getInstance().setObserver(this);

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
