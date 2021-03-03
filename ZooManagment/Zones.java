package com.ZooManager;

import java.util.ArrayList;
// Zone class
public class Zones {
    final int limitOfCages;
    String typeOfZone;
    final int zoneId;
    static int counter = 0;
    // Array List of cages
    ArrayList<Cage> listOfCages = new ArrayList<Cage>();
    boolean hasPark;
    boolean hasCanteen;
    // constructor to create zone
    public Zones(int capacityForCagesInZone, String zoneType, boolean park, boolean canteen) {
        limitOfCages = capacityForCagesInZone;
        typeOfZone = zoneType;
        zoneId = counter++;
        hasPark = park;
        hasCanteen = canteen;
    }
}