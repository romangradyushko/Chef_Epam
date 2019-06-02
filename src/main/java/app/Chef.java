package app;

import console.ConsoleList;
import console.ListFromBinaryFile;

/**
* The main class
* @author RomanGradyushko
*/
public class Chef {
	public static void main(final String[] args) throws Exception {
		ConsoleList.listOfSalads();
		ConsoleList.listOfIngredients();
		ConsoleList.listOfOrderCalories();
		ListFromBinaryFile.FromFile();
	}
}
