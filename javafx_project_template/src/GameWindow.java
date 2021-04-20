
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
    final Image expImage = new Image("/images/explosion.gif");

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
        img.relocate(60, 300);
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
            // road.timer();

            
        }

        

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            img.setX(img.getX() + 2);
            //checkCollision();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        //checkCollision();

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
           //checkCollision();
            break;
        case DOWN: // down one lane
            if (img.getY() == 0) {
                img.setY(200);
            }
            if(img.getY() == -200){
                img.setY(0);
               // checkCollision();
            }
        case SPACE:

        // var jumptime = new Timeline(new KeyFrame(Duration.millis(500), e -> img.setFitWidth(img.getFitWidth()+ 90)));
        // jumptime.setCycleCount(50);
        // img.setX(img.getX()+ 8);
        // img.setFitWidth(200);
        // jumptime.play();        
        // jumptime.stop();
        

        break;
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

   /*  public void checkCollision(){

        for (int i = 2; i < paneMain.getChildren().size(); i++) {

           ImageView  imgObstacle = (ImageView) paneMain.getChildren().get(i);

            if  (img.getX() == imgObstacle.getX() && img.getY() == imgObstacle.getY()){
                imgObstacle = new ImageView(expImage);
                paneMain.getChildren().add(i, imgObstacle);
               // System.out.println("Colliding");
            }
        }
    } */
}
