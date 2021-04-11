package model;

import java.util.ArrayList;
import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;


public class Obstacle extends Coordinate implements Savable {
        

    Coordinate coord;
    // when is obstacle used?
        /**
         * its used when there is roadblock created randomly.=
         */

    RoadBlock object;
    Random rand = new Random();

    public Obstacle(RoadBlock rd, int x, Lane y){
        super(x, y);
        this.object = rd;
    }

    public RoadBlock getRoadBlock(){
        return object;
    }

    
}
