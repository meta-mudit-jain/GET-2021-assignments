package com.ZooManager;

// Birds class which inherits the properties of Animal class
abstract public class Birds extends Animal {
    boolean fly;
    public Birds(int age, String name, String category, float weight, boolean canFly, String sound) {
        super(age, name, category, weight, sound);
        fly = canFly;
    }
    abstract public boolean canFly();
}
