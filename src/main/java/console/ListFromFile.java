package console;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import controller.CaloryFilter;
import controller.Filter;
import domain.Ingredient;
import domain.Salad;
import repository.SaladStorage;

public class ListFromFile {
	private static SaladStorage fs = new SaladStorage();
    private static List<Salad> salads = fs.read();
	public static void FromFile() throws IOException {		
		Integer minCalory = 0, maxCalory = 0;
		FileReader fr= new FileReader("Border.txt");
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
            System.out.println("\nСалат " + salad.getName() + ":");

            for (Ingredient ingredient : ingredients) {
                if (filter1.isSatisfy(ingredient)) {
                    System.out.println(ingredient.getName());
                }
            }
        }
	}
}
