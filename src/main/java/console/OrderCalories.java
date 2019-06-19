package console;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.Ingredient;
import domain.Salad;
import exception.ExceptionMinCaloryFilterLessZero;
import repository.SaladStorage;
import console.IngredientsFromFile;

/**
 * salad sorting class based on calories
 */
public class OrderCalories {
	private static SaladStorage fs = new SaladStorage();
    private static List<Salad> salads = fs.storage();
    
	static Comparator<Ingredient> comp = new Comparator<Ingredient>() {
        public int compare(Ingredient one, Ingredient two) {
            return Double.compare(one.getCalory(), two.getCalory());
        }
    };    

    /**
	* method order ingredient by calories and write into txt and binary file  
     * @throws IOException 
	*/
    public static void orderByCalories() throws IOException {
    	FileWriter fw = null;
    	ObjectOutputStream out = null;
    	try {
		    System.out.println("\nVegetables are ordered by calorie salad ");		    
		    fw = new FileWriter(".\\src\\main\\resources\\Vegetables.txt");    
		    out = new ObjectOutputStream(new FileOutputStream(".\\src\\main\\resources\\VegetablesBinary.dat"));
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
    	}
    	catch(IOException e) {
    		System.out.println("File not available");
    	}
    	finally {
    		out.close();
		    fw.close();
    	}    
    }
}
