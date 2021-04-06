package model;



import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Road{
    //File to load and save from
    static final File filename = new File("/data.json");
    ArrayList<Object> saveList = new ArrayList();
    boolean gameOver;
    boolean cheatOn;
    Player player;
    int time;
    int speed;
    int distance;

    public Road(){
        // {
            //Switch for each DifficultyLevel/ LevelSequece combinations
            // switch (DifficultyLevel){
            // case 1: DifficultyLevel = DifficultyLevel.EASY;
            //     switch (LevelSequence){
            //         case 1: LevelSequence = LevelSequence.FIVE;
            //             break;
            //         case 2: LevelSequence = LevelSequence.TEN;
            //             break;
            //         case 3: LevelSequence = LevelSequence.FIFTEEN;
            //             break;
            //        }
            // case 2: DifficultyLevel = DifficultyLevel.MEDIUM;
            //     switch (LevelSequence){
            //         case 1: LevelSequence = LevelSequence.FIVE;
            //             break;
            //         case 2: LevelSequence = LevelSequence.TEN;
            //             break;
            //         case 3: LevelSequence = LevelSequence.FIFTEEN;
            //             break;
            //     }
            // case 3: DifficultyLevel= DifficultyLevel.HARD;
            //     switch (LevelSequence){
            //         case 1: LevelSequence = LevelSequence.FIVE;
            //             break;
            //         case 2: LevelSequence = LevelSequence.TEN;
            //             break;
            //         case 3: LevelSequence = LevelSequence.FIFTEEN;
            //             break;
            //     }
            // }
            // }
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

    /**
     * @param int:d
     * @param int:r
     * @return
     */
    public int calculateTime(int d, int r){
        time = d/r;
        return time;
    }

    public Road createRoad(){
        Road newRoad = new Road();
        return newRoad;
    }

    public void save(File filename) throws Exception {
       ObjectMapper mp = new ObjectMapper();
        
       for (Object item : saveList) {
           mp.writeValue(filename, item);
       }
    }
    
    public Road load(File filename) throws Exception{
        /*
        Hypothetical Methods:
        setBackground()
        addObjects()
        addLanes()

        */
        ObjectMapper mp = new ObjectMapper();
        JsonNode loadArray = mp.readTree(filename);
        for (JsonNode node : loadArray) {
            System.out.println(node);
            String type = node.path("type").asText();
            //Switch statement to deal with objects based on type
            
        }

        Road road = new Road();
        //Set road properties
        return road;



    }

    public RoadBlock getObject(int x){
        RoadBlock item = RoadBlock.CARS;
        return item;
    }
}
