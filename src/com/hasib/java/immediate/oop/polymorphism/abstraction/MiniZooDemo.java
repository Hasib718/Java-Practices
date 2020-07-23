package com.hasib.java.immediate.oop.polymorphism.abstraction;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

abstract class Animal {
    private int legs;

    public Animal(int legs) {
        this.legs = legs;
    }

    public void sleep() {
        System.out.println(getClass().getSimpleName() +
                            " Sleeping.....Don't Disturb!");
    }

    public abstract String getDiet();
}
class Lion extends Animal{
    public Lion(int legs){
        super(legs);
    }

    @Override
    public String getDiet() {
        return "Meat";
    }
}
class Tiger extends Animal{
    public Tiger(int legs){
        super(legs);
    }

    @Override
    public String getDiet(){
        return "Meat";
    }
}
class Deer extends Animal{
    public Deer(int legs){
        super(legs);
    }

    @Override
    public String getDiet() {
        return "Grass";
    }
}

class MiniZoo{
    private Animal[] animals;

    public MiniZoo(Animal[] animals){
        this.animals = animals;
    }

    public void putThemOnSleep(){
        for (Animal animal : animals){
            animal.sleep();
        }
    }

    public void printDietOfAllAnimals(){
        for (Animal animal: animals){
            System.out.println(animal.getClass().getSimpleName()
                                + " eats " +
                                animal.getDiet());
        }
    }
}

public class MiniZooDemo {
    public static void main(String[] args){
        Animal[] animals = new Animal[3];

        animals[0] = new Tiger(4);
        animals[1] = new Deer(4);
        animals[2] = new Lion(4);

        MiniZoo miniZoo = new MiniZoo(animals);
        miniZoo.putThemOnSleep();
        System.out.println("\n");
        miniZoo.printDietOfAllAnimals();
    }
}