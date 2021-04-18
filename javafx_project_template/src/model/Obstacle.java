//-----------------------------------------------------------
//File:   Obstable.java
//Desc:   Program that contains methods create an instance of 
    //an obstable that will later be put on the road
//----------------------------------------------------------- 
package model;

import java.util.Random;

import javafx.geometry.Rectangle2D;


public class Obstacle extends Coordinate implements Savable {
        

    Coordinate coord;
    // when is obstacle used?
        /**
         * its used when there is roadblock created randomly.=
         */

    RoadBlock object;
    int id;
    private static int nextId;
    final int obstalceWidth;
    final int obstalceHight;
    Random rand = new Random();

    public Obstacle(RoadBlock rd, int x, int y){
        super(x, y);
        this.object = rd;
        this.id = ++nextId;
        obstalceWidth = 50;
        obstalceHight = 50;
    }

    public RoadBlock getRoadBlock(){
        return object;
    }
    public void placingObjectBound(){
        //go through the loop and check if there is 
    }

    public String serialize() {
        String serial = "Obstacle" + "\n" + String.valueOf(coord.getdoubleX()) + "\n" + String.valueOf(coord.getdoubleX()) + "\n" + "END" + "\n";
        return serial;
    }

    public int getObstalceWidth() {
        return obstalceWidth;
    }

    public int getId() {
        return id;
    }
    public Rectangle2D getBounds() {
        return new Rectangle2D(coord.getdoubleX(), coord.getdoubleY(), obstalceWidth, obstalceHight);
    }
}

    

