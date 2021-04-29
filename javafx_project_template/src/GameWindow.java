
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Action;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    final Image finishLineImage = new Image("/images/finsihedLine.png");

    ImageView imgPlayer = new ImageView(player);

    Stage stage;

    // MainWindow mainwindow;
    ImageView img = new ImageView(player);
    ImageView explosion = new ImageView(expImage);

    @FXML
    public void initialize(Stage stage, int DL, int LS, ArrayList<Obstacle> obstacles) throws IOException {

        bindsAndInitializing(DL, LS);
        // William's levelbuilder purposes
        if (obstacles != null) {
            road.setUsingRB(obstacles);
        }
        loadRoadImages(paneMain);
        stage.setMaximized(true);

        // when the key is released do these actions
        stage.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                keyReleased(e);
            }
        });
        stage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                keyPressed(event);
            }

        });
        setRoad(road);

        timeline = new Timeline(new KeyFrame(Duration.millis(9), e -> {
            // img.setX(img.getX() + 2);
            road.updateXPositionOfObstable();
            try {
                showOver();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }));
        timeline.setCycleCount(2000);
        timeline.play();

        Timeline timelineTwo = new Timeline(new KeyFrame((Duration.seconds(2.5)), e -> {
            if (road.isCrashed()) {
                road.collisionDealer();
            }
        }));
        timelineTwo.setCycleCount(1500);
        timelineTwo.play();
    }

    // ------------------
    @FXML
    public ImageView setImage(Image imgs, Obstacle ob, int width) {
        ImageView obstacleImageView = new ImageView(imgs);
        obstacleImageView.setFitWidth(width);
        obstacleImageView.setPreserveRatio(true);
        obstacleImageView.relocate(ob.getdoubleX(), ob.getdoubleY());
        paneMain.getChildren().add(obstacleImageView);
        imgviewList.add(obstacleImageView);
        obstacleImageView.layoutXProperty().bind(ob.getX());
        obstacleImageView.layoutYProperty().bind(ob.getY());
        return obstacleImageView;

    }

    // @FXML
    // void onSaveClicked(ActionEvent event) {
    // road.save();
    // }
    // ------------------------------------------------------------
    public void keyReleased(KeyEvent event) {
        KeyCode k = event.getCode();
        switch (k) {
        case RIGHT:
            road.setSpeedFalse();
            break;
        case A:
            road.immunity(true);
            break;
        case SPACE:
            road.setCollisionDetection(false);
            road.jumpOverdown();
            road.setCollisionDetection(true);
            break;
        case W:
            if(road.getNumOfSpeedUp() > 0){
                road.setCollisionDetection(false);
                road.superJumpOverdown();
                road.setCollisionDetection(true);
                break;
            }
            
        }
    }
    // ------------------------------------------------

    // -------------------------------------------------
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
            road.setCollisionDetection(false);
            road.jumpOverUp();
            road.setCollisionDetection(true);
            break;

        case ESCAPE:
            // cheatMode = true;
            // road.immunity(cheatMode);
        case RIGHT:
            // road.setSpeedTrue();
            break;
        case W:
            if(road.getNumOfSpeedUp() > 0){
                road.setCollisionDetection(false);
                road.superJumpOverUp();
                road.setCollisionDetection(true);
                break;
            }
        case S:
            road.save();
            
        }

    }

    // -------------------------------------------------//
    //Binds and initializes
    public void bindsAndInitializing(int DL, int LS) {
        road = new Road(DL, LS);
        img.layoutXProperty().bindBidirectional(road.getPlayer().getCoordinate().getX());
        img.layoutYProperty().bindBidirectional(road.getPlayer().getCoordinate().getY());
        gameOver.bind(road.getPropertyGameOver());
        collisionDetection.bind(road.getPropertyCollisionDetection());
        lblLife.textProperty().bind(road.getPlayer().getPropertyLives().asString());
        lblScore.textProperty().bind(road.getPlayer().getPropertyScores().asString());

    }
    //Loads the images for roads
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

    public void showOver() throws IOException {
        if (gameOver.get() == true) {

            var gLoader = new FXMLLoader(getClass().getResource("GameOver.fxml"));
            var gScene = new Scene(gLoader.load());
            var gStage = new Stage();
            GameOver windows = gLoader.getController();
            gStage.setScene(gScene);
            gStage.show();
            windows.initialzie();
        }
    }

    public void setHighScoreWhenGameOver() {
        PlayerHighScore playerHighScore = new PlayerHighScore("I won?", road.getPlayer().getPropertyScores().get());
        highScore.addPlayer(playerHighScore);
        try {
            highScore.addToTxtFile();
        } catch (IOException e1) {
            System.out.println("highscore error");
        }

    }

    void setRoad(Road r) {
        for (int i = 0; i < r.getUsingRB().size(); i++) {
            Obstacle obs = r.getUsingRB().get(i);
            RoadBlock type = r.getObjectType(r.getUsingRB().get(i));

            ImageView image;

            if (type == RoadBlock.PEOPLE) {
                image = setImage(humanImage, obs, 50);
            } else if (type == RoadBlock.POTHOLES) {
                image = setImage(potholeImage, obs, 100);
            } else if (type == RoadBlock.TRUCK) {
                image = setImage(truckImage, obs, 150);
            } else if (type == RoadBlock.CONES) {
                image = setImage(coneImage, obs, 50);
            } else if (type == RoadBlock.CARS) {
                image = setImage(carImage, obs, 90);
            } else if (type == RoadBlock.FINISHEDLINE) {
                ImageView obstacleImageView = new ImageView(finishLineImage);
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(600);
                obstacleImageView.relocate(obs.getdoubleX(), obs.getdoubleY());
                paneMain.getChildren().add(obstacleImageView);
                imgviewList.add(obstacleImageView);
                obstacleImageView.layoutXProperty().bind(obs.getX());
                obstacleImageView.layoutYProperty().bind(obs.getY());

            }
        }
    }

    public Road getRoad() {
        return road;
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
