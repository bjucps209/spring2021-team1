package model;

public enum DifficultyLevel{
    EASY (10),
    MEDIUM (15),
    HARD (20);

    private final int amtObj;

    private DifficultyLevel(int amtObj){
        this.amtObj = amtObj;
    }

    public int getAmtObj(){
        return amtObj;
    }
}
