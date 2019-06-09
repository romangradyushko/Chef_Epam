package console;

import java.util.List;

import domain.Salad;
import repository.SaladStorage;

public class PrintMenu {
	private static SaladStorage fs = new SaladStorage();
    private static List<Salad> salads = fs.read();

    /**
	* method for print menu of salads 
	*/
	public static void listOfSalads(){
        System.out.println("Menu");
        
        for (Salad salad : salads) {
        	System.out.println("Salad " + salad.getName() + 
        			" with total calory " + salad.getTotalCalory());     
        }
	}
}
