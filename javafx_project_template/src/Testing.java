
import java.io.IOException;

import org.junit.Test;


public class Testing{
    @Test
    public void highscoresOverallTest() throws IOException{
        
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
    public void readFromFileTest(){
        // HighScoreWriter test = new HighScoreWriter();
        // test.readFromTxtFile("highscore.txt");
        
    }

    @Test
    public void testLoad() {
        
    }
    @Test
    public void testSave() {
        
    }

}