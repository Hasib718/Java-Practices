package com.hasib.java.advance.lambda;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Uses of lambda express can reduce this much of codes
 * <p>
 * class DarkCookieCrumb extends CoffeeDecorator {
 * <p>
 * public DarkCookieCrumb(Coffee coffee) {
 * super(coffee);
 * }
 *
 * @Override public String getIngredient() {
 * return super.getIngredient() + " + Dark Cookie Crumb";
 * }
 * }
 * <p>
 * class VanillaAlmondExtract extends CoffeeDecorator {
 * <p>
 * public VanillaAlmondExtract(Coffee coffee) {
 * super(coffee);
 * }
 * @Override public String getIngredient() {
 * return super.getIngredient() + " + Vanilla/Almond";
 * }
 * }
 * <p>
 * class SweetenedMilk extends CoffeeDecorator {
 * <p>
 * public SweetenedMilk(Coffee coffee) {
 * super(coffee);
 * }
 * @Override public String getIngredient() {
 * return super.getIngredient() + " + Sweetened Milk";
 * }
 * }
 * <p>
 * class SaltedCaramelFudge extends CoffeeDecorator {
 * <p>
 * public SaltedCaramelFudge(Coffee coffee) {
 * super(coffee);
 * }
 * @Override public String getIngredient() {
 * return super.getIngredient() + " + Salted Caramel Fudge";
 * }
 * }
 * <p>
 * abstract class CoffeeDecorator implements Coffee {
 * private Coffee coffee;
 * <p>
 * public CoffeeDecorator(Coffee coffee) {
 * this.coffee = coffee;
 * }
 * @Override public String getIngredient() {
 * return coffee.getIngredient();
 * }
 * }
 * <p>
 * class CoffeeBean implements Coffee {
 * @Override public String getIngredient() {
 * return "Coffee Bean";
 * }
 * }
 **/

@FunctionalInterface
interface Coffee {
    static Coffee withSaltedCaramelFudge(Coffee coffee) {
        return () -> coffee.getIngredient() + " + Salted Caramel Fudge";
    }

    static Coffee withSweetenedMilk(Coffee coffee) {
        return () -> coffee.getIngredient() + " + Sweetened Milk";
    }

    static Coffee withVanillaAlmondExtract(Coffee coffee) {
        return () -> coffee.getIngredient() + " + Vanilla/Almond Extract";
    }

    static Coffee withDarkCookieCrumb(Coffee coffee) {
        return () -> coffee.getIngredient() + " + Dark Cookie Crumb";
    }

    String getIngredient();
}

/**
 * This class is an example of java DECORATOR PATTERN
 */
public class CoffeeApp {
    public static void main(String[] args) {
//        var coffee = new VanillaAlmondExtract(new SaltedCaramelFudge(new SweetenedMilk(new CoffeeBean())));

        var coffee = getCoffeeWithExtras(() -> "Coffee Bean", Coffee::withDarkCookieCrumb,
                Coffee::withSweetenedMilk, Coffee::withVanillaAlmondExtract, coffee1 -> () -> coffee1.getIngredient() + " + Test",
                coffee2 -> () -> coffee2.getIngredient() + " + Testing again");

        System.out.println(coffee.getIngredient());
    }

    public static Coffee getCoffeeWithExtras(Coffee coffee, Function<Coffee, Coffee>... ingredients) {
        return Stream.of(ingredients).reduce(Function.identity(), Function::andThen).apply(coffee);
    }
}
