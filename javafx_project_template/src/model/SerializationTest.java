package model;

import org.junit.Test;

public class SerializationTest {
    

    @Test
    public void testSave() {
        Road r = new Road();
        for (Savable o : r.saveList) {
            o.serialize();
        }
    }

}
