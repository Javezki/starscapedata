package com.github.javezki;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    ReadData data;

    @Before
    public void setUp() {
        data = new ReadData("KnifeJaw");
    }

    @Test
    public void shouldAnswerWithTrue() {
        HashMap<Integer, String> attributes = data.getAttributesFromSheet();
        for (int i = 0 ; i < attributes.size(); i++)
        {
            System.out.println(attributes.get(i));
        }
    
    }

    @Test
    public void testDataOutput() {
        HashMap<String, String> stat = data.getShipStats("KnifeJaw");

        for (String key : stat.keySet()){
            System.out.println(key + " : " + stat.get(key));
        }
    }

    @Test
    public void testGetAttributes()
    {
        assertEquals("Error at get attributes", "210.0", data.getAttribute(ATTR_TYPE.SPEED));
        
    }
}
