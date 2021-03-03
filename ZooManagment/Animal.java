package com.ZooManager;

abstract public class Animal {
    int ageOfAnimal;
    static int counter = 0;
    final int animalId;
    String animalName;
    String categoryOfAnimal;
    float weightOfAnimal;
    String soundOfAnimal;
    // constructor of class Animal
    public Animal(int age, String name, String category, float weight, String sound) {
        this.ageOfAnimal = age;
        this.animalName = name;
        this.categoryOfAnimal = category;
        this.weightOfAnimal = weight;
        animalId = counter++;
        soundOfAnimal = sound;
    }
    abstract public String getSound();
}