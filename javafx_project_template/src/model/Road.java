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

    Player player;
    int amtObj;
    int distance;
    Obstacle obstacle;
    List<Integer> setXList = Arrays.asList(200, 400, 600, 800, 1000, 1200, 1400, 1600);
    List<Integer> setYList = Arrays.asList(100, 300, 500, 300, 100, 500, 300, 100);
    int NORMALSPEED = 2;
    int FASTSPEED = 4;
    boolean speed = false;

    // File to load and save from
    // static final File filename = new File("/data.json");
    public ArrayList<Savable> saveList = new ArrayList<Savable>();

    // =======================Constructor==========================//
    public Road(int amtObj, int distance) {
        gameOver = false;
        usingRB = new ArrayList<>();
        createRandomObstacle();
        this.player = new Player(STATE.MOVING, 10, Lane.B.getLaneYcoord());
        saveList.add(player);
        this.amtObj = amtObj;
        this.distance = distance;
    }

    // ============================Setters/Getters===========================//
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

    public void setDistanceAmtObj(int d, int obj) {
        distance = d * 10;
        amtObj = obj;
    }

    public boolean getGameOver() {
        return gameOver;
    }
    public void setSpeedTrue(){
        speed ^= true;
        
    }
    public void setSpeedFalse(){
        speed = false;
    }

    // =========================Collision
    // Detection===================================//

    public void detectCollision() {
        // if player image coordinate equals object object, print collided..
        // System.out.println(playerCoord.getX());
        for (Obstacle i : usingRB) {
            if (player.getCoordinate().getdoubleY() == i.getdoubleY()) {
                if (player.getCoordinate().getdoubleX() <= i.getdoubleX() + i.getObstalceWidth()) {
                    if (player.getCoordinate().getdoubleX() + player.getCoordinate().getPlayerWidth() >= i
                            .getdoubleX()) {
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
            }
        }
    }

    public void checkCollisionPics(Obstacle obs) {
        Random rand = new Random();
        if (usingRB.size() != 0) {
            for (Obstacle i : usingRB) {
                if (i.getdoubleX() == obs.getdoubleX()) {
                    obs.setX(rand.nextInt((100 - 15 + 1) + 10) * 20);
                    checkCollisionPics(obs);
                } else {
                    break;
                }
            }
        }
    }

    // =================Anonymous==============================//

    public void createRandomObstacle() {
        for (int i = 0; i < 8; i++) {
            Random rand = new Random();
            // int currentX = (rand.nextInt(100 - 15 + 1) + 10)*20;
            Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], setXList.get(i), setYList.get(i));
            checkCollisionPics(obstacle);
            usingRB.add(obstacle);
            saveList.add(obstacle);
        }
    }

    // this is creating objects
    // public void createCoursedefault(){
    // for (int i = 0; i < amtObj; i ++){

    // Random rand = new Random();
    // int currentX = (rand.nextInt(100 - 15 + 1) + 10)*20;
    // if((currentX%100) != 0 ){
    // currentX = Math.round(currentX*100)/100;
    // }
    // Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], currentX,
    // Lane.getRandomLane().getLaneYcoord());
    // checkCollisionPics(obstacle);
    // usingRB.add(obstacle);
    // saveList.add(obstacle);
    // }
    // }

    public void updateXPositionOfObstableAndPlayer() {
        for (Obstacle i : usingRB) {
            if (speed == false) {
                i.setX(i.getdoubleX() - NORMALSPEED);
                // System.out.println(i.getdoubleX() +" obstacle ");
            }
            if(speed == true){
                i.setX(i.getdoubleX() - FASTSPEED);
            }

        }
        player.getCoordinate().setX(player.getCoordinate().getdoubleX() + 2);
        detectCollision();
    }

    // ==================Switching Lanes====================//
    public void switchUp() {
        switch ((int) getPlayer().getCoordinate().getdoubleY()) {
        case 500:
            getPlayer().getCoordinate().setY(Lane.B.getLaneYcoord());
            break;
        case 300:
            getPlayer().getCoordinate().setY(Lane.C.getLaneYcoord());
            break;
        }
    }

    public void switchDown() {
        switch ((int) getPlayer().getCoordinate().getdoubleY()) {
        case 100:
            getPlayer().getCoordinate().setY(Lane.B.getLaneYcoord());
            break;
        case 300:
            getPlayer().getCoordinate().setY(Lane.A.getLaneYcoord());
            break;

        }
    }
    
    

    public void jumpOver() {
        getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 80);
    }

    // ================Serialization=========================//

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
