//-----------------------------------------------------------
//File:   Player.java
//Desc:   Program that contains methods to set player and its
//----------------------------------------------------------- 
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;

public class Player implements Savable{
    //how the player begins (in the middle lane moving forward)
    IntegerProperty lives = new SimpleIntegerProperty(); //bind life with label -- Aya
    IntegerProperty score = new SimpleIntegerProperty(); //bind score with label  -- Ortiz
    Coordinate coord;
    STATE player = STATE.MOVING;
    final int playerWidth = 100;
    final int playerHeight = 50;
    

    public Player(STATE Player, int x, int y){
        coord = new Coordinate(x, y); 
        setLives(3);
        setScores(2);
        this.lives = getPropertyLives();
        
        this.score = getPropertyScores();
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

    public final void setLives(int value){
        lives.set(value);
    }
    public IntegerProperty getPropertyLives() {
        return lives;
    }
    public final int getLives(){
        return lives.get();
    }

    public final void setScores(int value){
        score.set(value);
    }
    public IntegerProperty getPropertyScores() {
        return score;
    }
    public final int getScores(){
        return score.get();
    }
}
