//-----------------------------------------------------------
//File:   HighScoreTesting.java
//Desc:   This program contains the unit test for high scores logic 
//----------------------------------------------------------- 
import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

public class HighScoreTesting {

    AllHighScore all = AllHighScore.getInstance();
//test if the logic adds to the txt file, 
//i don't know to use to asset for comparing text files so i manually checked if the file was loaded
    @Test
    public void highscoresOverallTest() throws IOException {

        PlayerHighScore ply1 = new PlayerHighScore("Jackie", 900);
        PlayerHighScore ply2 = new PlayerHighScore("Aya", 1000);
        PlayerHighScore ply3 = new PlayerHighScore("Brigs", 700);
        all.addPlayer(ply1);
        all.addPlayer(ply2);
        all.addPlayer(ply3);
        all.addToTxtFile();

        // PlayerHighScore ply4 = new PlayerHighScore("William's", 0);
        // all.addPlayer(ply4);
        // all.addToTxtFile();

    }

    //test if the highscore reader works 
    @Test
    public void readFromFileTest() throws IOException {

        ArrayList<String> testList = new ArrayList<String>();
        testList.add("Jackie,300");
        testList.add("Aya,100");
        testList.add("Brigs,7000");
        testList.add("William's,877");

        all.readFromTxtFile("highScoreReader.txt");

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
