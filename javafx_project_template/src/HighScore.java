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
    AllHighScore all = AllHighScore.getInstance();
    @FXML
    VBox main;

    @FXML
    public void initialize() throws IOException{
        all.load();
        ArrayList<String> list = all.getPlayerList();
        
        for(int i = 0; i < list.size(); i++){
            var lbl = new Label();
            main.getChildren().addAll(lbl);
            lbl.setText(list.get(i).toString());
        }
    }



    @FXML
    void onBackClicked(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
}
