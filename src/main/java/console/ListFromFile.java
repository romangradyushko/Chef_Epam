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

public class ListFromFile {
	private static SaladStorage fs = new SaladStorage();
    private static List<Salad> salads = fs.read();
    
    /**
	* method for setting calorie boundaries from file 
     * @throws IOException 
     * @throws ExceptionMinCaloryFilterLessZero 
	*/
	public static void FromFile() throws IOException, ExceptionMinCaloryFilterLessZero {		
		Integer minCalory = 0, maxCalory = 0;
		try {
		FileReader fr= new FileReader(".\\src\\main\\resources\\Border.txt");
        Scanner scan = new Scanner(fr);
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
        fr.close();
        scan.close();
        System.out.print("Vegetables appropriate range of calories");

        
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
	catch(FileNotFoundException e) {
		System.out.println("File Border.txt not found. Please, choose other way enter border");
		ConsoleList.listOfIngredients();
	}
}
}
