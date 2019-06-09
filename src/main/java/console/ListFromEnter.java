package console;


import java.util.List;
import java.util.Scanner;

import domain.Ingredient;
import domain.Salad;
import exception.ExceptionMinCaloryFilterLessZero;
import logic.CaloryFilter;
import logic.Filter;
import repository.SaladStorage;

public class ListFromEnter {
	private static SaladStorage fs = new SaladStorage();
    private static List<Salad> salads = fs.read();
    
    
	public static void FromEnter() throws ExceptionMinCaloryFilterLessZero {
		Integer minCalory = 0, maxCalory = 0;
		final Scanner sc = new Scanner(System.in);
		System.out.print("Enter the lower boundary of calorie ");
		minCalory = sc.nextInt();
		System.out.print("Enter the upper boundary of calorie ");
		maxCalory = sc.nextInt();
		//sc.close();
		
        
        System.out.print("Vegetables appropriate range of calories");


        Filter filter = new CaloryFilter(minCalory, maxCalory);

        for (Salad salad : salads) {
            List<Ingredient> ingredients = salad.getSalad();
            System.out.println("\nСалат " + salad.getName() + ":");

            for (Ingredient ingredient : ingredients) {
                if (filter.isSatisfy(ingredient)) {
                    System.out.println(ingredient.getName());
                }
            }
        }
	}
}
