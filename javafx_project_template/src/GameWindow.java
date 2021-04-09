import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GameWindow {
    @FXML Pane pane;

    @FXML Label lblCoord;

    @FXML
    void onMouseMoved(MouseEvent event) {
        lblCoord.setText(String.format("(%d, %d)", (int) event.getX(), (int) event.getY()));
    }
    
}
