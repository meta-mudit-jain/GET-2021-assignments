package com.ZooManager;

import java.util.LinkedHashMap;
import java.util.Scanner;
// Zoo class
public class Zoo {
    // create static zoo object to access all methods of class
    static Zoo obj = new Zoo();
    public static Scanner scan=new Scanner(System.in);
    private LinkedHashMap<Integer, Zones> listOfZones = new LinkedHashMap<Integer, Zones>();
    // method to add Zone to zoo
    public boolean addZone(int capacityOfCages, String zoneType, boolean park, boolean canteen) {
        Zones zoneObj = new Zones(capacityOfCages, zoneType, park, canteen);
        listOfZones.put(zoneObj.zoneId, zoneObj);
        return true;
    }
    // method to add cage to zones
    public boolean addCage(String zoneType, String animalBreed, int capacity) {
        Cage cageObj = new Cage(animalBreed, capacity);
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone == zoneType
                    && listOfZones.get(i).limitOfCages > listOfZones.get(i).listOfCages.size()) {
                listOfZones.get(i).listOfCages.add(cageObj);
                return true;
            }
        }
        return false;
    }
    // method to add animal for Mammal type
    public boolean addAnimal(String type, int age, String name, String category, int weight, int speed, String sound){
        Animal animalObj = AnimalTypeFactory.addAnimal(type, age, name, category, weight, speed, sound);
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone == category) {
                for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                    if (listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
                        System.out.println("Animal with this name already present");
                    if (listOfZones.get(i).listOfCages.get(j).animalBreed == type && listOfZones.get(i).listOfCages
                            .get(j).capacityOfCage > listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()) {
                        listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // method to add animal for Birds type
    public boolean addAnimal(String type, int age, String name, String category, int weight, boolean canFly,
                             String sound){
        Animal animalObj = AnimalTypeFactory.addAnimal(type, age, name, category, weight, canFly, sound);
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone == category) {
                for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                    if (listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
                        System.out.println("Animal with this name already present");
                    if (listOfZones.get(i).listOfCages.get(j).animalBreed == type && listOfZones.get(i).listOfCages
                            .get(j).capacityOfCage > listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()) {
                        listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
                        return true;
                    }
                }
            }
        }

        return false;
    }
    // method to add animal for Reptiles type
    public boolean addAnimal(String type, int age, String name, String category, int weight, String swim,
                             String sound){
        Animal animalObj = AnimalTypeFactory.addAnimal(type, age, name, category, weight, swim, sound);
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone == category) {
                for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                    if (listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
                        System.out.println("Animal with this name already present");
                    if (listOfZones.get(i).listOfCages.get(j).animalBreed == type && listOfZones.get(i).listOfCages
                            .get(j).capacityOfCage > listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()) {
                        listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
                        return true;
                    }
                }
            }
        }

        return false;
    }
    // method to display animals in the zoo
    public void showAnimals(){
        for (int i = 0; i < listOfZones.size(); i++) {
            for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                if (i==0) {
                    System.out.println("Lions = "+listOfZones.get(i).listOfCages.get(j).listOfAnimal.keySet());
                }else if (i==1) {
                    System.out.println("Crocodiles = "+listOfZones.get(i).listOfCages.get(j).listOfAnimal.keySet());
                }else if (i==2) {
                    System.out.println("Peacocks = "+listOfZones.get(i).listOfCages.get(j).listOfAnimal.keySet());
                }
            }
        }
    }
    // method to remove animals from the zoo
    public boolean removeAnimal(String category, String breed, String name) {
        for (int i = 0; i < listOfZones.size(); i++) {
            if (listOfZones.get(i).typeOfZone == category) {
                for (int j = 0; j < listOfZones.get(i).listOfCages.size(); j++) {
                    if (listOfZones.get(i).listOfCages.get(j).animalBreed == breed
                            && listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name)) {
                        listOfZones.get(i).listOfCages.get(j).listOfAnimal.remove(name);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // method to display sounds of various animals
    public String getAnimalSound(int name) {
        switch (name) {
            case 1:
                return "Roars";
            case 2:
                return "Squawk";
            case 3:
                return "Growls";
            default:
                return "Wrong Input, Animal not found";
        }
    }
    // operation method to perform various operations of zoo
    public static void operations(){
        System.out.println("Enter 1 to add animal\n"
                + "Enter 2 to remove animal\n"
                + "Enter 3 to see sound of an animal\n"
                + "Enter 4 to add new cage\n"
                + "Enter 5 to see animals in the zoo\n"
                + "Enter 6 to exit");
        int input=scan.nextInt();
        switch (input) {
            case 1:
                System.out.println("Enter 1 for Lion\nEnter 2 for Peacock\nEnter 3 for crocodile");
                int animal_input=scan.nextInt();
                switch (animal_input) {
                    case 1:
                        System.out.println("Enter age");
                        int age=scan.nextInt();
                        System.out.println("Enter name");
                        String name=scan.next();
                        System.out.println("Enter weight");
                        int weight=scan.nextInt();
                        System.out.println("Enter speed");
                        int speed=scan.nextInt();
                        String sound="Roars";
                        boolean check=obj.addAnimal("lion", age, name, "mammal", weight, speed, sound);
                        if (check==true) {
                            System.out.println("Lion added successfully");
                        }
                        else{
                            System.out.println("Cage full,Lion addition failed");
                        }
                        break;
                    case 2:
                        System.out.println("Enter age");
                        int age1=scan.nextInt();
                        System.out.println("Enter name");
                        String name1=scan.next();
                        System.out.println("Enter weight");
                        int weight1=scan.nextInt();
                        String sound1="squawk";
                        boolean check1=obj.addAnimal("peacock", age1, name1, "bird", weight1, true, sound1);
                        if (check1==true) {
                            System.out.println("Peacock added successfully");
                        }
                        else{
                            System.out.println("Cage full,Peacock addition failed");
                        }
                        break;
                    case 3:
                        System.out.println("Enter age");
                        int age2=scan.nextInt();
                        System.out.println("Enter name");
                        String name2=scan.next();
                        System.out.println("Enter weight");
                        int weight2=scan.nextInt();
                        System.out.println("Can animal swim");
                        String canSwim=scan.next();
                        String sound2="Growls";
                        boolean check2=obj.addAnimal("crocodile", age2, name2, "reptile", weight2, canSwim, sound2);
                        if (check2==true) {
                            System.out.println("Crocodile added successfully");
                        }
                        else{
                            System.out.println("Cage full,Crocodile addition failed");
                        }
                        break;

                    default:
                        System.out.println("Wrong input.");
                        break;
                }
                break;
            case 2:
                System.out.println("Enter 1 to remove Lion\nEnter 2 to remove Peacock\nEnter 3 to remove crocodile");
                int inp=scan.nextInt();
                switch (inp) {
                    case 1:
                        System.out.println("Enter name of Lion");
                        String name_of_lion=scan.next();
                        boolean check = obj.removeAnimal("mammal", "lion", name_of_lion);
                        if(check==true){
                            System.out.println("Lion removed successfully");
                        }else{
                            System.out.println("Animal not found");
                        }
                        break;
                    case 2:
                        System.out.println("Enter name of Peacock");
                        String name_of_peacock=scan.next();
                        boolean check1 = obj.removeAnimal("bird", "peacock", name_of_peacock);
                        if(check1==true){
                            System.out.println("Peacock removed successfully");
                        }else{
                            System.out.println("Animal not found");
                        }
                        break;
                    case 3:
                        System.out.println("Enter name of Crocodile");
                        String name_of_crocodile=scan.next();
                        boolean check2 = obj.removeAnimal("reptile", "crocodile", name_of_crocodile);
                        if(check2==true){
                            System.out.println("Crocodile removed successfully");
                        }else{
                            System.out.println("Animal not found");
                        }
                        break;

                    default:
                        System.out.println("Wrong input.");
                        break;
                }
                break;
            case 3:
                System.out.println("Enter 1 for lion sound\n"
                        + "Enter 2 for peacock sound\n"
                        + "Enter 3 for Crocodile sound");
                int name=scan.nextInt();
                String sound = obj.getAnimalSound(name);
                System.out.println(sound);
                break;
            case 4:
                System.out.println("Enter 1 to add cage for lion\n"
                        + "Enter 2 to add cage for peacock\n"
                        + "Enter 3 to add cage for crocodile");
                int cage_inp=scan.nextInt();
                switch (cage_inp) {
                    case 1:
                        boolean checker=obj.addCage("mammal", "lion", 1);
                        if (checker) {
                            System.out.println("Cage added successfully");
                        }else{
                            System.out.println("Zone is full, cage can't be alloted");
                        }
                        break;
                    case 2:
                        obj.addCage("bird", "peacock", 1);
                        boolean checker1=obj.addCage("mammal", "lion", 1);
                        if (checker1) {
                            System.out.println("Cage added successfully");
                        }else{
                            System.out.println("Zone is full, cage can't be alloted");
                        }
                        break;
                    case 3:
                        boolean checker2=obj.addCage("mammal", "lion", 1);
                        obj.addCage("reptile", "crocodile", 1);
                        if (checker2) {
                            System.out.println("Cage added successfully");
                        }else{
                            System.out.println("Zone is full, cage can't be alloted");
                        }
                        break;
                    default:
                        System.out.println("Wrong input,try again");
                        break;
                }
                break;
            case 5:
                obj.showAnimals();
                break;
            case 6:
                System.out.println("Thanks to visit our Zoo");
                return;
            default:
                System.out.println("Try again, wrong input");
                break;
        }
        operations();
    }
    // main method
    public static void main(String[] args) {
        // firstly add zones for all the type of animals
        obj.addZone(5, "mammal", true, false);
        obj.addZone(8, "reptile", false, true);
        obj.addZone(3, "bird", true, true);
        // then add cages in those zones, initially 10 cages provides to each zone
        obj.addCage("mammal", "lion", 10);
        obj.addCage("bird", "peacock", 10);
        obj.addCage("reptile", "crocodile", 10);
        // call operations method
        operations();
        scan.close();
    }
}
