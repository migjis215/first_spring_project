package com.example.firstproject.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChefTest {

    @Autowired
    IngredientFactory ingredientFactory;

    @Autowired
    Chef chef;

    @Test
    void cooking_bulgogi() {
        // Arrange
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
        String menu = "Bulgogi";

        // Act
        String food = chef.cook(menu);

        // Expect
        String expected = "Bulgogi made from Korean pork";

        // Assert
        assertEquals(expected, food);
        System.out.println(food);
    }

    @Test
    void cooking_steak() {
        // Arrange
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
        String menu = "Steak";

        // Act
        String food = chef.cook(menu);

        // Expect
        String expected = "Steak made from Korean rip eye";

        // Assert
        assertEquals(expected, food);
        System.out.println(food);
    }

    @Test
    void cooking_fried_chicken() {
        // Arrange
//        IngredientFactory ingredientFactory = new IngredientFactory();
//        Chef chef = new Chef(ingredientFactory);
        String menu = "Fried Chicken";

        // Act
        String food = chef.cook(menu);

        // Expect
        String expected = "Fried Chicken made from Korean chicken";

        // Assert
        assertEquals(expected, food);
        System.out.println(food);
    }
}