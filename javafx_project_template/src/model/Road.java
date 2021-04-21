//-----------------------------------------------------------
//File:   Road.java
//Desc:   Program that contains methods to set road blocks 
//        and check collison 
//----------------------------------------------------------- 
package model;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;

// import com.fasterxml.jackson.core.JsonParser;
// import com.fasterxml.jackson.core.ObjectCodec;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

public class Road {
    RoadBlock[] rb = RoadBlock.values();
    ArrayList<Obstacle> usingRB;

    ArrayList<Integer> objectXs = new ArrayList<>();
    boolean gameOver;
    boolean collisionDetection;

    IntegerProperty amtObj = new SimpleIntegerProperty();
    IntegerProperty distance = new SimpleIntegerProperty();

    Player player;
    Obstacle obstacle;
    List<Integer> setXList = Arrays.asList(200, 400, 600, 800, 1000, 1200, 1400, 1600);
    List<Integer> setYList = Arrays.asList(100, 300, 500, 300, 100, 500, 300, 100);
    
    // File to load and save from
    // static final File filename = new File("/data.json");
    public ArrayList<Savable> saveList = new ArrayList<Savable>();

//=======================Constructor==========================//
    public Road() {
        gameOver = false;
        collisionDetection = true;
        usingRB = new ArrayList<>();
        createRandomObstacle();
        this.player = new Player(STATE.MOVING, 10, Lane.B.getLaneYcoord());
        saveList.add(player);
    }

    
//============================Setters/Getters===========================//

    public final void setAmtObj(int value){
        amtObj.set(value);
    }
    public IntegerProperty getPropertyAmtObj() {
        return amtObj;
    }
    public final int getAmtObj(){
        return amtObj.get();
    }

    public final void setDinstance(int value){
        distance.set(value);
    }
    public IntegerProperty getPropertyDistance() {
        return distance;
    }
    public final int getDistance(){
        return distance.get();
    }

    public ArrayList<Obstacle> getUsingRB() {
        return usingRB;
    }

    public RoadBlock getObjectType(Obstacle obst) {
        return obst.getRoadBlock();
    }

    public Player getPlayer() {
        return player;
    }

    // public void setDistanceAmtObj(int d, int obj){
    //     distance = d*10;
    //     amtObj = obj;
    // }

    public boolean getGameOver() {
        return gameOver;
    }

    public boolean isCollisionDetection() {
        return collisionDetection;
    }

    public void setCollisionDetection(boolean tf) {
        this.collisionDetection = tf;
    }
//=========================Collision Detection===================================//

    public void detectCollision() {
        if(collisionDetection == true){
        // if player image coordinate equals object object, print collided..
        // System.out.println(playerCoord.getX());
            for (Obstacle i : usingRB) {
                if (player.getCoordinate().getdoubleY() == i.getdoubleY()) {
                    if (player.getCoordinate().getdoubleX() <= i.getdoubleX() + i.getObstalceWidth()) {
                        if (player.getCoordinate().getdoubleX() + player.getCoordinate().getPlayerWidth() >= i.getdoubleX()) {
                            // System.out.println(player.getdoubleX() + ", " + i.getdoubleX());
                            gameOver = true;
                        }
                    }
                }
            }
    }   }

//=================Anonymous==============================//

public void createRandomObstacle(){
    for (int i = 0; i < 8; i ++){
        Random rand = new Random();
        //int currentX = (rand.nextInt(100 - 15 + 1) + 10)*20;
        Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], setXList.get(i), setYList.get(i));
        usingRB.add(obstacle);
        saveList.add(obstacle);
    }
}

//this is creating objects
// public void createCoursedefault(){
//     for (int i = 0; i < amtObj; i ++){

//         Random rand = new Random();
//         int currentX = (rand.nextInt(100 - 15 + 1) + 10)*20;
//         if((currentX%100) != 0 ){
//            currentX = Math.round(currentX*100)/100;
//         }
//         Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], currentX, Lane.getRandomLane().getLaneYcoord());
//         checkCollisionPics(obstacle);
//         usingRB.add(obstacle);
//         saveList.add(obstacle);
//     }
// }


public void updateXPositionOfObstableAndPlayer() {
    for (Obstacle i : usingRB) {
        i.setX(i.getdoubleX() - 2);
        //System.out.println(i.getdoubleX() +" obstacle ");
    }
    player.getCoordinate().setX(player.getCoordinate().getdoubleX() + 2);
    if(collisionDetection == true)
        detectCollision();
}

//==================Switching Lanes====================//
    public void switchUp(){
        if(getPlayer().getCoordinate().getdoubleY() == Lane.A.getLaneYcoord()){
            getPlayer().getCoordinate().setY(Lane.B.getLaneYcoord());
        }
        if(getPlayer().getCoordinate().getdoubleY() == Lane.B.getLaneYcoord()){
            getPlayer().getCoordinate().setY(Lane.C.getLaneYcoord());
        }
    }

    public void switchDown(){
        if(getPlayer().getCoordinate().getdoubleY() == Lane.B.getLaneYcoord()){
            getPlayer().getCoordinate().setY(Lane.A.getLaneYcoord());
        }
        if(getPlayer().getCoordinate().getdoubleY() == Lane.C.getLaneYcoord()){
            getPlayer().getCoordinate().setY(Lane.B.getLaneYcoord());
        }
    }
    public void jumpOver(){
        double number = getPlayer().getCoordinate().getdoubleX()+80;
        if(collisionDetection == false)
            getPlayer().getCoordinate().setX(number);
        collisionDetection = true;
    }



//================Serialization=========================//

    public void save() {
        try (FileWriter fr = new FileWriter("src/data.txt")) {
            for (Savable obj : saveList) {
                fr.append(obj.serialize());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void load() {
        // Still testing in separate project
    }
    // road.getPlayer().setY(road.getPlayer().getCoordinate().getdoubleY()
    // - 200);

}
