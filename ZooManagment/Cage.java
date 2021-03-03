package com.ZooManager;

import java.util.HashMap;
// Cage class
public class Cage {
    final String animalBreed;
    final int cageId;
    static int counter = 0;
    // Hashmap to store animal list of zoo
    HashMap<String, Animal> listOfAnimal = new HashMap<>();
    final int capacityOfCage;
    // constructor
    public Cage(String typeOfAnimal, int capacity) {
        animalBreed = typeOfAnimal;
        capacityOfCage = capacity;
        cageId = counter++;
    }
}

