package domain;

import domain.Vegetable;

public class Ingredient extends Vegetable{
	private double weight;
	private double price;
	private static final int GRAM_IN_KILOGRAM = 1000; 
	
	public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Ingredient() {}

    public Ingredient(String name, int calory, double weight) {
        super(name, calory);
        this.weight = weight;
    }

    double getTotalCalory(){
    	return getCalory() * getWeight() / 100;
    };
    
    double getTotalPrice(){
    	return getWeight() / GRAM_IN_KILOGRAM * price;
    };    
}
