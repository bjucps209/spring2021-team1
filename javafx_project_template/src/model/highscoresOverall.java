package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class highscoresOverall {
    
    ArrayList<playerHighscore> playerList = new ArrayList<playerHighscore>();

    public void addPlayer(playerHighscore player){
        playerList.add(player);
    }
    
    public void addToTxtFile(){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(playerList.toString());
            myWriter.close();
          } catch (IOException e) {}
        }

}
