
import javafx.scene.control.Label;
import model.*;

public class GameOver {

    Label lblNameScore, lblScore;

    GameWindow gameWindow = new GameWindow();
    Road road = gameWindow.getRoad();

    public void initialzie(){
        lblScore.textProperty().bind(road.getPlayer().getPropertyScores().asString());

    }
}
