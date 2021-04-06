
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class highscoresOverall {
    
    ArrayList<String> playerList = new ArrayList<String>();

    public void addPlayer(playerHighscore player){
        String info = player.infromation();
        playerList.add(info);
    }
    
    public void addToTxtFile(){
        try {
            FileWriter myWriter = new FileWriter("highscore.txt");
            myWriter.write();
            myWriter.close();
          } catch (IOException e) {}
        }

}
