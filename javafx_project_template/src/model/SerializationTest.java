//-----------------------------------------------------------
//File:   SerializationTest.java
//Desc:   Unit testing fer saveable 
//----------------------------------------------------------- 
 package model;

 import org.junit.Test;

 public class SerializationTest {
    

     @Test
     public void testSave() {
         Road r = new Road(3, 3);
         r.load();
     }

 }
