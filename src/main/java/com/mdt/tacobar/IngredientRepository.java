package com.mdt.tacobar;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient Save(Ingredient ingredient);
}