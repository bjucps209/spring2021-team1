//-----------------------------------------------------------
//File:   Obstable.java
//Desc:   Program that contains methods create an instance of 
    //an obstable that will later be put on the road
//----------------------------------------------------------- 
package model;

import java.util.Random;

import javafx.geometry.Rectangle2D;


public class Obstacle extends Coordinate implements Savable {
        
    // when is obstacle used?
        /**
         * its used when there is roadblock created randomly.=
         */

    RoadBlock object;
    int id;
    boolean crashed;

    private static int nextId;
    int obstalceWidth;
    int obstalceHight;
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

    public String serialize() {
        String serial = "Obstacle" + "\n" + String.valueOf(getdoubleX()) + "\n" + String.valueOf(getdoubleY())+ "\n";
        return serial;
    }

    public void deserialize(String toDeserialize) {
        String[] toParse = toDeserialize.split(",");
        setX(Double.parseDouble(toParse[0]));
        setY(Double.parseDouble(toParse[1]));


    }

    public int getObstalceWidth() {
        return obstalceWidth;
    }

    public void setObstableHight(int newHight){
        this.obstalceHight = newHight;
    }
    public int getId() {
        return id;
    }
    
}

    

