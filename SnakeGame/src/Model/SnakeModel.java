package Model;

import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**

 * Created by Duy on 20.10.2015.

 */

public class SnakeModel {

	private int blockSize;
	private Direction direction;
	Circle food;

	
	private Color snakeColor;
	Rectangle head;
	Group snakeBody;
	
	private ObservableList<Node> snake;
	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	public SnakeModel()
	{
		this.setDirection(Direction.RIGHT);
		this.snakeColor = Color.GREEN;
		
		snakeBody = new Group();

		head = new Rectangle(20,20);
		head.setTranslateX(40);
		head.setTranslateY(40);
		head.setFill(snakeColor);
		snake = snakeBody.getChildren();
		snake.add(head);
		
		System.out.println("neue schlange");
		
		
	}

	public ObservableList<Node> getObservableList()
	{
		return snake;
	}
	
	public Rectangle getHead()
	{
		return head;
	}
	
	public void setXPos(int xPos)
	{
		head.setTranslateX(xPos);
	}
	
	public void setYPos(int yPos)
	{
		head.setTranslateY(yPos);
	}
	
	public DoubleProperty getXProperty()
	{
		return head.xProperty();
	}
	
	public DoubleProperty getYProperty()
	{
		return head.yProperty();
	}
	
	public int getXPos()
	{
		return (int)head.getTranslateX();
	}
	
	public int getYPos()
	{
		return (int)head.getTranslateY();
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	

}
