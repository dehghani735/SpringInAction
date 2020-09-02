package com.mdt.tacobar.web.api;

import com.mdt.tacobar.Ingredient;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import java.util.ArrayList;
import java.util.List;

public class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientController.class, IngredientResource.class);
    }

    // I'm not sure this is true
    @Override
    public IngredientResource instantiateModel(Ingredient ingredient) {
        return new IngredientResource(ingredient);
    }

    // to create a TacoResource Object from a Taco and to automatically give it a self link with
    // the URL being derived from the Taco object's id property
    @Override
    public IngredientResource toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }

    public List<IngredientResource> toModels(List<Ingredient> ingredients) {
        ArrayList<IngredientResource> ingredientResourceList = new ArrayList<>();
        for (Ingredient i : ingredients) {
            ingredientResourceList.add(toModel(i));
        }
        return ingredientResourceList;
    }
}
