
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
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
    IntegerProperty scoreView = new SimpleIntegerProperty();
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

    public final void setScores(int value) {
        scoreView.set(value);
    }

    public IntegerProperty getPropertyScoreView() {
        return scoreView;
    }

    public final int getScores() {
        return scoreView.get();
    }

    @FXML
    public void initialize(Stage stage, int DL, int LS) throws IOException {
        // lblScore.textProperty().bind(Bindings.createStringBinding(
        // () -> String.valueOf(score.getValue())), );

        initializingObjects(DL, LS);
        // lblScore.textProperty().bind(road.getPlayer().getPropertyScores());

        // mainwindow = new MainWindow();
        // mainwindow.mainStage.getScene().setOnKeyPressed( e -> keyPressed(e) );

        // Road picture
        loadRoadImages();

        // var imgFire = new ImageView(fireImage) ;
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

        // img.layoutYProperty().bindBidirectional((road.getPlayer().getY()));

        // Road.getInstance().setObserver(this);
        for (int i = 0; i < road.getUsingRB().size(); i++) {
            Obstacle obs = road.getUsingRB().get(i);
            RoadBlock type = road.getObjectType(road.getUsingRB().get(i));

            ImageView image;

            if (type == RoadBlock.PEOPLE) {
                image = setImage(humanImage, obs, 50);
            } else if (type == RoadBlock.POTHOLES) {
                image = setImage(potholeImage, obs, 90);
            } else if (type == RoadBlock.TRUCK) {
                image = setImage(truckImage, obs, 125);
            } else if (type == RoadBlock.CONES) {
                image = setImage(coneImage, obs, 45);
            } else if (type == RoadBlock.CARS) {
                image = setImage(carImage, obs, 80);
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

        timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> {
            // img.setX(img.getX() + 2);
            scoreView.set(scoreView.get() + 1);
            ;
            System.out.println(scoreView.get());
            road.updateXPositionOfObstableAndPlayer();
            checkOver();
            // checkCollision();
            try {
                showOver();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }));
        timeline.setCycleCount(timeline.INDEFINITE);
        timeline.play();
        if(timeline.getStatus().equals(javafx.animation.Animation.Status.STOPPED)){
            PlayerHighScore playerHighScore = new PlayerHighScore("I won?", road.getPlayer().getPropertyScores().get());
            highScore.addPlayer(playerHighScore);
            highScore.addToTxtFile();
        };
    }

    public void onFinishedGame(ActionEvent event) throws IOException{
        
        
    }

    protected void keyReleased(KeyEvent event) {
        KeyCode k = event.getCode();
        switch (k) {
        case RIGHT:
            road.setSpeedFalse();
            break;
        case D:
            road.blowUp();
            break;
        case A:
            road.immunity(true);
            break;
        case W:
            road.superJump();
            break;
        }
    }

    public void keyPressed(KeyEvent event) {
        KeyCode key = event.getCode();
        switch (key) {
        case UP:
            Thread thread = road.switchUp();
            thread.start();
            // road.switchUp();
            break;
        case DOWN: // down one lane
            Thread thread2 = road.switchDown();
            thread2.start();
            // road.switchDown();
            break;
        case SPACE: // cant jump because it collides...
            road.setCollisionDetection(false);
            road.jumpOver();
            break;
        case ESCAPE:
            cheatMode = true;
            road.immunity(cheatMode);
            break;
        case RIGHT:
            road.setSpeedTrue();
            break;
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

    public void initializingObjects(int DL, int LS) {
        road = new Road(DL, LS);
        IntegerProperty intPropLives = road.getPlayer().getPropertyLives();
        img.layoutXProperty().bindBidirectional(road.getPlayer().getCoordinate().getX());
        img.layoutYProperty().bindBidirectional(road.getPlayer().getCoordinate().getY());
        // bind the life lbl to the life in model
        lblLife.textProperty().bind(Bindings.createStringBinding(
                () -> String.valueOf(road.getPlayer().getPropertyLives().get()), road.getPlayer().getPropertyLives()));
        // bind the score made by the timer to the model
        road.getPlayer().getPropertyScores().bind(getPropertyScoreView());
        // bind the score made by the timer to gui
        lblScore.textProperty()
                .bind(Bindings.createStringBinding(() -> String.valueOf(scoreView.get()), getPropertyScoreView()));

    }

    public void loadRoadImages() {
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

    public void checkOver() {
        if (timeline.getCycleCount() == 0) {
            gameOver = true;
        }
    }

    public void showOver() throws IOException {
        if (road.getGameOver() == true) {
            timeline.stop();
            if(timeline.getStatus().equals(javafx.animation.Animation.Status.STOPPED)){
                PlayerHighScore playerHighScore = new PlayerHighScore("I crashed", road.getPlayer().getPropertyScores().get());
                highScore.addPlayer(playerHighScore);
                highScore.addToTxtFile();
            };
            Alert alert = new Alert(AlertType.INFORMATION, "GAME OVER!!! Final score: " + getScores());
            alert.show();
        }
    }

}
