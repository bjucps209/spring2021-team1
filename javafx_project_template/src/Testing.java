import org.junit.Test;

import static org.junit.Assert.*;
import model.DifficultyLevel;
import model.LevelSequence;

public class Testing{
    @Test
    public void highscoresOverallTest(){
        highscoresOverall test = new highscoresOverall();
        playerHighscore ply1 = new playerHighscore(model.DifficultyLevel.EASY, model.LevelSequence.FIVE,"joe", 700);
        test.addPlayer(ply1);
        test.addToTxtFile();

    }

}