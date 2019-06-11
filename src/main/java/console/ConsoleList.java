package console;

import java.io.*;
import java.util.*;

import exception.ExceptionMinCaloryFilterLessZero;


public class ConsoleList {

	/**
	*  display list of salads
	*/
	public static void listOfSalads(){
		PrintMenu.listOfSalads();
	}
    
	/**
	* method of choosing how to display
	* a list of salads with ingredients 
	 * @throws ExceptionMinCaloryFilterLessZero 
	*/
	public static void listOfIngredients() throws IOException, ExceptionMinCaloryFilterLessZero {
		final Scanner sc = new Scanner(System.in);
        System.out.print("Enter x ");
        try {
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
        	//sc.close();
        }
        catch(InputMismatchException e) {
        	ListFromEnter.FromEnter();
        }
	}  
      

	
	public static void listOfOrderCalories() throws IOException {
		OrderCalories.OrderByCalories();
	}
}
