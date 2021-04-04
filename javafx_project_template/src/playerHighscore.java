import model.LevelSequence;

public class playerHighscore {
    int score; 
    String name; 
    LevelSequence distance;
    model.DifficultyLevel difficulty; 

    playerHighscore(model.DifficultyLevel diff, model.LevelSequence seq, String name, int score){
        this.difficulty = diff;
        this.distance = seq;
        this.name = name;
        this.score = score;
    }
    public String infromation(){
         String info = "";
        // info += difficulty.toString() + ",";
        // info += distance.toString() + ",";
        // info += name +",";
        // info += String.valueOf(score) +",";
        return info;
        
    }

    public void setDifficulty(model.DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }
    public void setDistance(model.LevelSequence distance) {
        this.distance = distance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public model.DifficultyLevel getDifficulty() {
        return difficulty;
    }
    public model.LevelSequence getDistance() {
        return distance;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }


}
