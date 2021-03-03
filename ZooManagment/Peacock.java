package com.ZooManager;

// Peacock class inherits Birds class
public class Peacock extends Birds {
    // constructor method
    public Peacock(int age, String name, String category, int weight, boolean canFly, String sound) {
        super(age, name, category, weight, canFly, sound);
    }

    public String getSound() {
        return super.soundOfAnimal;
    }

    public boolean canFly() {
        return super.fly;
    }
}
