
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


class AllHighScore{ 

    private AllHighScore(){};
    private static AllHighScore instance = new AllHighScore();
    ArrayList<String> playerList = new ArrayList<String>();

    public void addPlayer(PlayerHighScore player) {
        String info = player.infromation();
        playerList.add(info);
    }

    public void addToTxtFile() throws IOException {
        File fout = new File("highscore.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < playerList.size(); i++) {
            bw.write(playerList.get(i).toString());
            bw.newLine();
        }
        bw.close();
    }
    public void readFromTxtFile(String filename) throws IOException{

        var reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while (line != null) {
            playerList.add(line);
            line = reader.readLine();
        }
        reader.close();
    }

    public static AllHighScore getInstance() {
        return instance;
    }
    public ArrayList<String> getPlayerList(){
        return playerList;
    }

    public void save() throws IOException{
        addToTxtFile();
    }

    public void load() throws IOException{
        readFromTxtFile("Load.txt");
    }

    
}
