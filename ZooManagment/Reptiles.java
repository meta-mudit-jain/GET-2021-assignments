package com.ZooManager;

// Reptiles class inherit class Animal
abstract public class Reptiles extends Animal {
    String swim;
    // Reptile class constructor
    public Reptiles(int age, String name, String category, float weight, String canSwim, String sound) {
        super(age, name, category, weight, sound);
        swim = canSwim;
    }

    abstract public String swimSpeed();
}

