package com.mdt.ocp.chapter2.DesignPatterns.ImmutableObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// all five rules are preserved and instances of this class are immutable.
public final class MutableAnimal {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public MutableAnimal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null)
            throw new RuntimeException("favoriteFoods is required!");
        this.favoriteFoods = new ArrayList<>(favoriteFoods); // important, to create its own instance
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }

    public static void main(String[] args) {
        // Create a new MutableAnimal instance
        MutableAnimal lion = new MutableAnimal("lion", 5, Arrays.asList("Meat", "only Meat"));

        // Create a new Animal instance using data from the first instance
        List<String> favoriteFoods = new ArrayList<String>();
        for (int i = 0; i < lion.getFavoriteFoodsCount(); i++) {
            favoriteFoods.add(lion.getFavoriteFood(i));
        }

        MutableAnimal anotherLion = new MutableAnimal(lion.getSpecies(), lion.getAge() + 1, favoriteFoods);

        System.out.println(anotherLion.getAge());
    }
}