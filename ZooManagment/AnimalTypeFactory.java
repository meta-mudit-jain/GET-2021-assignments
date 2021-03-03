package com.ZooManager;

public class AnimalTypeFactory {
    // create animals by calling their constructors
    // add lion to Animal class
    public static Animal addAnimal(String type, int age, String name, String category, int weight, int speed,
                                   String sound) {
        Animal animal = null;
        if ("lion".equals(type))
            animal = new Lion(age, name, category, weight, speed, sound);
        return animal;
    }
    // add crocodile to Animal class
    public static Animal addAnimal(String type, int age, String name, String category, int weight, String swim,
                                   String sound) {
        Animal animal = null;
        if ("crocodile".equalsIgnoreCase(type))
            animal = new Crocodile(age, name, category, weight, swim, sound);
        return animal;
    }
    // add peacock to Animal class
    public static Animal addAnimal(String type, int age, String name, String category, int weight, boolean canFly,
                                   String sound) {
        Animal animal = null;
        if ("peacock".equalsIgnoreCase(type))
            animal = new Peacock(age, name, category, weight, canFly, sound);
        return animal;
    }
}
