import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.DifficultyLevel;
import model.LevelSequence;

public class LevelChoice {
    @FXML
    RadioButton EasyBtn, MediumBtn, HardBtn;
    @FXML
    RadioButton oneBtn, twoBtn, threeBtn;
    @FXML 
    Button btnBackStart;
    @FXML
    ToggleGroup group;
    GameWindow gameWindow = new GameWindow();
    DifficultyLevel diffLevel;
    LevelSequence levelSeq;

    @FXML
    public void initialize(Stage stage) {
        ToggleGroup group = new ToggleGroup(); // https://stackoverflow.com/questions/53467588/how-to-implement-togglegroup-in-fxml-file-using-spring-vs-javafx
        EasyBtn.setToggleGroup(group);
        MediumBtn.setToggleGroup(group);
        HardBtn.setToggleGroup(group);
        ToggleGroup level = new ToggleGroup();
        oneBtn.setToggleGroup(level);
        twoBtn.setToggleGroup(level);
        threeBtn.setToggleGroup(level);
    }

    public DifficultyLevel getDiffButton() {
        if (EasyBtn.isSelected()) {
            diffLevel = DifficultyLevel.EASY;
        }
        if (MediumBtn.isSelected()) {
            diffLevel = DifficultyLevel.MEDIUM;
        }
        if (MediumBtn.isSelected()) {
            diffLevel = DifficultyLevel.HARD;
        }
        return diffLevel;
    }

    public LevelSequence getLevelButton() {
        if (oneBtn.isSelected()) {
            levelSeq = LevelSequence.TEN;
        }
        if (twoBtn.isSelected()) {
            levelSeq = LevelSequence.TWENTY;
        }
        if (threeBtn.isSelected()) {
            levelSeq = LevelSequence.THIRTY;
        }
        return levelSeq;
    }

    @FXML
    public void onStartClicked(ActionEvent event) throws IOException {

        DifficultyLevel difficultyLevel = getDiffButton();
        LevelSequence levelSequence = getLevelButton();

        var loader = new FXMLLoader(getClass().getResource("GameWindow.fxml"));
        var scene = new Scene(loader.load());
        var stage = new Stage();
        GameWindow window = loader.getController();
        // mainStage = stage;
        stage.setScene(scene);
        stage.show();
        window.initialize(stage, difficultyLevel, levelSequence);
    }

    @FXML
    void onBackClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBackStart.getScene().getWindow();
        stage.close();

    }

}
