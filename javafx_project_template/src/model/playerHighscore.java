package model;

public class playerHighscore {
    int score; 
    String name; 
    LevelSequence distance;
    DifficultyLevel difficulty; 

    playerHighscore(DifficultyLevel diff, LevelSequence seq, String name, int score){
        this.difficulty = diff;
        this.distance = seq;
        this.name = name;
        this.score = score;
    }
    

}
