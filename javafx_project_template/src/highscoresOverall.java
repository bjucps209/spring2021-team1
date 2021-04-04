
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class highscoresOverall {
    
    ArrayList<String> playerList = new ArrayList<String>();

    public void addPlayer(playerHighscore player){
        // String info = player.infromation();
        // playerList.add(info);
    }
    
    public void addToTxtFile(int index){
        // try {
        //     FileWriter myWriter = new FileWriter("highscore.txt");
        //     myWriter.write(playerList.get(index));
        //     myWriter.close();
        //   } catch (IOException e) {}
    }

    public void readFromTxtFile(String filename){
        //this method will read from the high scores file 
    }

    
}
