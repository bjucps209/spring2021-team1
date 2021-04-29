//-----------------------------------------------------------
//File:   HighScore.java
//Desc:   This program contains the fxml controler for 
//          the highscores fxml file
//----------------------------------------------------------- 
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HighScore {
    //instance of allHighScores
    AllHighScore all = AllHighScore.getInstance();
    @FXML
    VBox main;
    @FXML
    VBox listVbox;

    //adds all the players already loaded it to the All.txt file and adds labels for each one
    @FXML
    public void initialize() throws IOException {
        all.load("All.txt");
        ArrayList<String> list = all.getPlayerList();

        for (int i = 0; i < list.size(); i++) {
            var lbl = new Label();
            listVbox.getChildren().addAll(lbl);
            lbl.setText(list.get(i).toString());
        }
        list.clear();
    }

    //Allows the user to return to the previous screen
    @FXML
    void onBackClicked(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

}
