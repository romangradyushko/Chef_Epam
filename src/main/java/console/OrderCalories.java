package console;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.Ingredient;
import domain.Salad;
import repository.SaladStorage;

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
    DataOutputStream out = new DataOutputStream(new FileOutputStream("VegetablesBinary.txt"));    
    
    for (Salad salad : salads) {
        List<Ingredient> ingredients = salad.getSalad();
        Collections.sort(ingredients, comp);
        System.out.println("\nSalad " + salad.getName() + ":");
        fw.write(salad.getName() + "\n");
        out.writeUTF(salad.getName() + "\n");
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getName() + " - " + ingredient.getCalory());
            fw.write(ingredient.getName() + " - " + ingredient.getCalory() + "\n");
            out.writeUTF(ingredient.getName() + " - " + ingredient.getCalory() + "\n");
        }
    }
     
    out.close();
    fw.close();
}
}
