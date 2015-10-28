package game.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**

 * Created by Duy on 20.10.2015.

 */

public class SnakeModel {

	private Direction direction;
	private SimpleIntegerProperty x = new SimpleIntegerProperty();
	private SimpleIntegerProperty y = new SimpleIntegerProperty();
	private SimpleBooleanProperty snakeGrow = new SimpleBooleanProperty(false);
	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	public SnakeModel()
	{
		this.setDirection(Direction.RIGHT);
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
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
	
	public void increaseValue()
	{
		if(direction == Direction.UP)
		{
			y.set(y.get() -1);
		}
		else if(direction == Direction.DOWN){
			y.set(y.get() +1);
		}
		else if(direction == Direction.LEFT)
		{
			x.set(x.get()-1);
		}
		else if (direction == Direction.RIGHT)
		{
			x.set(x.get() +1);
		}
	}
	
	public Boolean getSnakeGrow()
	{
		return snakeGrow.get();
	}
	
	public SimpleBooleanProperty getBooleanProperty()
	{
		return snakeGrow;
	}
	
	public void setSnakeGrow(boolean grow)
	{
		snakeGrow.set(grow);
	}
	
	public int snakeGrowth()
	{
		if(direction == Direction.UP)
		{
			return -1;
		}
		else if(direction == Direction.DOWN){
			return 1;
		}
		else if(direction == Direction.LEFT)
		{
			return -1;
		}
		else if (direction == Direction.RIGHT)
		{
			return 1;
		}
		
		return 0;
	}
		
}
