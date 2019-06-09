package console;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.Ingredient;
import domain.Salad;
import exception.ExceptionMinCaloryFilterLessZero;
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

    /**
	* method order ingredient by calories and write into txt and binary file  
	*/
    public static void OrderByCalories() {
    	try {
		    System.out.println("\nVegetables are ordered by calorie salad ");
		    
		    FileWriter fw = new FileWriter(".\\src\\main\\java\\resources\\Vegetables.txt");    
		    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\src\\main\\java\\resources\\VegetablesBinary.dat"));
		    
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
    	catch(IOException e) {
    		System.out.println("File not available");
    	}
     
    
    }
}
