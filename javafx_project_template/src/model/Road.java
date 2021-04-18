//-----------------------------------------------------------
//File:   Road.java
//Desc:   Program that contains methods to set road blocks 
//        and check collison 
//----------------------------------------------------------- 
package model;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

// import com.fasterxml.jackson.core.JsonParser;
// import com.fasterxml.jackson.core.ObjectCodec;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;


public class Road{
    RoadBlock[] rb = RoadBlock.values();
    ArrayList<Obstacle> usingRB;
    ArrayList<Integer> objectXs = new ArrayList<>();
    boolean gameOver;
    boolean cheatOn;
    Player player;
    int speed;
    int distance;
    Obstacle obstacle;

    
    //File to load and save from
    //static final File filename = new File("/data.json");
    public ArrayList<Savable> saveList = new ArrayList<Savable>();

    // sets the time and distance to move through the pane
    public Road(){
        usingRB = new ArrayList<>();
        createCoursedefault();
        player = new Player(STATE.MOVING, 0, Lane.B.getLaneYcoord());
        saveList.add(player);
        
       
    }
    
    // private static Road instance = new Road();
    
    //this is creating objects
    public void createCoursedefault(){
        for (int i = 0; i < 25; i ++){
            Random rand = new Random();
            int currentX = (rand.nextInt(100 - 15 + 1) + 10)*20;

            Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], currentX, Lane.getRandomLane().getLaneYcoord());
            if(usingRB.size() != 0){
                if(collision(obstacle) == true){
                    obstacle.setX(obstacle.getdoubleX() + 100);
                }
            }
            usingRB.add(obstacle);
            saveList.add(obstacle);
        }
    }

    public Obstacle createObject(){
        // Random rand = new Random();
        // int currentX = rand.nextInt(100)*20;
        // if()
        // Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], currentX, Lane.getRandomLane().getLaneYcoord());
        // if(collision(obstacle) == true){
        //     createObject();  
        // }
        return obstacle;

    }


    public void setDistanceSpeed(int d, int r){
        distance = d*10;
        speed = r;
    }

    /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjects(int distance){
        for (int i = 0; i<distance*2; i++){
            createRandomObstacle();
        }
    }

    public void loop(){ //Caedmon Evans helped me with this idea
        for (int i = 0; i < usingRB.size(); ++i){
            updateX(usingRB.get(i));
        }
    }

    public void updateX(Obstacle obstacles){
        obstacles.setX(obstacles.getdoubleX()-3);
 
    }

    public void createRandomObstacle(){
        Random rand = new Random();
        Obstacle obstacle = new Obstacle(rb[rand.nextInt(4)], distance, Lane.getRandomLane().getLaneYcoord());
        usingRB.add(obstacle);
        saveList.add(obstacle);
        
    }

    // public static Road getInstance() { 
    //     return instance;
    // }

    public Boolean checkLeft(){
        boolean statement = true;
        if(player.getCoordinate().getdoubleY()== 100){
            statement = false;
        }
        return statement;
    }

    public Boolean checkRight(){
        boolean statement = true;
        if(player.getCoordinate().getdoubleY()== 500){
            statement = false;
        }
        return statement;

    }

    public void update(){
        for(Obstacle i: usingRB){
            i.setX(i.getdoubleX()-2);
        }
        getPlayer().getCoordinate().setX(getPlayer().getCoordinate().getdoubleX()+2);
    }

    
    //Getters for variables
    public int getSpeed() {
        return speed;
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
    public RoadBlock getObjectType(Obstacle obst){
        return obst.getRoadBlock();
    }

    public Player getPlayer(){
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
        //Still testing in separate project
    }
// road.getPlayer().getCoordinate().setY(road.getPlayer().getCoordinate().getdoubleY() - 200);


    public boolean collision(Coordinate coord){
        //if player image coordinate equals object object, print collided..
        // System.out.println(playerCoord.getX());
        for(Obstacle i: usingRB){
            if(coord.getdoubleY() == i.getdoubleY()){
                if(coord.getdoubleX() <= i.getdoubleX() + i.getObstalceWidth()){
                    if(coord.getdoubleX() + coord.getPlayerWidth() <= i.getdoubleX()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
 

        public void organizeVariable(){
            DifficultyLevel[] difficultylevel = DifficultyLevel.values();
            LevelSequence[] levelSequence = LevelSequence.values();
            for (DifficultyLevel DL : difficultylevel){
            {
                // Switch for each DifficultyLevel/ LevelSequece combinations
                switch (DL){
                    case EASY:
                        for (LevelSequence LS : levelSequence){
                            switch (LS){
                                case TEN:
                                    setDistanceSpeed(10, 60);
                                    addObjects(distance);
                                case TWENTY:
                                    setDistanceSpeed(20, 60);
                                    addObjects(distance);
                                case THIRTY:
                                    setDistanceSpeed(30, 60);
                                    addObjects(distance);
                                    
                            }}
                    case MEDIUM:
                        for (LevelSequence LS : levelSequence){
                            switch (LS){
                                case TEN:
                                    setDistanceSpeed(10, 70);
                                    addObjects(distance);
                                case TWENTY:
                                    setDistanceSpeed(20, 70);
                                    addObjects(distance);
                                case THIRTY:
                                    setDistanceSpeed(30, 70);
                                    addObjects(distance);
    
                            }
                        }
                    case HARD:
                        for (LevelSequence LS : levelSequence){
                            switch (LS){
                                case TEN:
                                    setDistanceSpeed(10, 80);
                                    addObjects(distance);
                                case TWENTY:
                                    setDistanceSpeed(20, 80);
                                    addObjects(distance);
                                case THIRTY:
                                    setDistanceSpeed(30, 80);
                                    addObjects(distance);
                            }
                        }
                    }   
            }
            }        
        }

    

}
