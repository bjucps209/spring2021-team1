package model;

import java.util.Random;

public class Obstacle {
    Coordinate coord;
    // when is obstacle used?
        /**
         * its used when there is roadblock created randomly.=
         */

    RoadBlock object;
    Random rand = new Random();

    public Obstacle(RoadBlock rd, int x){
        //100 for height of the screen
        coord = new Coordinate(rand.nextInt(x), rand.nextInt(100));
        this.object = rd;
    }
}
