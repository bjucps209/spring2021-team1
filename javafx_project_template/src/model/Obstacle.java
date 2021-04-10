package model;

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

    // public void setObserverGame(ObserverGame observer){
    //     this.observer = observer;
    // }

    /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjectsC(RoadBlock object, int x){
        //code
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
