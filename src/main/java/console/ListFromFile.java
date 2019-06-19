package console;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import domain.Ingredient;
import domain.Salad;
import exception.ExceptionMinCaloryFilterLessZero;
import logic.CaloryFilter;
import logic.Filter;
import repository.SaladStorage;
import console.ListFromEnter;

public class ListFromFile {
	private static SaladStorage fs = new SaladStorage();
    private static List<Salad> salads = fs.storage();
    static Integer minCalory = 0;
	static Integer maxCalory = 0;
	
    /**
	* method for setting calorie boundaries from file 
    * @throws IOException 
    * @throws ExceptionMinCaloryFilterLessZero 
	*/	
    private static void boundaryFromFile() throws IOException, ExceptionMinCaloryFilterLessZero{
		Scanner scan = null;
		FileReader fr = null;
		try {
		fr = new FileReader(".\\src\\main\\resources\\Border.txt");
        scan = new Scanner(fr);
        while (scan.hasNextLine()) {
        	if(scan.nextLine().contains("Enter the lower boundary of calories")) {
        		minCalory = Integer.valueOf(scan.nextLine());
        		System.out.println(minCalory);
        		
        	}
        	if(scan.nextLine().contains("Enter the upper boundary of calories")) {
        		maxCalory = Integer.valueOf(scan.nextLine());
        		System.out.println(maxCalory);
        	}
        }
		}
        catch(FileNotFoundException e) {
    		System.out.println("File Border.txt not found. Please, choose other way enter border");
    		ConsoleList.listOfIngredients();
    	}
    	finally {
    		scan.close();
    		fr.close();
    	}
        System.out.print("Vegetables appropriate range of calories");
	}
        
    /**
	*  method of print ingredients inside the borders 
    * @throws IOException 
    * @throws ExceptionMinCaloryFilterLessZero 
	*/	
    public static void fromFile() throws ExceptionMinCaloryFilterLessZero {
    	try {
			boundaryFromFile();
		} catch (IOException e) {
			ListFromEnter.fromEnter();
		} catch (ExceptionMinCaloryFilterLessZero e) {
			ListFromEnter.fromEnter();
		}
    	Filter filter1 = new CaloryFilter(minCalory, maxCalory);
        for (Salad salad : salads) {
            List<Ingredient> ingredients = salad.getSalad();
            System.out.println("\nSalad " + salad.getName() + ":");
            for (Ingredient ingredient : ingredients) {
                if (filter1.isSatisfy(ingredient)) {
                    System.out.println(ingredient.getName());
                }
            }
        }
	}
}
