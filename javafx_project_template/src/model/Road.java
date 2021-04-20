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

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

// import com.fasterxml.jackson.core.JsonParser;
// import com.fasterxml.jackson.core.ObjectCodec;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

public class Road {
    RoadBlock[] rb = RoadBlock.values();
    ArrayList<Obstacle> usingRB;
    ArrayList<Integer> objectXs = new ArrayList<>();
    boolean gameOver;

    Player player;
    int amtObj;
    int distance;
    Obstacle obstacle;
    List<Integer> setXList = Arrays.asList(200, 400, 600, 800, 1000, 1200, 1400, 1600);
    List<Integer> setYList = Arrays.asList(100, 300, 500, 300, 100, 500, 300, 100);

    // File to load and save from
    // static final File filename = new File("/data.json");
    public ArrayList<Savable> saveList = new ArrayList<Savable>();

//=======================Constructor==========================//
    public Road(int amtObj, int distance) {
        gameOver = false;
        usingRB = new ArrayList<>();
        createRandomObstacle();
        player = new Player(STATE.MOVING, 0, Lane.B.getLaneYcoord());
        saveList.add(player);
        this.amtObj = amtObj;
        this.distance = distance;
    }
    
//============================Setters/Getters===========================//
    public int getSpeed() {
        return amtObj;
    }

    public int getDistance() {
        return distance;
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

    public void setDistanceAmtObj(int d, int obj){
        distance = d*10;
        amtObj = obj;
    }

    public boolean isGameOver() {
        return gameOver;
    }

//=========================Collision Detection===================================//

    public void detectCollision() {
        // if player image coordinate equals object object, print collided..
        // System.out.println(playerCoord.getX());
        Coordinate player = getPlayer().getCoordinate();
        for (Obstacle i : usingRB) {
            if (player.getdoubleY() == i.getdoubleY()) {
                if (player.getdoubleX() <= i.getdoubleX() + i.getObstalceWidth()) {
                    if (player.getdoubleX() + player.getPlayerWidth() >= i.getdoubleX()) {
                        // System.out.println(player.getdoubleX() + ", " + i.getdoubleX());
                        gameOver = true;
                    }
                }
            }
        }
    }

    public void collision(Player player) {
        Rectangle2D playerRec = player.getBounds();

        for (Obstacle obstacle : usingRB) {

            Rectangle2D r2 = obstacle.getBounds();
            if (playerRec.intersects(r2)) {
                System.out.println("game over");
            }
        }
    }

    public void checkCollisionPics(Obstacle obs){
        Random rand = new Random();
        if(usingRB.size() != 0){
            for(Obstacle i: usingRB){
                if(i.getdoubleX() == obs.getdoubleX()){
                    obs.setX(rand.nextInt((100 - 15 + 1) + 10)*20);
                    checkCollisionPics(obs);
                }else{
                    break;
                }
            }
        }
    }

//=================Anonymous==============================//

public void createRandomObstacle(){
    for (int i = 0; i < 8; i ++){
        Random rand = new Random();
        //int currentX = (rand.nextInt(100 - 15 + 1) + 10)*20;
        Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], setXList.get(i), setYList.get(i));
        checkCollisionPics(obstacle);
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


public void update() {
    for (Obstacle i : usingRB) {
        i.setX(i.getdoubleX() - 2);
    }
    getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 2);
    detectCollision();
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
    // road.getPlayer().getCoordinate().setY(road.getPlayer().getCoordinate().getdoubleY()
    // - 200);

}
