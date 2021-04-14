package model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;


public class Road{
    RoadBlock[] rb = RoadBlock.values();
    ArrayList<Obstacle> usingRB;
    ArrayList<Integer> Lane = new ArrayList<>();
    ArrayList<Integer> objectXs = new ArrayList<>();
    boolean gameOver;
    boolean cheatOn;
    Player player;
    int speed;
    int distance;
    Obstacle obstacle;

    

    public ArrayList<Savable> saveList = new ArrayList<Savable>();

    // sets the time and distance to move through the pane
    public Road(){
        usingRB = new ArrayList<>();
        Lane = new ArrayList<>();
        createLanes();
        addObjectsdefault();
        player = new Player(STATE.MOVING, 0, Lane.get(1));
        saveList.add(player);
        
       
    }
    
    // private static Road instance = new Road();
    
    //this is creating objects
    public void addObjectsdefault(){
        for (int i = 0; i < 25; i ++){
            Random rand = new Random();
            int newX = rand.nextInt(100)*20;
            newX = checkObjectLocation(newX);
            Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], newX, Lane.get(rand.nextInt(3)));
            usingRB.add(obstacle);
            saveList.add(obstacle);
        }
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

    public void timer(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(30), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                loop();
            }
        }));
        
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
        Obstacle obstacle = new Obstacle(rb[rand.nextInt(4)], distance, Lane.get(rand.nextInt(2)));
        usingRB.add(obstacle);
        saveList.add(obstacle);
        
    }

    // public static Road getInstance() { 
    //     return instance;
    // }

    public void createLanes(){
        int A = 500;
        int B = 300;
        int C = 100;

        Lane.add(A);
        Lane.add(B);
        Lane.add(C);
    }

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

    public ArrayList<Integer> getLane() {
        return Lane;
    }

    public void setLane(ArrayList<Integer> lane) {
        Lane = lane;
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

    public int checkObjectLocation(int currentX){
        Random rand = new Random();
        int newX =  rand.nextInt(100)*20;
        for(int i: objectXs){
            if(currentX >= i + 100 && currentX <= i){
                checkObjectLocation(newX);
            }
            else {
                newX = currentX;
            }
        }
        return newX;
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
