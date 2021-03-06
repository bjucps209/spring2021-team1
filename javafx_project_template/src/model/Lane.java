//-----------------------------------------------------------
//File:   Lane.java
//Desc:   Enum that contains methods and a switch 
//----------------------------------------------------------- 
package model;

import java.util.Random;

public enum Lane { //http://tutorials.jenkov.com/java/enums.html#:~:text=A%20Java%20Enum%20is%20a,were%20added%20in%20Java%205
    A (500), //bottom lane
    B (300), //middle lane
    C (100); //top lane

    private final int laneYcoord;

    private Lane(int laneYcoord){
        this.laneYcoord = laneYcoord;
    }

    public int getLaneYcoord() {
        return laneYcoord;
    }

    public static Lane getRandomLane(){
        Random rand = new Random();

        int num = rand.nextInt(3);

        switch(num){
            case 0:
                return A;
            case 1:
                return B;
            case 2:
                return C;
            default:
                return B;
        }
    }

}
