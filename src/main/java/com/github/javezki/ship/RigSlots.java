package com.github.javezki.ship;

import com.github.javezki.ATTR_TYPE;

public class RigSlots {
    
    public enum Rigs{
        WEP(0), 
        DEF(2), 
        ENG(4), 
        RCT(6);
        
        private final int hull;

        Rigs(int i)
        {
            hull = i;
        }
    }

    private Attributes attributes;


    public RigSlots(String ship)
    { 
        this.attributes = new Attributes(ship);
    }


    /**
     * 
     * @return String of Rig Slots from HashMap
     */
    private String getRigSlots()
    {
        return attributes.getAttributes()
        .get(ATTR_TYPE.RIGSLOTS.label);
    }

    /**
     * 
     * @param rig Enum from rig which represents which module to get
     * @return The amount of that module the ship can equip
     */
    public int getSlotCount(Rigs rig)
    {
        String slots = getRigSlots();
        
        return Character.getNumericValue(slots.charAt(rig.hull));
    }
}

