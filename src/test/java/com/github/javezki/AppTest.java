package com.github.javezki;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

import com.github.javezki.ship.Attributes;
import com.github.javezki.ship.RigSlots;
import com.github.javezki.ship.RigSlots.Rigs;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    Attributes attributes;

    RigSlots slots;

    @Before
    public void setUp() {
        attributes = new Attributes("KnifeJaw");
        slots = new RigSlots("KnifeJaw");
    }

    @Test
    public void testDataOutput() {
        HashMap<String, String> stat = attributes.getShipAttributes("KnifeJaw");

        for (String key : stat.keySet()){
            System.out.println(key + " : " + stat.get(key));
        }
    }

    @Test
    public void testGetAttributes()
    {
        assertEquals("Error at get attributes", "210.0", attributes.getAttribute(ATTR_TYPE.SPEED));
        
    }

    @Test
    public void testGetSlots()
    {
        assertEquals("Error at get hull", 2, slots.getSlotCount(Rigs.WEP));
    }
}
