package com.mdt.tacobar.web;

import com.mdt.tacobar.Ingredient;
import com.mdt.tacobar.Order;
import com.mdt.tacobar.Taco;
import com.mdt.tacobar.data.IngredientRepository;
import com.mdt.tacobar.data.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/design")
@SessionAttributes("order") // available across multiple sessions
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo,
                                TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @ModelAttribute(name = "design") // ensures that an
    public Taco design(){
        return new Taco();
    }

    @ModelAttribute(name = "order") // ensures that an Order object will be created in the model.
    public Order order() {
        return new Order();
    }

    @GetMapping
    public String ShowDesignForm(Model model) {
//        List<Ingredient> ingredients = Arrays.asList(
//                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
//                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
//                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
//                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
//                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
//                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
//                new Ingredient("CHED", "Cheddar", Type.CHEESE),
//                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
//                new Ingredient("SLSA", "Salsa", Type.SAUCE),
//                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
//        );

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        } // data that's placed in Model attributes is copied into the servlet response attributes,
        // where the view can find them. Order object remains in the session and isn’t saved to the database
        // until the user completes and submits the order form.

//        model.addAttribute("design", new Taco()); // TODO based on https://github.com/habuma/spring-in-action-5-samples/blob/master/ch03/tacos-jpa/src/main/java/tacos/web/DesignTacoController.java

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors,
                                @ModelAttribute Order order) { // ModelAttribute: its value should come from
        // the model and that Spring MVC shouldn't attempt to bind request parameters to it

        if (errors.hasErrors()) {
            return "design";
        }

        // save taco design
        // chapter 3
        Taco saved = designRepo.save(design);
        order.addDesign(saved);

//        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        List<Ingredient> filteredList = new ArrayList<Ingredient>();
        for (Ingredient ing: ingredients) {
            if (ing.getType() == type) {
                filteredList.add(ing);
            }
        }
        return filteredList;
    }
}
