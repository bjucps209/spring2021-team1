import java.io.IOException;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.DifficultyLevel;
import model.LevelSequence;
import model.Road;

public class LevelChoice {
    @FXML
    RadioButton DiffBtn;
    @FXML
    RadioButton SeqBtn;
    @FXML 
    Button btnBackStart;
    @FXML

    Road road = new Road();
    ToggleGroup group;
    GameWindow gameWindow = new GameWindow();

    IntegerProperty difficultyLevel = new SimpleIntegerProperty();
    IntegerProperty levelSequence = new SimpleIntegerProperty();

    @FXML
    public void initialize(Stage stage) {
        ToggleGroup group = new ToggleGroup(); // https://stackoverflow.com/questions/53467588/how-to-implement-togglegroup-in-fxml-file-using-spring-vs-javafx
        DiffBtn.setToggleGroup(group);
        DiffBtn.setToggleGroup(group);
        DiffBtn.setToggleGroup(group);
        ToggleGroup level = new ToggleGroup();
        SeqBtn.setToggleGroup(level);
        SeqBtn.setToggleGroup(level);
        SeqBtn.setToggleGroup(level);

    }

    @FXML
    public void getDiffButton() {
        road.getPropertyAmtObj().bind(difficultyLevel);
        if(DiffBtn.isSelected()){
            String diffBtnText = DiffBtn.getText();

            switch (diffBtnText){
            case "Easy":
                setDifficultyLevel(DifficultyLevel.EASY.getAmtObj());
            case "Medium":
                setDifficultyLevel(DifficultyLevel.MEDIUM.getAmtObj());
            case "Hard":
                setDifficultyLevel(DifficultyLevel.HARD.getAmtObj());
            }
        } else if(!DiffBtn.isSelected()){
            setDifficultyLevel(DifficultyLevel.EASY.getAmtObj());
        }
    }

    @FXML
    public void getLevelButton() {
        road.getPropertyDistance().bind(levelSequence);
        if(DiffBtn.isSelected()){
            String seqBtnText = SeqBtn.getText();
            switch (seqBtnText){
            case "Level 1":
                setLevelSequence(LevelSequence.TEN.getDistance());
            case "Level 2":
                setLevelSequence(LevelSequence.TWENTY.getDistance());
            case "Level 3":
                setLevelSequence(LevelSequence.THIRTY.getDistance());
        }
        } else if(!DiffBtn.isSelected()){
            setLevelSequence(LevelSequence.TEN.getDistance());
        }
    }

    @FXML
    public void onStartClicked(ActionEvent event) throws IOException {
        getDiffButton();
        getLevelButton();

        var gLoader = new FXMLLoader(getClass().getResource("GameWindow.fxml"));
        var gScene = new Scene(gLoader.load());
        var gStage = new Stage();
        GameWindow window = gLoader.getController();
        // mainStage = stage;
        gStage.setScene(gScene);
        gStage.show();
        window.initialize(gStage);
        System.out.println(getDifficultyLevel()+ ", " + getLevelSequence());
    }

    @FXML
    void onBackClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBackStart.getScene().getWindow();
        stage.close();

    }

//================Getters/Setters===========================//

    public final void setDifficultyLevel(int value){
        difficultyLevel.set(value);
    }
    public IntegerProperty getPropertyDifficultyLevel() {
        return difficultyLevel;
    }
    public final int getDifficultyLevel(){
        return difficultyLevel.get();
    }
    public final void setLevelSequence(int value){
        levelSequence.set(value);
    }
    public IntegerProperty getPropertyLevelSequence() {
        return levelSequence;
    }
    public final int getLevelSequence(){
        return levelSequence.get();
    }

}
