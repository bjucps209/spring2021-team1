package model;

import java.io.FileWriter;
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
    int id;
    private static int nextId;
    Random rand = new Random();

    public Obstacle(RoadBlock rd, int x, int y){
        super(x, y);
        this.object = rd;
        this.id = ++nextId;
    }

    public RoadBlock getRoadBlock(){
        return object;
    }
    public void placingObjectBound(){
        //go through the loop and check if there is 
    }

    public String serialize() {
        String serial = "Obstacle" + "\n" + String.valueOf(x) + "\n" + String.valueOf(y) + "\n" + "END" + "\n";
        return serial;
        }
    }

    

