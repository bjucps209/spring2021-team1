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
    boolean cheatOn;
    Player player;
    int amtObj;
    int distance;
    Obstacle obstacle;
    List<Integer> setXList = Arrays.asList(200, 400, 600, 800, 1000, 1200, 1400, 1600);
    List<Integer> setYList = Arrays.asList(100, 300, 500, 300, 100, 500, 300, 100);

    // File to load and save from
    // static final File filename = new File("/data.json");
    public ArrayList<Savable> saveList = new ArrayList<Savable>();

    // sets the time and distance to move through the pane
    public Road(int amtObj, int distance) {
        usingRB = new ArrayList<>();
        createRandomObstacle();
        player = new Player(STATE.MOVING, 0, Lane.B.getLaneYcoord());
        saveList.add(player);
        this.amtObj = amtObj;
        this.distance = distance;
    }
    
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

    public Obstacle createObject() {
        // Random rand = new Random();
        // int currentX = rand.nextInt(100)*20;
        // if()
        // Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], currentX,
        // Lane.getRandomLane().getLaneYcoord());
        // if(collision(obstacle) == true){
        // createObject();
        // }
        return obstacle;

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


    public void setDistanceAmtObj(int d, int obj){
        distance = d*10;
        amtObj = obj;
    }

    /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjects(int distance) {
        for (int i = 0; i < distance * 2; i++) {
            createRandomObstacle();
        }
    }

    public void loop() { // Caedmon Evans helped me with this idea
        for (int i = 0; i < usingRB.size(); ++i) {
            updateX(usingRB.get(i));
        }
    }

    public void updateX(Obstacle obstacles) {
        obstacles.setX(obstacles.getdoubleX() - 3);

    }


    // public static Road getInstance() {
    // return instance;
    // }

    public Boolean checkLeft() {
        boolean statement = true;
        if (player.getCoordinate().getdoubleY() == 100) {
            statement = false;
        }
        return statement;
    }

    public Boolean checkRight() {
        boolean statement = true;
        if (player.getCoordinate().getdoubleY() == 500) {
            statement = false;
        }
        return statement;

    }

    public void update() {
        for (Obstacle i : usingRB) {
            i.setX(i.getdoubleX() - 2);
        }
        getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 2);
    }

    // Getters for variables
    public int getSpeed() {
        return amtObj;
    }

    public int getDistance() {
        return distance;
    }

    public ArrayList<Obstacle> getUsingRB() {
        return usingRB;
    }

    /**
     * @param none
     * @return RoadBlock
     */
    public RoadBlock getObjectType(Obstacle obst) {
        return obst.getRoadBlock();
    }

    public Player getPlayer() {
        return player;
    }

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

    public boolean detectCollision(Coordinate coord) {
        // if player image coordinate equals object object, print collided..
        // System.out.println(playerCoord.getX());
        for (Obstacle i : usingRB) {

            if (coord.getdoubleY() == i.getdoubleY()) {
                if (coord.getdoubleX() >= i.getdoubleX() + i.getObstalceWidth()) {
                    if (coord.getdoubleX() + coord.getPlayerWidth() >= i.getdoubleX()) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public void collision() {
        Rectangle2D playerRec = player.getBounds();

        for (Obstacle obstacle : usingRB) {

            Rectangle2D r2 = obstacle.getBounds();
            if (playerRec.intersects(r2)) {
                gameOver = true;
                System.out.println("game over");
            }
        }
    }

}
