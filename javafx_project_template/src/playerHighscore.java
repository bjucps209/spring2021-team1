
public class PlayerHighScore {
    int score; 
    String name; 

    PlayerHighScore(String name, int score){
        this.name = name;
        this.score = score;
    }
    public String infromation(){
        String info = "";
        info += name +",";
        info += String.valueOf(score) +",";
        return info;
        
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }


}
