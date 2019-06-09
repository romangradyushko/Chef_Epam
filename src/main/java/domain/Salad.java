package domain;

import java.io.Serializable;
import java.util.List;

public class Salad implements Serializable {
	private String name;
    private List<Ingredient> salad;

    public Salad() {}

    public Salad(String name, List<Ingredient> salad) {
        this.name = name;
        this.setSalad(salad);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<Ingredient> getSalad() {
		return salad;
	}

	public void setSalad(List<Ingredient> salad) {
		this.salad = salad;
	}
    
	public double getTotalCalory(){
		double totalcalory = 0;
        for (Ingredient ingredient : this.salad) {
        	totalcalory += (double) ingredient.getTotalCalory();
        }
        return totalcalory;
    }; 
    
}
