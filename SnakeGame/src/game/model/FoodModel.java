package game.model;

import javafx.beans.property.SimpleIntegerProperty;

public class FoodModel {
	
	private SimpleIntegerProperty x = new SimpleIntegerProperty();
	private SimpleIntegerProperty y = new SimpleIntegerProperty();
	
	/**
	 * Create a food with random position.
	 */
	public FoodModel()
	{
		generateRandomPosition();
	}
	
	/**
	 * Generate random coordinates for the food.
	 */
	
	public void generateRandomPosition() {
		x.set((int)(Math.floor(Math.random()*23+1)));
		y.set((int)(Math.floor(Math.random()*23+1)));

	}
	public SimpleIntegerProperty getXProperty() {
		return x;
	}
	
	public SimpleIntegerProperty getYProperty() {
		return y;
	}
	
	public int getX()
	{
		return x.get();
	}

	public int getY()
	{
		return y.get();
	}

	public void setXProperty(SimpleIntegerProperty x) {
		this.x = x;
	}

	public void setYProperty(SimpleIntegerProperty y) {
		this.y = y;
	}

}
