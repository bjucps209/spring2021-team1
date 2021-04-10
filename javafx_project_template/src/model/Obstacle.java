package model;

import java.util.ArrayList;
import java.util.Random;


public class Obstacle extends Coordinate {
        

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

    public void updateX(){
       coord.setX(coord.getX()-3);
       

    }

    // public static Obstacle getInstance(){
    //     return this;
    // }

    // @Override
    // public void update(int x) {
    //     this.setX(x);
        
    // }
}
