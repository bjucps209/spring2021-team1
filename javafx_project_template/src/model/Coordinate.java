package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Coordinate{
    
    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();
    
    Coordinate(int x, int y){
        setX(x);
        this.x = getX();
        setY(y);
        this.y = getY();
    }

    public final void setX(double value){
        x.set(value);
    }
    public DoubleProperty getX() {
        return x;
    }
    public final double getdoubleX(){
        return x.get();
    }

    public final void setY(double value){
        y.set(value);
    }
    public DoubleProperty getY() {
        return y;
    }

    public final double getdoubleY(){
        return y.get();
    }
    

}