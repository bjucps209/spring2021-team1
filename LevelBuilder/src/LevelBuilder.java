

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LevelBuilder {

    @FXML Slider sldLevel;
   @FXML Pane paneRoad;
    @FXML HBox paneHBox;
    IntegerProperty roadLength;
   
    

    final Image IMG_CONE = new Image("/images/cone.png");
    final Image playerImage = new Image("/images/player.png");
    final Image IMG_POT_HOLE = new Image("/images/blackhole.gif");
    final Image IMG_HUMAN = new Image("/images/human.png");
    final Image IMG_TRUCK = new Image("/images/truck.png");
    final Image IMG_CAR = new Image("/images/RoadBlockcar.png");
    final Image roadImage = new Image("/images/road.png");

    Random rand = new Random();
    //Pane paneRoad = new Pane();

    void initialize(Scene scene){
        sldLevel.valueProperty().addListener((o, oldVal, newVal) -> onSliderChanged(newVal.intValue()));
       /// Pane paneRoad = new Pane();
       // ScrollPane sp = new ScrollPane();

     /*   var imgPlayer = new ImageView(playerImage);
       imgPlayer.setFitWidth(100);
      // imgPlayer.setFitHeight(600);
       imgPlayer.relocate(x, y);
       paneRoad.getChildren().add(imgPlayer); */
       
        var imgRoad = new ImageView(roadImage);
        imgRoad.setFitWidth(2000);
        imgRoad.setFitHeight(600);
        paneRoad.getChildren().add(imgRoad);


        
        
        //sp.setContent(paneRoad);
       // sp.setPannable(true);

        //paneHBox.getChildren().add(sp);
        
    }

    private void makeDraggable(Node node) {
        final Delta dragDelta = new Delta();

        node.setOnMouseEntered(me -> node.getScene().setCursor(Cursor.HAND) );
        node.setOnMouseExited(me -> node.getScene().setCursor(Cursor.DEFAULT) );
        node.setOnMousePressed(me -> {
            dragDelta.x = me.getX();
            dragDelta.y = me.getY();
            node.getScene().setCursor(Cursor.MOVE);
        });
        node.setOnMouseDragged(me -> {
            node.setLayoutX(node.getLayoutX() + me.getX() - dragDelta.x);
            node.setLayoutY(node.getLayoutY() + me.getY() - dragDelta.y);
          //setOnLanes((ImageView) node);
        });
        node.setOnMouseReleased(me -> node.getScene().setCursor(Cursor.HAND) );

    }
    

    @FXML 
    void onPotholeClicked(ActionEvent e) {
        var img = new ImageView(IMG_POT_HOLE);
        int y = 500;
        int x = rand.nextInt(2000);
        img.relocate(x, y);
       // setOnLanes(img);
        img.setFitWidth(50);
        img.setFitHeight(50);
        paneRoad.getChildren().add(img);
        makeDraggable(img);
    
   
    }

    @FXML 
    void onConeClicked(ActionEvent e) {
        var img = new ImageView(IMG_CONE);
        int y = 300;
        int x = rand.nextInt(300);
        img.setFitWidth(50);
        img.setFitHeight(50);
        img.relocate(x, y);
       // setOnLanes(img);
        paneRoad.getChildren().add(img);
        makeDraggable(img);
        
    }

    @FXML 
    void onTruckClicked(ActionEvent e) {
        var img = new ImageView(IMG_TRUCK);
        int y = 100;
        int x = rand.nextInt(300);
        img.setFitWidth(50);
        img.setFitHeight(50);
        img.relocate(x, y);
       // setOnLanes(img);
        paneRoad.getChildren().add(img);
        makeDraggable(img);
        
    }
    
    @FXML
    void onCarClicked(ActionEvent e) {
        var img = new ImageView(IMG_CAR);
        int y = 500;
        int x = rand.nextInt(2000);
        img.setFitWidth(50);
        img.setFitHeight(50);
        img.relocate(x, y);
       // setOnLanes(img);
        paneRoad.getChildren().add(img);
        makeDraggable(img);
    
    }
    
    @FXML
    void onHumanClicked(ActionEvent e) {
        var img = new ImageView(IMG_HUMAN);
        int y = 300;
        int x = rand.nextInt(2000); 
        img.setFitWidth(50);
        img.setFitHeight(50);   
        img.relocate(x, y);
        //setOnLanes(img);
        
        paneRoad.getChildren().add(img);
        makeDraggable(img);
    }

    @FXML
    void onSliderChanged(int val){
        Pane newPane = new Pane();
        newPane.setMaxWidth(val *(1000));
        paneHBox.getChildren().add(newPane);

    }

    //Check current image pasition and make sure it's on a lane and not  between
     public void setOnLanes(ImageView img){
        if (img.getY() > 300){
            img.setY(500);
        
        }

        if (img.getY() < 300 && img.getY() > 100){
            img.setY(300);
            
        }

        if (img.getY() < 100){
            img.setY(100);

        }
    } 

    private class Delta {
        public double x;
        public double y;
    }
}
