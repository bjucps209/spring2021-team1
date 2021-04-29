
import model.*;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class LevelBuilder {

    @FXML
    Pane paneRoad;

    @FXML
    VBox paneHBox;
    IntegerProperty roadLength;

    final Image IMG_CONE = new Image("/images/cone.png");
    final Image playerImage = new Image("/images/player.png");
    final Image IMG_POT_HOLE = new Image("/images/blackhole.gif");
    final Image IMG_HUMAN = new Image("/images/human.gif");
    final Image IMG_TRUCK = new Image("/images/truck.png");
    final Image IMG_CAR = new Image("/images/RoadBlockcar.png");
    final Image roadImage = new Image("/images/road.png");

    Random rand = new Random();
    Node oldNode;
    ArrayList<Obstacle> obslist = new ArrayList<Obstacle>();

    // Pane paneRoad = new Pane();
    @FXML
    void initialize(Stage stage) {

        /// Pane paneRoad = new Pane();
        // ScrollPane sp = new ScrollPane();
        // Road road = new Road(20, 30);

       /*  var imgPlayer = new ImageView(playerImage);
        imgPlayer.setFitWidth(100);
        // imgPlayer.setFitHeight(600);
        imgPlayer.relocate(50, 300);
        paneRoad.getChildren().add(imgPlayer);
 */
        var imgRoad = new ImageView(roadImage);
        imgRoad.setFitWidth(2000);
        imgRoad.setFitHeight(600);
        paneRoad.getChildren().add(imgRoad);

        // Object window = stage.getScene().getWindow();
        // sp.setContent((Node) window);

        // sp.setContent(paneRoad);
        // sp.setPannable(true);

        // paneHBox.getChildren().add(sp);

    }

    private void makeDraggable(Node node) {
        final Delta dragDelta = new Delta();

        node.setOnMouseEntered(me -> node.getScene().setCursor(Cursor.HAND));
        node.setOnMouseExited(me -> node.getScene().setCursor(Cursor.DEFAULT));
        node.setOnMousePressed(me -> {
            dragDelta.x = me.getX();
            dragDelta.y = me.getY();
            node.getScene().setCursor(Cursor.MOVE);
        });
        node.setOnMouseDragged(me -> {
            node.setLayoutX(node.getLayoutX() + me.getX() - dragDelta.x);
            node.setLayoutY(node.getLayoutY() + me.getY() - dragDelta.y);

        });
        node.setOnMouseReleased(me -> node.getScene().setCursor(Cursor.HAND));

    }

    @FXML
    void onPotholeClicked(ActionEvent e) {
        var img = new ImageView(IMG_POT_HOLE);
        int y = 400;
        int x = rand.nextInt(2000);
        img.relocate(x, y);
        // setOnLanes(img);
        img.setFitWidth(100);
        img.setPreserveRatio(true);

        img.setOnMouseClicked(c -> {
            if (oldNode != null) {
                oldNode.getStyleClass().clear();
            }
            img.getStyleClass().add("current");
            oldNode = img;
        });

        paneRoad.getChildren().add(img);
        makeDraggable(img);

    }

    @FXML
    void onConeClicked(ActionEvent e) {
        var img = new ImageView(IMG_CONE);
        int y = 300;
        int x = rand.nextInt(300);
        img.setFitWidth(55);
        img.setPreserveRatio(true);
        // img.setFitHeight(50);
        img.relocate(x, y);

        img.setOnMouseClicked(c -> {
            if (oldNode != null) {
                oldNode.getStyleClass().clear();
            }
            img.getStyleClass().add("current");
            oldNode = img;
        });

        paneRoad.getChildren().add(img);
        makeDraggable(img);

    }

    @FXML
    void onTruckClicked(ActionEvent e) {
        var img = new ImageView(IMG_TRUCK);
        int y = 100;
        int x = rand.nextInt(300);
        img.setFitWidth(150);
        img.setPreserveRatio(true);
        // img.setFitHeight(50);
        img.relocate(x, y);

        img.setOnMouseClicked(c -> {
            if (oldNode != null) {
                oldNode.getStyleClass().clear();
            }
            img.getStyleClass().add("current");
            oldNode = img;
        });

        paneRoad.getChildren().add(img);
        makeDraggable(img);

    }

    @FXML
    void onCarClicked(ActionEvent e) {
        var img = new ImageView(IMG_CAR);
        int y = 400;
        int x = rand.nextInt(2000);
        img.setFitWidth(90);
        img.setPreserveRatio(true);
        // img.setFitHeight(50);
        img.relocate(x, y);
        img.setOnMouseClicked(c -> {
            if (oldNode != null) {
                oldNode.getStyleClass().clear();
            }
            img.getStyleClass().add("current");
            oldNode = img;
        });

        paneRoad.getChildren().add(img);
        makeDraggable(img);

    }

    @FXML
    void onHumanClicked(ActionEvent e) {
        var img = new ImageView(IMG_HUMAN);
        int y = 400;
        int x = rand.nextInt(2000);
        img.setFitWidth(55);
        // img.setFitHeight(50);
        img.setPreserveRatio(true);
        img.relocate(x, y);
        // setOnLanes(img);
        img.setOnMouseClicked(c -> {
            if (oldNode != null) {
                oldNode.getStyleClass().clear();
            }
            img.getStyleClass().add("current");
            oldNode = img;
        });

        paneRoad.getChildren().add(img);
        makeDraggable(img);
    }

    @FXML
    void onDeleteClicked(ActionEvent e) {
        if(oldNode != null){
        int index = paneRoad.getChildren().indexOf(oldNode);
        paneRoad.getChildren().remove(oldNode);
        obslist.remove(index);
        oldNode = null;
        }
    }

    @FXML
    void onLeftClicked(ActionEvent e){
        for (int i = 0; i < paneRoad.getChildren().size(); i++) {
            ImageView img = (ImageView) paneRoad.getChildren().get(i);
            img.setTranslateX(img.getTranslateX() - 20);
        }
       
    }


    @FXML
    void onStartLevelClicked(ActionEvent e) throws IOException{
        for (int i = 0; i < paneRoad.getChildren().size(); i++) {
            Obstacle obs = null;
            ImageView img = (ImageView) paneRoad.getChildren().get(i);
            Image imgs = img.getImage();
            System.out.println(img.getLayoutX() + ", " + img.getLayoutY());
            int x = (int)img.getLayoutX();
            int y = (int) img.getLayoutY();
            if( imgs == IMG_CONE){
                obs = new Obstacle(RoadBlock.CONES, x, y);
            }
            else if ( imgs == IMG_CAR){
                obs = new Obstacle(RoadBlock.CARS, x, y);
            }
            else if ( imgs == IMG_HUMAN){
                obs = new Obstacle(RoadBlock.PEOPLE, x, y);
            }
            else if ( imgs == IMG_POT_HOLE){
                obs = new Obstacle(RoadBlock.POTHOLES, x, y);
            }
            else if ( imgs == IMG_TRUCK){
                obs = new Obstacle(RoadBlock.TRUCK, x, y);
            }

            if(obs != null){
                obslist.add(obs);
            }
        }


        var loader = new FXMLLoader(getClass().getResource("LevelChoice.fxml"));
        var scene = new Scene(loader.load());
        var stage = new Stage();
        LevelChoice window = loader.getController();
        // mainStage = stage;
        stage.setScene(scene);
        stage.show();
        window.initialize(stage);
        window.setLevelArray(obslist);
        Stage mStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        mStage.close();
    }

    @FXML
    void onRightClicked(ActionEvent e){
        for (int i = 0; i < paneRoad.getChildren().size(); i++) {
            ImageView img = (ImageView) paneRoad.getChildren().get(i);
            img.setTranslateX(img.getTranslateX() + 20);
        }
       
    }

    private class Delta {
        public double x;
        public double y;
    }
}


 // Check current image pasition and make sure it's on a lane and not between
    /* public void setOnLanes(ImageView img) {
        if (img.getY() > 300) {
            img.setY(500);

        }

        if (img.getY() < 300 && img.getY() > 100) {
            img.setY(300);

        }

        if (img.getY() < 100) {
            img.setY(100);

        }
    } */