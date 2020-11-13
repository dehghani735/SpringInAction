package com.mdt.ocp.chapter2.DesignPatterns.Builder;

import com.mdt.ocp.chapter2.DesignPatterns.ImmutableObjects.MutableAnimal;

import java.util.Arrays;
import java.util.List;

public class AnimalBuilder {
    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    public MutableAnimal build() {
        return new MutableAnimal(species, age, favoriteFoods);
    }

    public static void main(String[] args) {
        AnimalBuilder duckBuilder = new AnimalBuilder();
        duckBuilder
                .setAge(4)
                .setFavoriteFoods(Arrays.asList("grass","fish")).setSpecies("duck");
        MutableAnimal duck = duckBuilder.build();

        MutableAnimal flamingo = new AnimalBuilder()
                .setFavoriteFoods(Arrays.asList("algae","insects"))
                .setSpecies("flamingo").build();
    }
}