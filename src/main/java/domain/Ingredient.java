package domain;

import domain.Vegetable;

public class Ingredient extends Vegetable{
	private double weight;
	
	public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public Ingredient() {}

    public Ingredient(String name, int calory, double weight) {
        super(name, calory);
        this.weight = weight;
    }

    double getTotalCalory(){
    	return getCalory() * getWeight() / 100;
    };
}
