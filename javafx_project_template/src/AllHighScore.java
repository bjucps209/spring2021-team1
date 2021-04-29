
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
        File fout = new File("oneScore.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < playerList.size(); i++) {
            bw.write(playerList.get(i).toString());
            bw.newLine();
        }
        bw.close();
    }

    public void addToAll() throws IOException{
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

    public void save(PlayerHighScore player) throws IOException{
        //to be placed at the end of each game 
        addPlayer(player);
        addToTxtFile();
    }

    public void load(String Filename ) throws IOException{
        addToAll();
        readFromTxtFile(Filename);
    }

    
}
