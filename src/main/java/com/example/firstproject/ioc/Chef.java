package com.example.firstproject.ioc;

import org.springframework.stereotype.Component;

@Component
public class Chef {
    private IngredientFactory ingredientFactory;

    public Chef(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public String cook(String menu) {
        Ingredient ingredient = ingredientFactory.get(menu);

        return menu + " made from " + ingredient.getName();
    }
}
