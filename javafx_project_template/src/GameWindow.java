
import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    HBox hbox;
    @FXML
    Pane paneMain;
    @FXML
    Label lblCoord;

    Timeline timeline;

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
    final Image fireImage = new Image("/images/fire.gif");

    ImageView imgPlayer = new ImageView(player);

    Stage stage;

    // MainWindow mainwindow;
    ImageView img = new ImageView(player);

    @FXML
    public void initialize(Stage stage, DifficultyLevel diff, LevelSequence seq) {
        Road road = new Road(diff.getAmtObj(), seq.getDistance());

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
        img.setFitWidth(100);
        img.relocate(50, 650);
        paneMain.getChildren().add(img);
        

        img.layoutXProperty().bind((road.getPlayer().getCoordinate().getX()));
        img.layoutYProperty().bind((road.getPlayer().getCoordinate().getY()));
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

        }

        timeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {
            road.update();
            if (road.detectCollision(road.getPlayer().getCoordinate()) == true) {

                VBox vbox = new VBox(new Label("Label"));
                Scene newScene = new Scene(vbox);
                Stage newStage = new Stage();
                newStage.setScene(newScene);

                Label newLabel = new Label("you have failed");
                vbox.getChildren().add(newLabel);

                // Platform.runLater(() -> timeline.stop());

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // for (int i = 2; i < paneMain.getChildren().size(); i++) {
        // ImageView image = (ImageView) paneMain.getChildren().get(i);
        // timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> {
        // image.setX(image.getX() - 2);
        // road.beginCollisionDetection();
        // }));
        // timeline.setCycleCount(Timeline.INDEFINITE);
        // timeline.play();

        // }

        // beginCollisionDetection();
    }

    public void keyPressed(KeyEvent event) {
        KeyCode key = event.getCode();
        switch (key) {
        case UP: // up one lane
            if(img.getY() == 0){
                img.setY(-200);
            }
            if(img.getY() == 200){
                img.setY(0);
            }
            break;
        case DOWN: // down one lane
            if (img.getY() == 0) {
                img.setY(200);
            }
            if(img.getY() == -200){
                img.setY(0);
            }

            break;
        case SPACE: // jump
            img.setX(img.getX() + 50);
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
