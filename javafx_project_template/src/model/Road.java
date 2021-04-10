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
    //File to load and save from
    static final File filename = new File("/data.json");
    ArrayList<Object> saveList = new ArrayList<Object>();
    RoadBlock[] rb = RoadBlock.values();
    ArrayList<Obstacle> usingRB;
    Lane[] lane = Lane.values();
    boolean gameOver;
    boolean cheatOn;
    Player player;
    int speed;
    int distance;
    Obstacle obstacle;

    // sets the time and distance to move through the pane
    public Road(){
       Player player = new Player(State.MOVING, 0, Lane.B);
       
    }
    

    // /**
    //  * @param int:d
    //  * @param int:r
    //  * @return
    //  */
    // public int calculateTime(int d, int r){
    //     time = d/r;
    //     int seconds = time*3600;
    //     return seconds;
    // }

    public void setDistanceSpeed(int d, int r){
        distance = d*10;
        speed = r;
    }

    public Road createRoad(){
        //for x amount of distance (this.getDistance())
        
        Road newRoad = new Road();
        return newRoad;
    }

    public void setLanes(){

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

        /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjects(int distance){
        for (int i = 0; i<distance*2; i++){
            createRandomObstacle();
        }
    }


    // public void setObserverGame(ObserverGame observer){
    //     this.observer = observer;
    // }

    public void save(File filename) throws Exception {
    //    ObjectMapper mp = new ObjectMapper();
        
    //    for (Object item : saveList) {
    //        mp.writeValue(filename, item);
    //    }
    }
    
    public Road load(File filename) throws Exception{
        /*
        Hypothetical Methods:
        setBackground()
        addObjects()
        addLanes()

        */
        // ObjectMapper mp = new ObjectMapper();
        // JsonNode loadArray = mp.readTree(filename);
        // for (JsonNode node : loadArray) {
        //     System.out.println(node);
        //     String type = node.path("type").asText();
        //     //Switch statement to deal with objects based on type
            
        // }

        Road road = new Road();
        //Set road properties
        return road;



    }

    public RoadBlock getObject(int x){
        RoadBlock item = RoadBlock.CARS;
        return item;
    }

    public void timer(ArrayList<Obstacle> list){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(30), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                loop();
            }
        }));
        
    }

    public void createRandomObstacle(){
        Random rand = new Random();
        Obstacle obstacle = new Obstacle(rb[rand.nextInt(3)], distance, lane[rand.nextInt(2)]);
        usingRB.add(obstacle);
    }

    /**
     * @param none
     * @return Obstacle
     */
    

    public void loop(){
        for (int i = 0; i < usingRB.size(); ++i){
            obstacle.updateX();
        }
    }

    public int getSpeed() {
        return speed;
    }

    public int getDistance() {
        return distance;
    }



}
