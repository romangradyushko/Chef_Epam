package app;

import collectionTest.ArrayvsLinked;
import console.ConsoleList;
import console.IngredientsFromFile;
import console.ListFromBinaryFile;
import logic.DeleteFromDataBase;
import logic.FilterByCaloriesDataBase;
import logic.InsertIntoDataBase;
import logic.UpdateDataBase;
import xml.SaladXmlReader;

/**
* The main class
* @author RomanGradyushko
*/
public class Chef {
	
	/**
	* main method 
	* @throws Exception
	*/
	public static void main(final String[] args) throws Exception {
		ArrayvsLinked.compare();
		IngredientsFromFile.readIngredient();
		ConsoleList.listOfSalads();
		ConsoleList.listOfIngredients();
		ConsoleList.listOfOrderCalories();
		ListFromBinaryFile.FromFile();
		SaladXmlReader.read(".\\src\\main\\resources\\Salad.xml");
		FilterByCaloriesDataBase.filterByCalories();
		InsertIntoDataBase.insertIntoDataBase();
		DeleteFromDataBase.deleteFromDataBase();
		UpdateDataBase.updateDataBase();
	}
}
