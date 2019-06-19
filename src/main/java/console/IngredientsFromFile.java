package console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Ingredient;
//import exception.ExceptionMinCaloryFilterLessZero;


public class IngredientsFromFile {
	
	/**
	* 
	* method of read from file  
	*/
	public static void readIngredient() {
		List<Ingredient> Ingredients2 = new ArrayList<>();
		Scanner scan = null;
		String line, name = "";
		double weight = 0;
		int calory = 0;
		try {
			File file = new File(".\\src\\main\\resources\\ingredients.txt");
			FileReader fileReader = new FileReader(file);
			scan = new Scanner(fileReader);
			while (scan.hasNextLine()) {
				line = scan.nextLine();
	        	if(line.contains("Name")) {	
	        		name = scan.nextLine();
	        	}
	        	if(line.contains("Weight")) {
	        		weight = scan.nextDouble();
	        	}
	        	if(line.contains("Calory")) {
	        		calory = scan.nextInt();
	        		Ingredients2.add(new Ingredient(name, calory, weight));
	        	}
			}	
			for(Ingredient ingredient : Ingredients2) {
				System.out.println("Ingredient object from txt file:\n"  +
    					ingredient.getName() + " " + ingredient.getWeight() + " g " + ingredient.getCalory() + " calory");
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Sorry, but file with ingredients not found");
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		finally {
			scan.close();
		}
	}
}
