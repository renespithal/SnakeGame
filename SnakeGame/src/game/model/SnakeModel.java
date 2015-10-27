package game.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

/**

 * Created by Duy on 20.10.2015.

 */

public class SnakeModel {

	private Direction direction;
	private SimpleIntegerProperty x = new SimpleIntegerProperty();
	private SimpleIntegerProperty y = new SimpleIntegerProperty();
	

	Group snakeBody;
	
	private ObservableList<Node> snake;
	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	public SnakeModel()
	{
		this.setDirection(Direction.RIGHT);
		
		snakeBody = new Group();

		snake = snakeBody.getChildren();
		
		System.out.println("neue schlange");
		
		
	}

	public ObservableList<Node> getObservableList()
	{
		return snake;
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
	
}
