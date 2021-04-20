//-----------------------------------------------------------
//File:   Player.java
//Desc:   Program that contains methods to set player and its
//----------------------------------------------------------- 
package model;

import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;

public class Player extends Coordinate implements Savable{
    //how the player begins (in the middle lane moving forward)
    int speed = 0;
    int lives = 3;
    int score = 0;
    STATE player = STATE.MOVING;
    final int playerWidth = 100;
    final int playerHeight = 50;
    

    public Player(STATE Player, int x, int y){
        super(x, y);
        this.player = Player;

    }
    

    /**
     * @return none
     * @param int:x
     * @param int:y
     */
    public void jumpUp(){
        //getplayers x coordinate and add 50
        setX(getdoubleX() + 50);
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
        if(getdoubleY() == 300){
            setY(500);
        } else if (getdoubleY() == 100){
            setY(300);
        } else if (getdoubleY() == 500){
            setY(500);
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


    /**
     * @return Lane
     * @param none
     * get the y, if its 0, the current state is right lane, if its a 1 its the middle lane, and if its the 2 its the left lane
     */
    public void getCurrentState(){
        // break;
    }

    public String serialize() {
        double x = getdoubleX();
        double y = getdoubleY();
        String serial = "Player" + "\n" + String.valueOf(x) + "\n" + String.valueOf(y) + "\n" + "END";
        //State will be added when getState() is complete
        return serial;
    }

    public void deserialize() {
        
    }
    public Rectangle2D getBounds() {
        return new Rectangle2D(getdoubleX(), getdoubleY(), playerWidth, playerHeight);
    }
}
