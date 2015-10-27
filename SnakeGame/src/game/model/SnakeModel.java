package game.model;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

/**

 * Created by Duy on 20.10.2015.

 */

public class SnakeModel {

	private Direction direction;
	

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
	
}
