package com.github.javezki.ship;

import java.util.HashMap;

import com.github.javezki.ATTR_TYPE;
import com.github.javezki.ReadData;

public class Attributes extends ReadData{

    private HashMap<String, String> attributes;

    public Attributes(String ship)
    {
        super(ship);
        this.attributes = getAttributes();
    }

    /**
     * 
     * @return Attribute Hashmap containing all the attributes/
     */

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param type Attribute enum
     * @return The string form of the attribute of ship
     */
    public String getAttribute(ATTR_TYPE type) {
        return attributes.get(type.label);
    }

}
