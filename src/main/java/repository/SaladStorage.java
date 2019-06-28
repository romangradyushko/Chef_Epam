package repository;

import java.util.ArrayList;
import java.util.List;


import domain.Ingredient;
import domain.Salad;

/**
 * salad storage class
 */
public class SaladStorage {

    
    public List<Salad> storage() {
        List<Salad> salads = new ArrayList<>();
        // salad #1
        Salad firstSalad = new Salad();
        firstSalad.setName("Vegetables");
        List<Ingredient> firstIngredients = new ArrayList<>();
        
        Ingredient firstingredient1 = new Ingredient("Tomato", 20, 200);        
        firstIngredients.add(firstingredient1);
        Ingredient firstingredient2 = new Ingredient("Cucumber", 14, 200);
        firstIngredients.add(firstingredient2);
        Ingredient firstingredient3 = new Ingredient("SourCream", 206, 100);
        firstIngredients.add(firstingredient3);
        
        firstSalad.setSalad(firstIngredients);
        salads.add(firstSalad);
        
        // salad #2
        Salad secondSalad = new Salad();
        secondSalad.setName("Russian");
        List<Ingredient> secondIngredients = new ArrayList<>();
        
        Ingredient secondIngredient1 = new Ingredient("Sausage", 257, 200);
        secondIngredients.add(secondIngredient1);
        Ingredient secondIngredient2 = new Ingredient("Peas", 58, 250);
        secondIngredients.add(secondIngredient2);
        Ingredient secondIngredient3 = new Ingredient("Cucumber", 14, 200);
        secondIngredients.add(secondIngredient3);
        Ingredient secondIngredient4 = new Ingredient("Potato", 77, 300);
        secondIngredients.add(secondIngredient4);
        Ingredient secondIngredient5 = new Ingredient("Mayo", 680, 100);
        secondIngredients.add(secondIngredient5);
        
        secondSalad.setSalad(secondIngredients);
        salads.add(secondSalad);

        return salads;
    }
}
