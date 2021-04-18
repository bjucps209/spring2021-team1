package model;

public enum DifficultyLevel{
    EASY (15),
    MEDIUM (20),
    HARD (25);

    private final int amtObj;

    private DifficultyLevel(int amtObj){
        this.amtObj = amtObj;
    }

    public int getAmtObj(){
        return amtObj;
    }
}
