//-----------------------------------------------------------
//File:   SerializationTest.java
//Desc:   Unit testing fer saveable 
//----------------------------------------------------------- 
 package model;

 import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

 public class SerializationTest {
    
    public void testSave() {
        Road r = new Road(11, 11);
        r.save();
    }

     @Test
     public void testLoad() {
         try(var rd = new BufferedReader(new FileReader("data.txt"))) {
            rd.readLine();
            double testX = Double.parseDouble(rd.readLine());
            double testY = Double.parseDouble(rd.readLine());
            Road r = new Road(11, 11);
            r.load();
            assertEquals(testX, r.usingRB.get(0).getX());
         }
         catch (IOException e) {

         }
        

         //System.out.println(r.getUsingRB().size());
        // Obstacle obst1 = r.getUsingRB().get(0);
        
        
     }

 }
