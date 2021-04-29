//-----------------------------------------------------------
//File:   Obstable.java
//Desc:   Program that contains methods create an instance of 
    //an obstable that will later be put on the road
//----------------------------------------------------------- 
package model;

import java.util.Random;



public class Obstacle extends Coordinate implements Savable {
        
    // when is obstacle used?
        /**
         * its used when there is roadblock created randomly.=
         */
    //Enum of the roadblock variety 
    RoadBlock object;
    //Obstacle's id
    int id;
    //Calculates the Id
    private static int nextId;
    //Checks if you have crashed into this obstacle
    boolean crashed;

    //Obstacle Height
    int obstalceWidth;
    //A random random
    Random rand = new Random();
  //=======================Constructor==========================//
    public Obstacle(RoadBlock rd, int x, int y){
        super(x, y);
        this.object = rd;
        this.id = ++nextId;
        obstalceWidth = 50;
        

    }
   
    //Writes Obstacle data to data.txt
    public String serialize() {
        String serial = "Obstacle" + "\n" + String.valueOf(getdoubleX()) + "\n" + String.valueOf(getdoubleX()) + "\n" + "END" + "\n";
        return serial;
    }
    //Converts the serialization string to usable code
    public void deserialize(String toDeserialize) {
        String[] toParse = toDeserialize.split("\n");
        setX(Double.parseDouble(toParse[0]));
        setY(Double.parseDouble(toParse[1]));


    }
//============================Setters/Getters===========================//
    public RoadBlock getRoadBlock(){
        return object;
}
    public int getObstalceWidth() {
        return obstalceWidth;
    }

    public int getId() {
        return id;
    }
    
}

    

