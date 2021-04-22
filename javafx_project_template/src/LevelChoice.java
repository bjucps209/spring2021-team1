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

public class LevelChoice {
    @FXML
    RadioButton DiffBtn;
    @FXML
    RadioButton SeqBtn;
    @FXML 
    Button btnBackStart;
    @FXML

    ToggleGroup group;

    int difficultyLevel;
    int levelSequence;

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
    public int getDiffButton() {
        if(DiffBtn.isSelected()){
            String diffBtnText = DiffBtn.getText();

            switch (diffBtnText){
            case "Easy":
                difficultyLevel = DifficultyLevel.EASY.getAmtObj();
            case "Medium":
                difficultyLevel = DifficultyLevel.MEDIUM.getAmtObj();            
            case "Hard":
                difficultyLevel = DifficultyLevel.HARD.getAmtObj();
            }
        } else if(!DiffBtn.isSelected()){
            difficultyLevel = DifficultyLevel.EASY.getAmtObj();
        }
        return difficultyLevel;
    }

    @FXML
    public int getLevelButton() {
        if(DiffBtn.isSelected()){
            String seqBtnText = SeqBtn.getText();
            switch (seqBtnText){
            case "Level 1":
                levelSequence = LevelSequence.TEN.getDistance();
            case "Level 2":
                levelSequence = LevelSequence.TEN.getDistance();
            case "Level 3":
                levelSequence = LevelSequence.TEN.getDistance();
        }
        } else if(!DiffBtn.isSelected()){
                levelSequence = LevelSequence.TEN.getDistance();
        }
        return levelSequence;
    }

    @FXML
    public void onStartClicked(ActionEvent event) throws IOException {
        int DL = getDiffButton();
        int LS = getLevelButton();


        var gLoader = new FXMLLoader(getClass().getResource("GameWindow.fxml"));
        var gScene = new Scene(gLoader.load());
        var gStage = new Stage();
        GameWindow window = gLoader.getController();
        // mainStage = stage;
        gStage.setScene(gScene);
        gStage.show();
        window.initialize(gStage, DL, LS);
    }

    @FXML
    void onBackClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBackStart.getScene().getWindow();
        stage.close();

    }

}
