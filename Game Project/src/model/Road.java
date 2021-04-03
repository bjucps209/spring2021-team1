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
                }
            }
            }
    }

    public void addObjectsA(int x, int y){
        //setCell(x: int, type: Traffic)
    }

    public void addObjectsB(int x, int y){
        //setCell(x: int, type: Traffic)
    }

    public void addObjectsC(int x, int y){
        //setCell(x: int, type: Traffic)
    }
}