package com.mdt.tacobar.web.api;

import com.mdt.tacobar.Ingredient;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import com.mdt.tacobar.Ingredient.Type;

public class IngredientResource extends RepresentationModel<IngredientResource> {

    @Getter
    private String name;

    @Getter
    private Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
