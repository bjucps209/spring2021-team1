//-----------------------------------------------------------
//File:   Coordinate.java
//Desc:   This program contains all the methods to get and set 
//          the x and y coordinate of a player. 
//----------------------------------------------------------- 
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

//Coordinate for the obstacle objects
public class Coordinate{
    //X value for the object
    private DoubleProperty x = new SimpleDoubleProperty();
    //Y value for the object
    private DoubleProperty y = new SimpleDoubleProperty();
    //Width of the object
    final int playerWidth;
    
    
    
//============================Constructor===========================//
    Coordinate(int x, int y){
        setX(x);
        this.x = getX();
        setY(y);
        this.y = getY();
        playerWidth = 100;
        
        
    }
//============================Setters/Getters===========================//
    public void setX(double value){
        x.set(value);
    }
    public DoubleProperty getX() {
        return x;
    }
    public double getdoubleX(){
        return x.get();
    }

    public void setY(double value){
        y.set(value);
    }
    public DoubleProperty getY() {
        return y;
    }

    public double getdoubleY(){
        return y.get();
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

}