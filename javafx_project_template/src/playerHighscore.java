
public class playerHighscore {
    int score; 
    String name; 
    LevelSequence distance;
    model.DifficultyLevel difficulty; 

    playerHighscore(DifficultyLevel diff, LevelSequence seq, String name, int score){
        this.difficulty = diff;
        this.distance = seq;
        this.name = name;
        this.score = score;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }
    public void setDistance(LevelSequence distance) {
        this.distance = distance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }
    public LevelSequence getDistance() {
        return distance;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }


}
