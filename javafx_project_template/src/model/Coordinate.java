//-----------------------------------------------------------
//File:   Coordinate.java
//Desc:   This program contains all the methods to get and set 
//          the x and y coordinate of a player. 
//----------------------------------------------------------- 
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class Coordinate{
    
    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();
    final int playerWidth;
    final int playerHeight;
    
    public int getPlayerHeight() {
        return playerHeight;
    }

    Coordinate(int x, int y){
        setX(x);
        this.x = getX();
        setY(y);
        this.y = getY();
        playerWidth = 100;
        playerHeight = 100;
        
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

    public int getPlayerWidth() {
        return playerWidth;
    }

}