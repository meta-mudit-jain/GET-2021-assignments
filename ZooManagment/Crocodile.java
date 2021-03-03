package com.ZooManager;

// Crocodile class inherits properties of Reptiles
public class Crocodile extends Reptiles {
    // constructor of class, which create animal
    public Crocodile(int age, String name, String category, int weight, String canSwim, String sound) {
        super(age, name, category, weight, canSwim, sound);
    }

    public String getSound() {
        return super.soundOfAnimal;
    }

    public String swimSpeed() {
        return super.swim;
    }
}
