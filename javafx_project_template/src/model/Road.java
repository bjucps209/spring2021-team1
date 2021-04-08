package model;



import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// import com.fasterxml.jackson.core.JsonParser;
// import com.fasterxml.jackson.core.ObjectCodec;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;


public class Road{
    //File to load and save from
    static final File filename = new File("/data.json");
    ArrayList<Object> saveList = new ArrayList();
    RoadBlock[] rb = RoadBlock.values();
    boolean gameOver;
    boolean cheatOn;
    Player player;
    int time;
    int speed;
    int distance;

    // sets the time and distance to move through the pane
    public Road(){
        
    }
    
    /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjectsA(RoadBlock object, int x){
        //code
    }

    /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjectsB(RoadBlock object, int x){
        //code
    }

    /**
     * @return none
     * @param RoadBlock:object
     */
    public void addObjectsC(RoadBlock object, int x){
        //code
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

    public void setTimeDistanceSpeed(int d, int r){
        time = (d/r)*3600;
        distance = d;
        speed = r;
    }

    public Road createRoad(){
        //for x amount of distance (this.getDistance())
        
        Road newRoad = new Road();
        return newRoad;
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
                                distance = 10;
                                setTimeDistanceSpeed(10, 60);
                            case TWENTY:
                                setTimeDistanceSpeed(20, 60);
                            case THIRDY:
                                setTimeDistanceSpeed(30, 60);
                        }}
                case MEDIUM:
                    for (LevelSequence LS : levelSequence){
                        switch (LS){
                            case TEN:
                                setTimeDistanceSpeed(10, 70);
                            case TWENTY:
                                setTimeDistanceSpeed(20, 70);
                            case THIRDY:
                                setTimeDistanceSpeed(30, 70);
                        }
                    }
                case HARD:
                    for (LevelSequence LS : levelSequence){
                        switch (LS){
                            case TEN:
                                setTimeDistanceSpeed(10, 80);
                            case TWENTY:
                                setTimeDistanceSpeed(20, 80);
                            case THIRDY:
                                setTimeDistanceSpeed(30, 80);
                        }
                    }
                }   
        }
        }        
    }

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

    /**
     * @param none
     * @return Obstacle
     */
    public Obstacle createRandomObstacle(){
        Random rand = new Random();
        Obstacle obstacle = new Obstacle(rb[rand.nextInt(3)], distance);
        return obstacle;
    }

    public int getTime() {
        return time;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDistance() {
        return distance;
    }

}
