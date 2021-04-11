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
    Random rand = new Random();

    public Obstacle(RoadBlock rd, int x, Lane y){
        super(x, y);
        this.object = rd;
    }

    public RoadBlock getRoadBlock(){
        return object;
    }

    public void serialize() {
        try(FileWriter fr = new FileWriter("src/data.txt")){
            fr.append("Obstacle" + "\n");
            fr.append(String.valueOf(x) +"\n");
            fr.append("END");

        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    
}
