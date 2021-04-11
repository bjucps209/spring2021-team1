package model;

import org.junit.Test;

public class SerializationTest {
    

    @Test
    public void testSave() {
        //Road road = new Road();
        for (Object o : Road.saveList) {
            System.out.println(o);
        }
        Game.save();
    }

}
