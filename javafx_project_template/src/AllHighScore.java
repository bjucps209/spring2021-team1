
//-----------------------------------------------------------
//File:   AllHighScores.java
//Desc:   This program contains the singleton class to keep 
//          all scores that created when playing. 
//----------------------------------------------------------- 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class AllHighScore {
    // Singleton class that can be acessed in the view for the high score screen
    private AllHighScore() {
    };

    private static AllHighScore instance = new AllHighScore();
    // a string array to keep track of all players created
    ArrayList<String> playerList = new ArrayList<String>();

    // AddPlayer will take an instance of player and turn it into a string to be
    // stored in a strinf array.
    public void addPlayer(PlayerHighScore player) {
        String info = player.infromation();
        playerList.add(info);
    }

    // addToTxtFiles adds one players score into a file for later use
    public void addToTxtFile() throws IOException {
        File fout = new File("oneScore.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < playerList.size(); i++) {
            bw.write(playerList.get(i).toString());
            bw.newLine();
        }
        bw.close();
    }

    // allToAll adds the text from oneScore to an over File called All.txt.
    // This was made because in gameWindow the scores were saved in timer within
    // a while loop so it caused bugs. This was created to help with the loop
    // writing.
    public void addToAll() throws IOException {
        var reader = new BufferedReader(new FileReader("oneScore.txt"));
        String line = reader.readLine();
        File fout = new File("All.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        if (line != null) {
            bw.write(line);
            bw.newLine();
        }
        reader.close();
        bw.close();

    }

    // ReadFromTxtFile will take a file name and read the text and add a to the
    // player list
    public void readFromTxtFile(String filename) throws IOException {

        var reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while (line != null) {
            playerList.add(line);
            line = reader.readLine();
        }
        reader.close();
    }

    // ------------Getters----------------//
    public static AllHighScore getInstance() {
        return instance;
    }

    public ArrayList<String> getPlayerList() {
        return playerList;
    }

    // Save will save an instance of a player to the playerlist and add it to a txt
    // file
    public void save(PlayerHighScore player) throws IOException {
        // to be placed at the end of each game
        addPlayer(player);
        addToTxtFile();
    }

    // load will load all the players from a file to the list of players
    public void load(String Filename) throws IOException {
        addToAll();
        readFromTxtFile(Filename);
    }

}
