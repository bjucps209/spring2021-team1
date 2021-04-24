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
public class Road {
    RoadBlock[] rb = RoadBlock.values();
    ArrayList<Obstacle> usingRB;
    Thread thread;

    ArrayList<Integer> objectXs = new ArrayList<>();
    boolean gameOver;
    boolean collisionDetection;

    int amtObj;
    int distance ;

    Player player;
    Obstacle obstacle;
    List<Integer> setYList = Arrays.asList(100, 300, 500, 300, 100, 500, 300, 100, 300, 500,100, 300, 500, 300, 100, 500, 300, 100, 300, 500,100, 300, 500, 300, 100, 500, 300, 100, 300, 500);
    int NORMALSPEED = 2;
    int FASTSPEED = 4;
    boolean speed = false;

    // File to load and save from
    // static final File filename = new File("/data.json");
    public ArrayList<Savable> saveList = new ArrayList<Savable>();

//=======================Constructor==========================//
    public Road(int DL, int SL) {
        amtObj = DL;
        distance = SL*200;
        gameOver = false;
        collisionDetection = true;
        usingRB = new ArrayList<>();
        createRandomObstacle();
        this.player = new Player(STATE.MOVING, 10, Lane.B.getLaneYcoord());
        saveList.add(player);
    }

    
//============================Setters/Getters===========================//

    public ArrayList<Obstacle> getUsingRB() {
        return usingRB;
    }

    public RoadBlock getObjectType(Obstacle obst) {
        return obst.getRoadBlock();
    }

    public Player getPlayer() {
        return player;
    }

    public boolean getGameOver() {
        return gameOver;
    }
    public void setSpeedTrue(){
        speed = true;
        
    }
    public void setSpeedFalse(){
        speed = false;
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
        }   
    }

    public void objectOverLap(Obstacle obs) { //For object overlap
        // if player image coordinate equals object object, print collided..
        // System.out.println(playerCoord.getX());
        for (Obstacle i : usingRB) {
            if (obs.getdoubleY() == i.getdoubleY()) {
                if (player.getCoordinate().getdoubleX() <= i.getdoubleX() + i.getObstalceWidth()) {
                    if (player.getCoordinate().getdoubleX() + player.getCoordinate().getPlayerWidth() >= i.getdoubleX()) {
                        // System.out.println(player.getdoubleX() + ", " + i.getdoubleX());
                        gameOver = true;
                    }
                }
            }
        } 
    }
//=========================Anonymous==============================//

    public void createRandomObstacle() {
        int newX = 300;
        for (int i = 0; i < amtObj; i++) {
            System.out.println(newX + "#" + i);
            Random rand = new Random();
            Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], newX, setYList.get(i));
            usingRB.add(obstacle);
            saveList.add(obstacle);
            newX += 250;
        }
    }

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
        //player.getCoordinate().setX(player.getCoordinate().getdoubleX() + 2);
        // if()
        detectCollision();
    }

//========================Lane Action===========================//
    public Thread switchUp() {
        switch ((int) getPlayer().getCoordinate().getdoubleY()) {
        case 500:
            thread = new Thread(() -> {
            getPlayer().getCoordinate().setY(Lane.B.getLaneYcoord());
            getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 30);
        });
            break;
        case 300:
            thread = new Thread(() -> {
                getPlayer().getCoordinate().setY(Lane.C.getLaneYcoord());
                getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 30);
            });
            break;
        }
        return thread;
    }

    public Thread switchDown() {
        switch ((int) getPlayer().getCoordinate().getdoubleY()) {
        case 100:
            thread = new Thread(() -> {
                getPlayer().getCoordinate().setY(Lane.B.getLaneYcoord());
                getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 30);
            });
            break;
        case 300:
            thread = new Thread(() -> {
                getPlayer().getCoordinate().setY(Lane.A.getLaneYcoord());
                getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 30);
            });
            break;

        }
        return thread;
    }
    public void jumpOver(){
        if(collisionDetection == false)
            // getPlayer().getCoordinate().setY(getPlayer().getCoordinate().getdoubleY()-50);
            getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX()+80);
    }

    public void immunity(boolean tf){
        if(tf = true){
            collisionDetection = true;
        }
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
