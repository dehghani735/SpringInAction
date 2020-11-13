package com.mdt.ocp.chapter2.DesignPatterns.ImmutableObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Animal {
    private final List<String> favoriteFoods;

    public Animal(List<String> favoriteFoods) {
        if (favoriteFoods == null)
            throw new RuntimeException("favoriteFoods is required!");
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
    }

    public List<String> getFavoriteFoods() {  // MAKES CLASS MUTABLE!
        return favoriteFoods;
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
