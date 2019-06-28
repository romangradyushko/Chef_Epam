package logic;

import domain.Ingredient;
import exception.ExceptionMinCaloryFilterLessZero;
import exception.ExceptionCaloryFilterMaxLessMin;


public class CaloryFilter implements Filter {
    private Integer minCalory;
    private Integer maxCalory;
    
    /**
	* method set boundary calory
	* @param minCalory, maxCalory
	*/
    public CaloryFilter(final Integer minCalory, final Integer maxCalory) {
        try {
        	if (minCalory < 0) {
        		throw new ExceptionMinCaloryFilterLessZero("Calory can't be negative");
        	}  else if (minCalory > maxCalory) {
        		throw new ExceptionCaloryFilterMaxLessMin("Max calory can't be less than min calory");
        	}
        	else {
            	this.minCalory = minCalory;
                this.maxCalory = maxCalory;
            }
        }
        catch(ExceptionMinCaloryFilterLessZero e) {
        	System.out.println("\n Calory can't be negative. Now minCalory = 0");
        	this.minCalory = 0;
        	this.maxCalory = maxCalory;
        }
        catch(ExceptionCaloryFilterMaxLessMin e) {
        	System.out.println("\n Max calory can't be less than min calory. Now minCalory = 0, maxCalory = 1000");
        	this.minCalory = 0;
        	this.maxCalory = 1000;
        }
    }

    /**
	* method check if ingredient is satisfy 
	* @param ingredient
	* @return true/false
	*/
    public boolean isSatisfy(Ingredient ingredient) {
        Integer calories = ingredient.getCalory();
        return minCalory <= calories && calories <= maxCalory;
    }
}
