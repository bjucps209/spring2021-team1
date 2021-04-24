//-----------------------------------------------------------
//File:   Road.java
//Desc:   Program that contains methods to set road blocks 
//        and check collison 
//----------------------------------------------------------- 
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Road {
    RoadBlock[] rb = RoadBlock.values();
    ArrayList<Obstacle> usingRB;
    List<Integer> setYList = Arrays.asList(100, 300, 500, 300, 100, 500, 300, 100, 300, 500,100, 300, 500, 300, 100, 500, 300, 100, 300, 500,100, 300, 500, 300, 100, 500, 300, 100, 300, 500);
    ArrayList<Integer> objectXs = new ArrayList<>();
    
    BooleanProperty gameOver = new SimpleBooleanProperty();
    BooleanProperty collisionDetection = new SimpleBooleanProperty();
    IntegerProperty score = new SimpleIntegerProperty();

    Thread thread;
    int amtObj;
    int distance ;
    Player player;
    Obstacle obstacle;

    int NORMALSPEED = 2;
    int FASTSPEED = 4;
    boolean speed = false;
    boolean crashed = false;


    // File to load and save from
    // static final File filename = new File("/data.json");
    public ArrayList<Savable> saveList = new ArrayList<Savable>();

//=======================Constructor==========================//
    public Road(int DL, int SL) {
        amtObj = DL;
        distance = SL*200;
        setGameOver(false);
        this.gameOver = getPropertyGameOver();
        setCollisionDetection(true);
        this.collisionDetection = getPropertyCollisionDetection();
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
    public void setSpeedTrue(){
        speed = true;
        
    }
    public void setSpeedFalse(){
        speed = false;
    }

    public final void setGameOver(boolean value){
        gameOver.set(value);
        
    }
    public BooleanProperty getPropertyGameOver() {
        return gameOver;
    }
    public final boolean getGameOver(){
        return gameOver.get();
    }

    public final void setCollisionDetection(boolean value){
        collisionDetection.set(value);
        
    }
    public BooleanProperty getPropertyCollisionDetection() {
        return collisionDetection;
    }
    public final boolean getCollisionDetection(){
        return collisionDetection.get();
    }

    public final void setScores(int value){
        score.set(value);
    }

    public IntegerProperty getPropertyScores() {
        return score;
    }

    public final int getScores() {
        return score.get();
    }

    public boolean isCrashed() {
        return crashed;
    }


    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }
//=========================Collision Detection===================================//

    public void detectCollision() {
        if(getCollisionDetection() == true){
            System.out.println("ITS WORKING");
        // if player image coordinate equals object object, print collided..
        // System.out.println(playerCoord.getX());
            for (Obstacle i : usingRB) {
                if (player.getCoordinate().getdoubleY() == i.getdoubleY()) {
                    if (player.getCoordinate().getdoubleX() <= i.getdoubleX() + i.getObstalceWidth()) {
                        if (player.getCoordinate().getdoubleX() + player.getCoordinate().getPlayerWidth() >= i.getdoubleX()) {
                            crashed = true;
                            // // setGameOver(true);
                            // if(player.getLives() == 1){
                            //     setGameOver(true);
                            // }else if (player.getLives() > 1){

                            //     System.out.println(crashed);
                            //     // setCollisionDetection(false);
                            //     // player.setLives(player.getLives() - 1);
                        }
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

    public void collisionDealer(){
        crashed = true;
        if(crashed == true){
            if(player.getLives() > 1){
                player.setLives(player.getLives() -1); 
                crashed = false;
            } else if( player.getLives() == 1){
                setGameOver(true);
            }
            
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
        detectCollision();
        // System.out.println(player.getPropertyScores().get() + "score in model");
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
        if(getCollisionDetection() == false)
            // getPlayer().getCoordinate().setY(getPlayer().getCoordinate().getdoubleY()-50);
            getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX()+80);
            setCollisionDetection(true);
    }

    public void immunity(boolean tf){
        if(tf = true){
            setCollisionDetection(true);;
        }
    }

    public void superJump() {
    }


    public void blowUp() {
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


    public void setUsingRB(ArrayList<Obstacle> listObstacles){

        for (int i = 1; i < saveList.size(); i++) {
           saveList.remove(i);
        }

        usingRB = listObstacles;

    }


}
