package model;

public class Road{
    //File to load and save from
    static final String filename = "data.json";
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

    public void save() {

    }

    public void load() {

    }

    public RoadBlock getObject(int x){
        RoadBlock item = RoadBlock.CARS;
        return item;
    }
}
