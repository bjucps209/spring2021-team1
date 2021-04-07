package model;

import java.util.Random;

public class Obstacle {
    // when is obstacle used?
        /**
         * its used when there is roadblock created randomly.=
         */

    RoadBlock object;
    Random rand = new Random();

    public Obstacle(RoadBlock rd){
        Coordinate coord = new Coordinate(rand.nextInt(50), rand.nextInt(50));
        int x = coord.getX();
        int y = coord.getY();
        this.object = rd;
    }
}
