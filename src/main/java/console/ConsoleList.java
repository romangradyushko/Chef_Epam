package console;

import java.io.*;
import java.util.*;


public class ConsoleList {

	/**
	* method of choosing how to display
	* a list of salads with total calorie
	*/
	public static void listOfSalads(){
		PrintMenu.listOfSalads();
	}
    
	/**
	* method of choosing how to display
	* a list of salads with ingredients 
	*/
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
