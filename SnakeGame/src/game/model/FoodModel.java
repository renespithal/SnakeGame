package game.model;

import javafx.beans.property.SimpleIntegerProperty;

public class FoodModel {
	
	private SimpleIntegerProperty x = new SimpleIntegerProperty();
	private SimpleIntegerProperty y = new SimpleIntegerProperty();
	
	public FoodModel()
	{
		generateRandomPosition();
	}
	public void generateRandomPosition() {
		x.set((int)(Math.floor(Math.random()*24)));
		y.set((int)(Math.floor(Math.random()*23)));

	}
	public SimpleIntegerProperty getXProperty() {
		return x;
	}
	
	public SimpleIntegerProperty getYProperty() {
		return y;
	}
	
	public void setXProperty(SimpleIntegerProperty x) {
		this.x = x;
	}
	
	public void setYProperty(SimpleIntegerProperty y) {
		this.y = y;
	}
	
	public int getX()
	{
		return x.get();
	}

	public int getY()
	{
		return y.get();
	}

}
