package model;

import java.util.Random;

public class Road{

    public Road(){
        {
            //Switch for each DifficultyLevel/ LevelSequece combinations
            switch (DifficultyLevel){
            case 1: DifficultyLevel = DifficultyLevel.EASY;
                switch (LevelSequence){
                    case 1: LevelSequence = LevelSequence.FIVE;
                        break;
                    case 2: LevelSequence = LevelSequence.TEN;
                        break;
                    case 3: LevelSequence = LevelSequence.FIFTEEN;
                        break;
                   }
            case 2: DifficultyLevel = DifficultyLevel.MEDIUM;
                switch (LevelSequence){
                    case 1: LevelSequence = LevelSequence.FIVE;
                        break;
                    case 2: LevelSequence = LevelSequence.TEN;
                        break;
                    case 3: LevelSequence = LevelSequence.FIFTEEN;
                        break;
                }
            case 3: DifficultyLevel= DifficultyLevel.HARD;
                switch (LevelSequence){
                    case 1: LevelSequence = LevelSequence.FIVE;
                        break;
                    case 2: LevelSequence = LevelSequence.TEN;
                        break;
                    case 3: LevelSequence = LevelSequence.FIFTEEN;
                        break;
                }
            }
            }
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
        t = d/t;
        return t;
    }

    public Road createRoad(){
        Road newRoad = new Road();
        return newRoad;
    }
}