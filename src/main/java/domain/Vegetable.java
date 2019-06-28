package domain;

import domain.Vegetable;

public abstract class Vegetable implements Comparable<Vegetable> {
	protected String name;
    protected int calory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalory() {
        return calory;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public Vegetable() {};

    public Vegetable(String name, int calory) {
        this.name = name;
        this.calory = calory;
    }	
    
    @Override
    public int compareTo(Vegetable vegetable) {
        if (vegetable == null) throw new NullPointerException("vegetable == null");
        return Integer.valueOf(calory).compareTo(vegetable.getCalory());
    }
}

