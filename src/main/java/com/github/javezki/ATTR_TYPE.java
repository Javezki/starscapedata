package com.github.javezki;

/**
 * Attribute types to access values from hashmap
 */

public enum ATTR_TYPE {
    NAME("Ship Name"),
    TYPE("Ship Type"),
    BUYSELL("Buy/Sell"),
    VOLUME("Volume (m)"),
    INFO("Summary"),
    BONUSES("Role Bonuses"),
    CLASS("Ship Class"),
    BASEDPS("Base DPS"),
    SHIELDHEALTH("Shield Points"),
    SHIELDREGEN("Shield Regen"),
    SHIELDREDUC("Deflection"),
    HULLHEALTH("Hull Points"),
    HULLREGEN("Hull Regen"),
    HULLREDUC("Armour Rating"),
    ENERGYMAX("Energy Capacity"),
    ENERGYREGEN("Energy Regen"),
    SPEED("Speed"),
    ACCELERATION("Acceleration"),
    AGILITY("Agility"),
    WARPSPEED("Warp Speed"),
    WARPCHARGE("Warp Charge Time"),
    SENSORRANGE("Sensor Strength"),
    STEALTHRANGE("Signal Range"),
    TURRETSLOTS("Turret Slots"),
    SUBSYSTEMS("Subsystems"),
    RIGSLOTS("Rig Slots"),
    RECIPE("Recipe");

    
    
    public final String label;

    private ATTR_TYPE(String label)
    {
    this.label = label;
    }
}
