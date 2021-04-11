
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Obstacle;
import model.Road;
import model.STATE;

public class GameWindow extends Application {

    @FXML
    HBox hbox;
    @FXML
    Pane paneMain;
    @FXML
    Label lblCoord;

    Obstacle obstacle;
    ObjectProperty<STATE> input;
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

<<<<<<< HEAD
=======
<<<<<<< HEAD
    double xImg = 0;
    double yImg = 0;
=======
<<<<<<< HEAD
    ImageView imgPlayer = new ImageView(player);
    public void initialize(){
        
        imgPlayer.setPreserveRatio(true);
        imgPlayer.setFitWidth(100);
        imgPlayer.relocate(50 , 300);
        paneMain.getChildren().add(imgPlayer);

        ImageView obstacleImageView;
=======
>>>>>>> 880029ca50d222c86522d4c8d2db3a5e39a2da4a

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

<<<<<<< HEAD
        cImage.setFocusTraversable(true);
        primaryStage.setTitle("Car"); 
        primaryStage.setScene(scene); 
        primaryStage.show();
>>>>>>> ef347c4096197475a954e9662c221f63c0571476


        Road road = Road.getInstance();
        ArrayList<Obstacle> usingRB = road.getUsingRB();

        ImageView obstacleImageView;
=======
    @FXML
    public void initialize(){
        Road road = new Road();

        var img = new ImageView(player);
        img.setPreserveRatio(true);
        img.setFitWidth(100);
        img.relocate(50 , 300);
        paneMain.getChildren().add(img);
<<<<<<< HEAD
=======
>>>>>>> f8455741f12d5c3f1881e99717d7d2eacc0d766b
        
        Road road = new Road();
>>>>>>> 880029ca50d222c86522d4c8d2db3a5e39a2da4a
>>>>>>> ef347c4096197475a954e9662c221f63c0571476

        Random rand = new Random();

<<<<<<< HEAD
        for (int i = 0; i < usingRB.size(); i++) {
            RoadBlock type = road.getObjectType(usingRB.get(i));
            int x = usingRB.get(i).getX();
            int y = rand.nextInt(500);

            if (type == RoadBlock.PEOPLE) {
                obstacleImageView = new ImageView(humanImage);
                
=======
        for(int i = 0; i < road.getUsingRB().size(); i++){
            RoadBlock type = road.getObjectType(road.getUsingRB().get(i));
            int x = road.getUsingRB().get(i).getX();
            int y = road.getLane().get(rand.nextInt(2));



            if(type == RoadBlock.PEOPLE){
<<<<<<< HEAD
=======
<<<<<<< HEAD
                obstacleImageView = new ImageView(humanImage);
               // img.setPreserveRatio(true);
>>>>>>> 880029ca50d222c86522d4c8d2db3a5e39a2da4a
                obstacleImageView.setFitWidth(50);
                obstacleImageView.setFitHeight(50);
                obstacleImageView.relocate(x, rand.nextInt(500));
                paneMain.getChildren().add(obstacleImageView);
<<<<<<< HEAD
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
=======
=======
>>>>>>> ef347c4096197475a954e9662c221f63c0571476
                setImage(humanImage, x, y);
            }else if (type == RoadBlock.POTHOLES){
                setImage(potholeImage, x, y);
            } else if (type == RoadBlock.TRUCK){
                setImage(truckImage, x, y);
            } else if (type == RoadBlock.CONES){
                setImage(coneImage, x, y);
            } else if (type == RoadBlock.CARS){
                setImage(carImage, x, y);
>>>>>>> 880029ca50d222c86522d4c8d2db3a5e39a2da4a
            }
        }
<<<<<<< HEAD
        road.timer();
=======
        // road.timer();
    }

    public void update(ArrayList<Obstacle> list) {
<<<<<<< HEAD
        for (Obstacle i : list) {

=======
<<<<<<< HEAD
        // TODO Auto-generated method stub
=======
        for (int i=0; i < imageViews.size(); i ++){
            imageViews.get(i).setX(list.get(i).getX());
>>>>>>> 880029ca50d222c86522d4c8d2db3a5e39a2da4a
        }
>>>>>>> f8455741f12d5c3f1881e99717d7d2eacc0d766b

<<<<<<< HEAD
        // for loop through the arraylist
        // set the image of the obstacle object to the certain x by doing
        // obstacle.getX()
        // after creating a method of separating the lanes by abc, set the y of the same
        // image by obstacle.getY();
        // CHeck for obstacle object type
=======
>>>>>>> 880029ca50d222c86522d4c8d2db3a5e39a2da4a
>>>>>>> ef347c4096197475a954e9662c221f63c0571476
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
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
=======
     public void KeyEvent(KeyEvent event){
        System.out.print("blah");
        if(event.getCode() == KeyCode.SPACE){
            input.set(State.JUMP);
           // imgPlayer.relocate(, );
            System.out.print("blah");
        } else if (event.getCode() == KeyCode.UP){
            input.set(State.LEFT);
            imgPlayer.relocate(100, 600);
            System.out.print("blah");
        } else if (event.getCode() == KeyCode.DOWN){
            input.set(State.RIGHT);
            System.out.print("blah");
        } else if (event.getCode() == KeyCode.RIGHT){
            input.set(State.SPEEDUP);
        } 
    
=======
>>>>>>> ef347c4096197475a954e9662c221f63c0571476
    @FXML
    public void KeyEventJump(KeyEvent event){
        if(event.getCode() == KeyCode.SPACE){
            road.getPlayer().jumpUp();
        }
        // switch(event.getCode()){

        //     case KeyCode.SPACE
        // }

        // if(event.getCode() == KeyCode.SPACE){
            
        // } else if (event.getCode() == KeyCode.UP){
        //     input.set(State.LEFT);
        // } else if (event.getCode() == KeyCode.DOWN){
        //     input.set(State.RIGHT);
        // } else if (event.getCode() == KeyCode.RIGHT){
        //     input.set(State.SPEEDUP);
        // }
    }
<<<<<<< HEAD
=======
>>>>>>> f8455741f12d5c3f1881e99717d7d2eacc0d766b
>>>>>>> 880029ca50d222c86522d4c8d2db3a5e39a2da4a
>>>>>>> ef347c4096197475a954e9662c221f63c0571476

    @FXML
    public void KeyEventLeft(KeyEvent event){
        if(event.getCode() == KeyCode.UP){
            road.getPlayer().jumpUp();
        }
    }
    @FXML
    public void KeyEventRight(KeyEvent event){
        if(event.getCode() == KeyCode.DOWN){
            road.getPlayer().rightLane();
        } 
    }

    @FXML
    public void setImage(Image imgs, int x, int y){
        obstacleImageView = new ImageView(imgs);
        obstacleImageView.setFitWidth(50);
        obstacleImageView.setFitHeight(50);
        obstacleImageView.relocate(x, y);
        paneMain.getChildren().add(obstacleImageView);
        imageViews.add(obstacleImageView);
        obstacleImageView.layoutXProperty().bind(Bindings.createIntegerBinding(()-> x));
        obstacleImageView.layoutYProperty().bind(Bindings.createIntegerBinding(()-> y));
        }

    }
