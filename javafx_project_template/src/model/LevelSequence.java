package model;

public enum LevelSequence {
    TEN (10), 
    TWENTY (20), 
    THIRTY (30);

    private final int distance;

    private LevelSequence(int distance){
        this.distance = distance;
    }

    public int getDistance(){
        return distance;
    }
}
