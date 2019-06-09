package app;


import console.ConsoleList;
import console.ListFromBinaryFile;
import exception.ExceptionMinCaloryFilterLessZero;
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
		ConsoleList.listOfSalads();
		ConsoleList.listOfIngredients();
		ConsoleList.listOfOrderCalories();
		ListFromBinaryFile.FromFile();
		SaladXmlReader.read(".\\src\\main\\java\\resources\\Salad.xml");
		FilterByCaloriesDataBase.filterByCalories();
		InsertIntoDataBase.insertIntoDataBase();
		DeleteFromDataBase.deleteFromDataBase();
		UpdateDataBase.updateDataBase();
	}
}
