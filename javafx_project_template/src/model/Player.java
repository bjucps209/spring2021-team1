//-----------------------------------------------------------
//File:   Player.java
//Desc:   Program that contains methods to set player and its
//----------------------------------------------------------- 
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Player implements Savable{
    //how the player begins (in the middle lane moving forward)
    IntegerProperty lives = new SimpleIntegerProperty(); //bind life with label -- Aya
    DoubleProperty score = new SimpleDoubleProperty(); //bind score with label  -- Ortiz
    //Instantiates coordinate
    Coordinate coord;
    //Sets player state
    STATE player = STATE.MOVING;
    //The players width
    final int playerWidth = 100;

    
//============================Constructor===========================//
    public Player(STATE Player, int x, int y){
        coord = new Coordinate(x, y); 
        setLives(3);
        setScores(2);
        this.lives = getPropertyLives();
        
        this.score = getPropertyScores();
        this.player = Player;
        
    }


    //Writes player data to data.txt
    public String serialize() {
        double x = coord.getdoubleX();
        double y = coord.getdoubleY();
        String serial = "Player" + "\n" + String.valueOf(x) + "\n" + String.valueOf(y) + "\n" + String.valueOf(getLives()) + "\n" + String.valueOf(getScores()) + "\n" + "END";
        return serial;
    }
    //Deserializes the serialized string
    public void deserialize(String toDeserialize) {
        String[] toParse = toDeserialize.split("\n");
        coord.setX(Double.parseDouble(toParse[0]));
        coord.setY(Double.parseDouble(toParse[1]));
        setLives(Integer.parseInt(toParse[2]));
        setScores(Double.parseDouble(toParse[3]));
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

    public final void setScores(double value){
        score.set(value);
    }
    public DoubleProperty getPropertyScores() {
        return score;
    }
    public final double getScores(){
        return score.get();
    }

    public Coordinate getCoordinate(){
        return coord;
    }
}
