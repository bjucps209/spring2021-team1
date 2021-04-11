package model;

class Coordinate{
    
    int x;
    Lane y;
    
    Coordinate(int x, Lane y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(Lane y) {
        this.y = y;
    }

    public Lane getY() {
        return y;
    }
    

}