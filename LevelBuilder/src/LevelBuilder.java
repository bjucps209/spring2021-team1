

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LevelBuilder {

    @FXML Slider sldLevel;
    @FXML Pane pane;
    IntegerProperty roadLength;
   
    

    final Image IMG_CONE = new Image("/images/cone.png");
    final Image IMG_POT_HOLE = new Image("/images/blackhole.gif");
    final Image IMG_HUMAN = new Image("/images/human.png");
    final Image IMG_TRUCK = new Image("/images/truck.png");
    final Image IMG_CAR = new Image("/images/RoadBlockcar.png");

    Random rand = new Random();

    void initialize(){
        sldLevel.valueProperty().addListener((o, oldVal, newVal) -> onSliderChanged(newVal.intValue()));
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
        });
        node.setOnMouseReleased(me -> node.getScene().setCursor(Cursor.HAND) );

        // Prevent mouse clicks on img from propagating to the pane and
        // resulting in creation of a new image
        node.setOnMouseClicked(me -> me.consume());
    }
    

    @FXML 
    void onPotholeClicked(ActionEvent e) {
        var img = new ImageView(IMG_POT_HOLE);
        int y = rand.nextInt(300);
        int x = rand.nextInt(300);
        img.relocate(x, y);
        img.setFitWidth(50);
        img.setFitHeight(50);
        pane.getChildren().add(img);
        makeDraggable(img);
   
    }

    @FXML 
    void onConeClicked(ActionEvent e) {
        var img = new ImageView(IMG_CONE);
        int y = rand.nextInt(300);
        int x = rand.nextInt(300);
        img.setFitWidth(50);
        img.setFitHeight(50);
        img.relocate(x, y);

        pane.getChildren().add(img);
        makeDraggable(img);
    }

    @FXML 
    void onTruckClicked(ActionEvent e) {
        var img = new ImageView(IMG_TRUCK);
        int y = rand.nextInt(300);
        int x = rand.nextInt(300);
        img.setFitWidth(50);
        img.setFitHeight(50);
        img.relocate(x, y);

        pane.getChildren().add(img);
        makeDraggable(img);
    }
    
    @FXML
    void onCarClicked(ActionEvent e) {
        var img = new ImageView(IMG_CAR);
        int y = rand.nextInt(300);
        int x = rand.nextInt(300);
        img.setFitWidth(50);
        img.setFitHeight(50);
        img.relocate(x, y);
        
        pane.getChildren().add(img);
        makeDraggable(img);
    }
    
    @FXML
    void onHumanClicked(ActionEvent e) {
        var img = new ImageView(IMG_HUMAN);
        int y = rand.nextInt(300);
        int x = rand.nextInt(300); 
        img.setFitWidth(50);
        img.setFitHeight(50);   
        img.relocate(x, y);

        
        pane.getChildren().add(img);
        makeDraggable(img);
    }

    @FXML
    void onSliderChanged(int val){
       // pane.setWidth(val * 1000);
    }


   

    private class Delta {
        public double x;
        public double y;
    }
}
