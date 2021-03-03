package com.ZooManager;

// Mammal class inherit Animal class properties
abstract public class Mammals extends Animal {
    int runningSpeed;
    // Mammal constructor
    public Mammals(int age, String name, String category, float weight, int speed, String sound) {
        super(age, name, category, weight, sound);
        runningSpeed = speed;
    }

    abstract public int topSpeed();
}