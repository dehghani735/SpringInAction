package com.mdt.tacobar;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

//    Iterable<Ingredient> findAll();
//
//    Ingredient findOne(String id);
//
//    Ingredient Save(Ingredient ingredient);
}