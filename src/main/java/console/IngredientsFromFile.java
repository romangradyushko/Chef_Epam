package console;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import domain.Ingredient;


public class IngredientsFromFile {
	public static void readIngredient() {
		try {
	  		File file = new File(".\\src\\main\\java\\resources\\ingredients.txt");
			FileReader fileReader = new FileReader(file);
			Scanner scan = new Scanner(fileReader);
			String line;
			Ingredient nameingredient = new Ingredient();
			while (scan.hasNextLine()) {
				line = scan.nextLine();
	        	if(line.contains("Name")) {
	        		nameingredient.setName(scan.nextLine());	
	        	}
	        	if(line.contains("Weight")) {
	        		nameingredient.setWeight(Double.valueOf(scan.nextLine()));
	        	}
	        	if(line.contains("Calory")) {
	        		nameingredient.setCalory(Integer.valueOf(scan.nextLine()));
	        	}
			}
			System.out.println("Ingredient object from txt file:\n"  +
					nameingredient.getName() + " " + nameingredient.getWeight() + " g " + nameingredient.getCalory() + " calory");
				
			scan.close();	
				  		}
				      catch(IOException ex) {
				  			ex.printStackTrace();
				  		}
	}
}
