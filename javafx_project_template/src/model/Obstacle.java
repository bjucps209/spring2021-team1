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

        /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjectsA(RoadBlock object, int x){
        //code
    }

    /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjectsB(RoadBlock object, int x){
        //code
    }

    /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjectsC(RoadBlock object, int x){
        //code
    }
}
