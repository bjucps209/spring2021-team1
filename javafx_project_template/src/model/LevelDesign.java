package model;

import java.util.ArrayList;


class LevelDesign{

    
    public int getsequenceDifficulty(LevelSequence distance){
        int km = 0;
        if (distance == LevelSequence.TEN){
            km = 10;
    }
        if (distance == LevelSequence.TWENTY){
            km = 20;  
        }
        if (distance == LevelSequence.THIRTY){
            km = 30;
        } 
        return km;
    }

   /*  public int getlevelDifficulty(DifficultyLevel difficulty){
            if(difficulty == DifficultyLevel.EASY){
                
            }
            if(difficulty == DifficultyLevel.MEDIUM){
                
            }
            if(difficulty == DifficultyLevel.HARD){
                
            } */
        
    



    public LevelSequence currentSequence(LevelSequence sequence){
        return sequence;
    }


    public void setCurrentSequence(LevelSequence sequence){


    }

/* public ArrayList<RoadBlock> buildLevel(RoadBlock roadblock){
    //return an arraylist with the user specified oblstacles
    return null;
} */

}
