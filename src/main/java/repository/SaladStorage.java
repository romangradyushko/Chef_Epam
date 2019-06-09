package repository;

import java.util.ArrayList;
import java.util.List;


import domain.Ingredient;
import domain.Salad;

/**
 * salad storage class
 */
public class SaladStorage {

    
    public List<Salad> read() {
        List<Salad> salads = new ArrayList<>();
        // salad #1
        Salad firstSalad = new Salad();
        firstSalad.setName("Vegetables");
        List<Ingredient> firstIngredients = new ArrayList<>();
        Ingredient firstingredient1 = new Ingredient();
        firstingredient1.setName("Tomato");
        firstingredient1.setWeight(200);
        firstingredient1.setCalory(20);
        firstIngredients.add(firstingredient1);

        Ingredient firstingredient2 = new Ingredient();
        firstingredient2.setName("Cucumber");
        firstingredient2.setWeight(200);
        firstingredient2.setCalory(14);
        firstIngredients.add(firstingredient2);

        Ingredient firstingredient3 = new Ingredient();
        firstingredient3.setName("SourCream");
        firstingredient3.setWeight(100);
        firstingredient3.setCalory(206);
        firstIngredients.add(firstingredient3);

        
        firstSalad.setSalad(firstIngredients);
        salads.add(firstSalad);
        
        // salad #2
        Salad secondSalad = new Salad();
        secondSalad.setName("Russian");
        List<Ingredient> secondIngredients = new ArrayList<>();
        Ingredient secondIngredient1 = new Ingredient();
        secondIngredient1.setName("Sausage");
        secondIngredient1.setWeight(200);
        secondIngredient1.setCalory(257);
        secondIngredients.add(secondIngredient1);
        
        Ingredient secondIngredient2 = new Ingredient();
        secondIngredient2.setName("Peas");
        secondIngredient2.setWeight(250);
        secondIngredient2.setCalory(58);
        secondIngredients.add(secondIngredient2);
        
        Ingredient secondIngredient3 = new Ingredient();
        secondIngredient3.setName("Cucumber");
        secondIngredient3.setWeight(200);
        secondIngredient3.setCalory(14);
        secondIngredients.add(secondIngredient3);
        
        Ingredient secondIngredient4 = new Ingredient();
        secondIngredient4.setName("Potato");
        secondIngredient4.setWeight(300);
        secondIngredient4.setCalory(77);
        secondIngredients.add(secondIngredient4);
        
        Ingredient secondIngredient5 = new Ingredient();
        secondIngredient5.setName("Mayo");
        secondIngredient5.setWeight(100);
        secondIngredient5.setCalory(680);
        secondIngredients.add(secondIngredient5);
        
        secondSalad.setSalad(secondIngredients);
        salads.add(secondSalad);

        return salads;
    }
}
