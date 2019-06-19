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
        		ListFromEnter.fromEnter();
        			break;			
        	case 2: 
        		ListFromFile.fromFile();
					break;
        	default:
        		ListFromEnter.fromEnter();
					break;
        	}
        }
        catch(InputMismatchException e) {
        	ListFromEnter.fromEnter();
        }
	}  
      
	
	/**
	* method print list ingredients of order calories
	* @throws IOException 
	*/
	public static void listOfOrderCalories() throws IOException {
		OrderCalories.orderByCalories();
	}
}
