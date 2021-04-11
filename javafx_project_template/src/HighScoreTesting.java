
import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

public class HighScoreTesting {
    @Test
    public void highscoresOverallTest() throws IOException {

        PlayerHighScore ply1 = new PlayerHighScore("Jackie", 900);
        PlayerHighScore ply2 = new PlayerHighScore("Aya", 1000);
        PlayerHighScore ply3 = new PlayerHighScore("Brigs", 700);

        AllHighScore all = AllHighScore.getInstance();
        all.addPlayer(ply1);
        all.addPlayer(ply2);
        all.addPlayer(ply3);
        HighScoreWriter writer = HighScoreWriter.getInstance();
        writer.addToTxtFile();

        PlayerHighScore ply4 = new PlayerHighScore("William's", 0);
        all.addPlayer(ply4);
        writer.addToTxtFile();

    }

    @Test
    public void readFromFileTest() throws IOException {
        HighScoreWriter reader = HighScoreWriter.getInstance();
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("Jackie,300");
        testList.add("Aya,100");
        testList.add("Brigs,7000");
        testList.add("William's,877");

        reader.readFromTxtFile("highScoreReader.txt");

        ArrayList<String> list = AllHighScore.getInstance().getPlayerList();

        assertArrayEquals(testList.toArray(), list.toArray());

    }

    @Test
    public void testLoad() {

    }

    @Test
    public void testSave() {

    }

}
