//-----------------------------------------------------------
//File:   PlayerHighScore.java
//Desc:   This program contains the logic to turn a player 
//          infomation to strings for high score
//----------------------------------------------------------- 
public class PlayerHighScore {
    double score; 
    String name; 

    //-----Constructor------//
    PlayerHighScore(String name, double score){
        this.name = name;
        this.score = score;
    }
    //turns the player instance varaible into string that will be added to a file
    public String infromation(){
        String info = "";
        info += name +",";
        info += String.valueOf(score);
        return info;
    }

    //-----------SETTERS----------------//
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    //-----------GETTERS---------------//
    public String getName() {
        return name;
    }
    public double getScore() {
        return score;
    }


}
