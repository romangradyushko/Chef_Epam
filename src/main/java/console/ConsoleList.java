package console;

import java.io.*;
import java.util.*;

import com.sun.xml.internal.ws.util.StringUtils;

import controller.CaloryFilter;
import controller.Filter;
import domain.Ingredient;
import domain.Salad;
import repository.SaladStorage;

public class ConsoleList {
	private static SaladStorage fs = new SaladStorage();
    private static List<Salad> salads = fs.read();

	public static void listOfSalads(){
		PrintMenu.listOfSalads();
	}
      
	public static void listOfIngredients() throws IOException {
		final Scanner sc = new Scanner(System.in);
        System.out.print("Enter x ");
        Integer x = sc.nextInt();
       
		switch(x) {
		case 1: 
	        ListFromEnter.FromEnter();
				break;			
		case 2: 
			ListFromFile.FromFile();
				break;
		/*case 3: 
			ListFromBinaryFile.FromFile();
				break;*/
		default:
			ListFromEnter.FromEnter();
				break;
		}
		sc.close();
	}
	
	public static void listOfOrderCalories() throws IOException {
		OrderCalories.OrderByCalories();
	}
}
