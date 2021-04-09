import java.io.IOException;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class LevelChoice {
    @FXML RadioButton EasyBtn, MediumBtn, HardBtn;
    @FXML Slider sldLevel;
    @FXML ToggleGroup group;

    @FXML
    private void initialize() {
        ToggleGroup group = new ToggleGroup(); //https://stackoverflow.com/questions/53467588/how-to-implement-togglegroup-in-fxml-file-using-spring-vs-javafx
        EasyBtn.setToggleGroup(group);
        MediumBtn.setToggleGroup(group);
        HardBtn.setToggleGroup(group);
    }

    @FXML
    public void onStartClicked(ActionEvent event) throws IOException{
        // RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        // String toogleGroupValue = selectedRadioButton.getText();
        // int sliderValue = (int) sldLevel.getValue();

        //show the gamewindow page
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("GameWindow.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBackClicked(ActionEvent event) throws IOException{

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    
    }

}
