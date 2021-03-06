//-----------------------------------------------------------
//File:   Road.java
//Desc:   Program that contains methods to set road blocks 
//        and check collison 
//----------------------------------------------------------- 
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Road {
    //Values inside road blocks
    RoadBlock[] rb = RoadBlock.values();
    //List of roadblocks without player
    ArrayList<Obstacle> usingRB;
    //List of y's
    List<Integer> setYList = Arrays.asList(100, 300, 500, 300, 100, 500, 300, 100, 300, 500,100, 300, 500, 300, 100, 500, 300, 100, 300, 500,100, 300, 500, 300, 100, 500, 300, 100, 300, 500);
    //Checks if the game is over 
    BooleanProperty gameOver = new SimpleBooleanProperty();
    //Checks if collision detection is on
    BooleanProperty collisionDetection = new SimpleBooleanProperty();
    //A thread
    Thread thread;
    //Amount of roadblocks
    int amtObj;
    //Distance of the road
    int distance;
    //The player
    Player player;
    //The obstacle
    Obstacle obstacle;
    //Normal speed
    double NORMALSPEED = 2;
    //Fast speed
    double FASTSPEED = 4;
    //Check if speed is on
    boolean speed = false;
    //Check if it crashed or not
    boolean crashed = false;
    //Number of super jumps
    int numOfSuperJump = 3;


    //List of objects to save
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
        this.player = new Player(STATE.MOVING, 10,300);
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
    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }
    public int getNumOfSpeedUp(){
        return numOfSuperJump;
    }
//=========================Collision Detection===================================//
    //Detects Collision
    public void detectCollision() {
        if(getCollisionDetection() == true){
            //System.out.println("ITS WORKING");
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
    //Creates random obstacle objects
    public void createRandomObstacle() {
        int newX = 300;
        for (int i = 0; i < amtObj; i++) {
            //System.out.println(newX + "#" + i);
            Random rand = new Random();
            Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], newX, setYList.get(i));
            usingRB.add(obstacle);
            saveList.add(obstacle);
            newX += 250;
        }

        Obstacle finsihedLine = new Obstacle(rb[5], (newX + 300), 0);  
        usingRB.add(finsihedLine);
        saveList.add(finsihedLine);
        //System.out.println(usingRB.get(10).getdoubleX());
    }
    //Checks lives after collision
    public void collisionDealer(){
        if(crashed == true){
            if(player.getLives() > 1){
                player.setLives(player.getLives() -1); 
                crashed = false;
            } else if( player.getLives() == 1){
                setGameOver(true);
            }
            
        }
    }
//Updates Obstacle X Positions
    public void updateXPositionOfObstable() {
        for (Obstacle i : usingRB) {
            if (speed == false) {
                i.setX(i.getdoubleX() - NORMALSPEED);
            }
            if(speed == true){
                i.setX(i.getdoubleX() - FASTSPEED);
            }
        }
        detectCollision();
        player.setScores(player.getScores() + .09);
    }

//========================Lane Action===========================//
    //Switches lanes to the top lane
    public Thread switchUp() {
        switch ((int) getPlayer().getCoordinate().getdoubleY()) {
        case 500:
            thread = new Thread(() -> {
            getPlayer().getCoordinate().setY(300);
            //getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 30);
            });
            break;
        case 300:
            thread = new Thread(() -> {
                getPlayer().getCoordinate().setY(100);
                //getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 30);
            });
            break;
        }
        return thread;
    }
    //Switches lane to the bottom lane
    public Thread switchDown() {
        switch ((int) getPlayer().getCoordinate().getdoubleY()) {
        case 100:
            thread = new Thread(() -> {
                getPlayer().getCoordinate().setY(300);
                //getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 30);
            });
            break;
        case 300:
            thread = new Thread(() -> {
                getPlayer().getCoordinate().setY(500);
               // getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 30);
            });
            break;

        }
        return thread;
    }
    //In the air
    public void jumpOverUp(){
        if(getCollisionDetection() == false){
            getPlayer().getCoordinate().setY(getPlayer().getCoordinate().getdoubleY() - 50);
            getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 50);
        }

    }
    //Falling with gravity
    public void jumpOverdown(){
        if(getCollisionDetection() == false){
            getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 50);
            getPlayer().getCoordinate().setY(getPlayer().getCoordinate().getdoubleY() + 50);
        }

    }
    //Super jump
    public void superJumpOverUp(){
        if(getCollisionDetection() == false){
            getPlayer().getCoordinate().setY(getPlayer().getCoordinate().getdoubleY() - 50);
            getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 100);

        }

    }
    //Super jump
    public void superJumpOverdown(){
        if(getCollisionDetection() == false){
            getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX() + 100);
            getPlayer().getCoordinate().setY(getPlayer().getCoordinate().getdoubleY() + 50);
            numOfSuperJump -= 1;
        }

    }

    //Immunity
    public void immunity(boolean tf){
        if(tf == true){
            setCollisionDetection(true);
        }
    }


    // ================Serialization=========================//
    //Saves game data to data.txt
    public void save() {
        try (FileWriter fr = new FileWriter("data.txt")) {
            for (Savable obj : saveList) {
                fr.append(obj.serialize());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //Loads game data from data.txt
    public void load() {
        try(var rd = new BufferedReader(new FileReader("data.txt"))) {
            String line = rd.readLine();
            String deser = new String();
            while (line != null) {
                switch(line) {
                    case "Obstacle":
                        
                        Obstacle obst = new Obstacle(rb[0], 1, setYList.get(0));
                        deser += rd.readLine();
                        deser += "\n" + rd.readLine();
                        //System.out.println(deser);
                        //String[] inBoundsCheck = deser.split("\n");
                        //Checks if the object is still on the game screen
                        //if (Double.parseDouble(inBoundsCheck[0]) >= 0 && Double.parseDouble(inBoundsCheck[1]) >= 0) {
                          //  obst.deserialize(deser);
                       // }
                        obst.deserialize(deser);
                        deser = ""; 
                        break;

                    case "Player":
                        deser += rd.readLine();
                        deser += "\n" + rd.readLine();
                        deser += "\n" + rd.readLine();
                        deser += "\n" + rd.readLine();
                        //System.out.println(deser);
                        player.deserialize(deser);
                        deser = "";
                        break;
                        
                } 
                //System.out.println(line);
                line = rd.readLine();

            }
        }catch(Exception e) {
            System.out.print(e.getMessage());
        }
    }


    public void setUsingRB(ArrayList<Obstacle> listObstacles){

        for (int i = 1; i < saveList.size(); i++) {
           saveList.remove(i);
        }

        usingRB = listObstacles;

    }
}
