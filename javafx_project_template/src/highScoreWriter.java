
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class HighScoreWriter {

    private HighScoreWriter() {
    };

    private static HighScoreWriter instance = new HighScoreWriter();

    public static HighScoreWriter getInstance() {
        return instance;
    }

    ArrayList<String> list = AllHighScore.getInstance().getPlayerList();

    public void addToTxtFile() throws IOException {
        File fout = new File("highscore.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).toString());
            bw.newLine();
        }
        bw.close();
    }

    public void readFromTxtFile(String filename) throws IOException{

        var reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while (line != null) {
            list.add(line);
            line = reader.readLine();
        }
        reader.close();
    }

}
