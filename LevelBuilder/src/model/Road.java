package model;

import java.io.File;
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
    ArrayList<Integer> Lane = new ArrayList<>();;
    boolean gameOver;
    boolean cheatOn;
    Player player;
    int speed;
    int distance;
    Obstacle obstacle;
    ObserverGame observer;
    
    //File to load and save from
    static final File filename = new File("/data.json");
    public static ArrayList<Savable> saveList = new ArrayList<Savable>();

    // sets the time and distance to move through the pane
    public Road(){
        player = new Player(STATE.MOVING, 0, Lane.get(1));
        usingRB = new ArrayList<>();
        createLanes();
        addObjectsdefault();
        
       
    }
    
    public void addObjectsdefault(){
        for (int i = 0; i < 25; i ++){
            Random rand = new Random();
            Obstacle obstacle = new Obstacle(rb[rand.nextInt(5)], rand.nextInt(1250), Lane.get(rand.nextInt(2)));
            usingRB.add(obstacle);
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
        observer.update(usingRB);
        
    }

    public void loop(){ //Caedmon Evans helped me with this idea
        for (int i = 0; i < usingRB.size(); ++i){
            updateX(usingRB.get(i));
        }
    }

    public void updateX(Obstacle obstacles){
        obstacles.setX(obstacles.getX()-3);
 
    }

    public void createRandomObstacle(){
        Random rand = new Random();
        Obstacle obstacle = new Obstacle(rb[rand.nextInt(4)], distance, Lane.get(rand.nextInt(2)));
        usingRB.add(obstacle);
        // serialize(obstacle);
    }

    public void setObserver(ObserverGame observer) {
        this.observer = observer;
    }
    
    private static Road instance = new Road();


    public static Road getInstance() { 
        return instance;
    }

    public void createLanes(){
        int A = 500;
        int B = 300;
        int C = 100;

        Lane.add(A);
        Lane.add(B);
        Lane.add(C);
    }

    public void objectOverLap(){

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

    public int getplayerXcoord(){
        return player.getCoordinate().getX();
    }

    public Player getPlayer(){
        return player;
    }

    // public void serialize(Object obj) {
    //     saveList.add(obj);
    // } 
 

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

        public ArrayList<Integer> getLane() {
            return Lane;
        }

        public void setLane(ArrayList<Integer> lane) {
            Lane = lane;
        }
    

}
