package game.model;

import javafx.beans.property.SimpleIntegerProperty;

public class SnakePartModel {
	
	private SimpleIntegerProperty x = new SimpleIntegerProperty();
	private SimpleIntegerProperty y = new SimpleIntegerProperty();
	
	/**
	 * Creates a new snake part for the snake.
	 * @param x the x coordinate of the new snake part.
	 * @param y the y coordinate of the new snake part.
	 */
	public SnakePartModel(int x, int y)
	{
		this.x.set(x);
		this.y.set(y);
	}
	
	public SimpleIntegerProperty getYProperty() {
		return y;
	}

	public SimpleIntegerProperty getXProperty() {
		return x;
	}
	
	public int getX(){
		return x.get();
	}
	
	public int getY(){
		return y.get();
	}
	
	public void setY(int value)
	{
		y.set(value);
	}
	
	public void setX(int value)
	{
		x.set(value);
	}

}
