//-----------------------------------------------------------
//File:   Player.java
//Desc:   Program that contains methods to set player and its
//----------------------------------------------------------- 
package model;

import javafx.geometry.Rectangle2D;

public class Player implements Savable{
    //how the player begins (in the middle lane moving forward)
    int speed = 0;
    int lives = 3;
    int score = 0;
    Coordinate coord;
    STATE player = STATE.MOVING;
    final int playerWidth = 100;
    final int playerHeight = 50;
    

    public Player(STATE Player, int x, int y){
        coord = new Coordinate(x, y); 
        this.player = Player;
        
    }
    
    /**
     * @return none 
     * @param none
     * make the view go faster meaning adding more in x over a faster period of times
     */

    /**
     * @return none
     * @param State:state
     * changing lanes to the left: if its already left by gettingcurrentstate then dont move the y; if the player is on
     * the right or the middle lane add y
     */
    public void leftLane(){
        if(coord.getdoubleY() == 300){
            coord.setY(500);
        } else if (coord.getdoubleY() == 100){
            coord.setY(300);
        } else if (coord.getdoubleY() == 500){
            coord.setY(500);
        }
    }

    /**
     * @return none
     * @param State:state
     * changing lanes to the right: if its already right by gettingcurrentstate then dont move the y; if the player is on
     * the left or the middle lane add y
     */
    public void rightLane(){
        // break;
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
}
