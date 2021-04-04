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
     * @param TrafficItem:object
     */
    public void addObjectsA(){
        //code
    }

    /**
     * @return none
     * @param TrafficItem:object
     */
    public void addObjectsB(){
        //code
    }

    /**
     * @return none
     * @param TrafficItem:object
     */
    public void addObjectsC(){
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

    public void load(File filename) throws Exception{
        ObjectMapper mp = new ObjectMapper();
        JsonNode loadArray = mp.readTree(filename);
        for (JsonNode node : loadArray) {
            System.out.println(node);
        }

    }
}
