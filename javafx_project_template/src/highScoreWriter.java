
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class highScoreWriter {

    ArrayList<String> list = AllHighScore.getInstance().getPlayerList();

    public void addToTxtFile() throws IOException {
        FileWriter myWriter = new FileWriter("highscore.txt");
        for (int i = 0; i < list.size();i++){
            myWriter.write(list.get(i).toString());
        }
        myWriter.close();
    }

    public void readFromTxtFile(String filename) {
        // this method will read from the high scores file
    }

}
