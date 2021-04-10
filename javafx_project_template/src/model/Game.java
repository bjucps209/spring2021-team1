package model;

import java.io.FileWriter;

public class Game {
    public void gameUpdate(){
        //Need a master “game update” method that is called each time the screen is refreshed and 
        //updates the positions of all objects, checks for collisions, updates time left, etc.
    }

    public void save() {
        try(FileWriter fr = new FileWriter("src/data.txt")){
            for (Savable o: Road.saveList) {
                fr.append(o.getClass().getName() + "\n");
                fr.append(String.valueOf(o.getX() + " "));
                fr.append(String.valueOf(o.getY() + "\n"));
                fr.append("END" + "\n");


            }
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
