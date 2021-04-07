package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoadTesting {
    @Test
    public void testAddingObjectA_addedObject() {
        var road = new Road();
        road.addObjectsA(RoadBlock.CARS, 5);
        assertEquals(5, road.getObject(5));
    }
    
    public void testAddingObjectB_addedObject() {
        var road = new Road();
        road.addObjectsA(RoadBlock.POTHOLES, 5);
        assertEquals(5, road.getObject(5));
    }
    
    public void testAddingObjectC_addedObject() {
        var road = new Road();
        road.addObjectsA(RoadBlock.CARS, 5);
        assertEquals(5, road.getObject(5));
    }
    
    
}
