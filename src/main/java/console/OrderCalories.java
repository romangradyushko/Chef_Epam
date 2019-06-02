package console;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.Ingredient;
import domain.Salad;
import repository.SaladStorage;

/**
 * salad sorting class based on calories
 */
public class OrderCalories {
	private static SaladStorage fs = new SaladStorage();
    private static List<Salad> salads = fs.read();
    
	static Comparator<Ingredient> comp = new Comparator<Ingredient>() {
        public int compare(Ingredient one, Ingredient two) {
            return Double.compare(one.getCalory(), two.getCalory());
        }
    };    

    public static void OrderByCalories() throws IOException {
    System.out.println("\nVegetables are ordered by calorie salad ");
    
    FileWriter fw = new FileWriter("Vegetables.txt");    
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("VegetablesBinary.dat"));
    
    for (Salad salad : salads) {
        List<Ingredient> ingredients = salad.getSalad();
        Collections.sort(ingredients, comp);
        System.out.println("\nSalad " + salad.getName() + ":");
        fw.write(salad.getName() + "\n");
        out.writeObject(salad.getName() + "\n");
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getName() + " - " + ingredient.getCalory());
            fw.write(ingredient.getName() + " - " + ingredient.getCalory() + "\n");
            out.writeObject(ingredient.getName() + " - " + ingredient.getCalory() + "\n");

        }
    }
     
    out.close();
    fw.close();
}
}
