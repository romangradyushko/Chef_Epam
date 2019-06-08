package controller;

import domain.Ingredient;

public class CaloryFilter implements Filter {
    private Integer minCalory;
    private Integer maxCalory;

    public CaloryFilter(final Integer minCalory, final Integer maxCalory) {
        /*if (minCalory < 0 || minCalory > maxCalory) {
            throw new RuntimeException("entered incorrect data");
        }*/
    	
        this.minCalory = minCalory;
        this.maxCalory = maxCalory;
    }

    public boolean isSatisfy(Ingredient ingredient) {
        Integer calories = ingredient.getCalory();
        return minCalory <= calories && calories <= maxCalory;
    }
}
