//-----------------------------------------------------------
//File:   LevelDesign.java
//Desc:   Program that contains methods to Get set  the current level diffculty and set 
//----------------------------------------------------------- 
package model;

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

    public LevelSequence currentSequence(LevelSequence sequence){
        return sequence;
    }


    public void setCurrentSequence(LevelSequence sequence){

    }

}
