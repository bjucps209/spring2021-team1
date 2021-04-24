import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.DifficultyLevel;
import model.LevelSequence;
import model.*;

public class LevelChoice {
    @FXML
    RadioButton BtnEasyDiff, BtnMedDiff, BtnHardDiff;
    @FXML
    RadioButton BtnOneSeq, BtnTwoSeq, BtnThreeSeq;
    @FXML
    Button btnBackStart;
    @FXML
    ToggleGroup group;
    @FXML 
    ToggleGroup level;

    int selectedDifficultyLevelValue;
    int selectedLevelSequenceValue;
    
    public ArrayList<Obstacle> levelArray;
    

    public void setLevelArray(ArrayList<Obstacle> levelArray) {
        this.levelArray = levelArray;
    }

    @FXML
    public void initialize(Stage stage) {
        BtnEasyDiff.setSelected(true);
        BtnOneSeq.setSelected(true);

        ToggleGroup group = new ToggleGroup(); // https://stackoverflow.com/questions/53467588/how-to-implement-togglegroup-in-fxml-file-using-spring-vs-javafx
        BtnEasyDiff.setUserData("Easy");
        BtnMedDiff.setUserData("Medium");
        BtnHardDiff.setUserData("Hard");

        BtnEasyDiff.setToggleGroup(group);
        BtnMedDiff.setToggleGroup(group);
        BtnHardDiff.setToggleGroup(group);

        ToggleGroup level = new ToggleGroup();
        BtnOneSeq.setUserData("Level 1");
        BtnTwoSeq.setUserData("Level 2");
        BtnThreeSeq.setUserData("Level 3");

        BtnOneSeq.setToggleGroup(level);
        BtnTwoSeq.setToggleGroup(level);
        BtnThreeSeq.setToggleGroup(level);

        //BtnEasyDiff.setSelected(true);
        //BtnOneSeq.setSelected(true);
        levelArray = null;

    }

    @FXML
    public int getDiffButton() {

        if(BtnEasyDiff.isSelected()){
            selectedDifficultyLevelValue = DifficultyLevel.EASY.getAmtObj();
        }
        if(BtnMedDiff.isSelected()){
            selectedDifficultyLevelValue = DifficultyLevel.MEDIUM.getAmtObj();
        }
        if(BtnHardDiff.isSelected()){
            selectedDifficultyLevelValue = DifficultyLevel.HARD.getAmtObj();
        }

        return selectedDifficultyLevelValue;
    }

    @FXML
    public int getLevelButton() {
        if(BtnOneSeq.isSelected()){
            selectedLevelSequenceValue = LevelSequence.TEN.getDistance();
        }
        if(BtnTwoSeq.isSelected()){
            selectedLevelSequenceValue = LevelSequence.TWENTY.getDistance();
        }
        if(BtnThreeSeq.isSelected()){
            selectedLevelSequenceValue = LevelSequence.THIRTY.getDistance();
        }
        return selectedLevelSequenceValue;
    }

    @FXML
    public void onStartClicked(ActionEvent event) throws IOException {
        int DL = getDiffButton();
        int LS = getLevelButton();

        var gLoader = new FXMLLoader(getClass().getResource("GameWindow.fxml"));
        var gScene = new Scene(gLoader.load());
        var gStage = new Stage();
        GameWindow window = gLoader.getController();
        gStage.setScene(gScene);
        gStage.show();

        window.initialize(gStage, DL, LS, levelArray); //William's added null for levelbuilder purposes
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    
    }

    @FXML
    void onBackClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBackStart.getScene().getWindow();
        stage.close();

    }

}
