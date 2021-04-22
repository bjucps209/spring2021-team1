//-----------------------------------------------------------
//File:   Player.java
//Desc:   Program that contains methods to set player and its
//----------------------------------------------------------- 
package model;

import javafx.geometry.Rectangle2D;

public class Player implements Savable{
    //how the player begins (in the middle lane moving forward)
    int lives; //bind life with label -- Aya
    int score; //bind score with label  -- Ortiz
    Coordinate coord;
    STATE player = STATE.MOVING;
    final int playerWidth = 100;
    final int playerHeight = 50;
    

    public Player(STATE Player, int x, int y){
        coord = new Coordinate(x, y); 
        lives = 3;
        score = 0;
        this.player = Player;
        
    }

    public Coordinate getCoordinate(){
        return coord;
    }

    public String serialize() {
        double x = coord.getdoubleX();
        double y = coord.getdoubleY();
        String serial = "Player" + "\n" + String.valueOf(x) + "\n" + String.valueOf(y) + "\n" + "END";
        //State will be added when getState() is complete
        return serial;
    }

    public void deserialize() {
        
    }
    public Rectangle2D getBounds() {
        return new Rectangle2D(coord.getdoubleX(), coord.getdoubleY(), playerWidth, playerHeight);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
