package app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import console.ConsoleList;
import controller.CaloryFilter;
import controller.Filter;
import domain.Ingredient;
import domain.Salad;
import repository.SaladStorage;

public class Chef {
	public static void main(final String[] args) throws Exception {
		ConsoleList.listOfSalads();
		ConsoleList.listOfIngredients();
		ConsoleList.listOfOrderCalories();
		
	}

}
