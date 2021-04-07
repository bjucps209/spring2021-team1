package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoadTesting {
    @Test
    public void testAdd_PositiveNums_PositiveResult() {
        var road = new Road();
        road.addObjectsA(RoadBlock.CARS, 5);
        assertEquals(5, road.getObject(5));
    }

    

}