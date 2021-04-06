import org.junit.Test;

import static org.junit.Assert.*;
import model.DifficultyLevel;
import model.LevelSequence;

public class Testing{
    @Test
    public void highscoresOverallTest(){
        highscoresOverall test = new highscoresOverall();
        playerHighscore ply1 = new playerHighscore(model.DifficultyLevel.EASY, model.LevelSequence.FIVE,"William's", 800);
        test.addPlayer(ply1);
        test.addToTxtFile();
        playerHighscore ply2 = new playerHighscore(model.DifficultyLevel.EASY, model.LevelSequence.FIFTEEN,"Aya", 700);
        test.addPlayer(ply2);
        test.addToTxtFile();
        

    }

    @Test
    public void testLoad() {
        
    }
    @Test
    public void testSave() {
        
    }

}