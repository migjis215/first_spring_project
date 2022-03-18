package com.example.firstproject.ioc;

import org.springframework.stereotype.Component;

@Component // Make this class an object and register it in the IoC container
public class IngredientFactory {
    public Ingredient get(String menu) {
        switch (menu) {
            case "Bulgogi":
                return new Pork("Korean pork");
            case "Steak":
                return new Beef("Korean rip eye");
            case "Fried Chicken":
                return new Chicken("Korean chicken");
            default:
                return null;
        }
    }
}
