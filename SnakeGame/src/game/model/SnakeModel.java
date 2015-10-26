package game.model;

import View.RectangleView;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**

 * Created by Duy on 20.10.2015.

 */

public class SnakeModel {

	private Direction direction;
	

	RectangleView head;
	Group snakeBody;
	
	private ObservableList<Node> snake;
	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	public SnakeModel()
	{
		this.setDirection(Direction.RIGHT);
		
		snakeBody = new Group();

		head = new RectangleView(20,20,Color.GREEN);
		snake = snakeBody.getChildren();
		snake.add(head.getRectangle());
		
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
	
	public int getXPos()
	{
		return (int)head.getRectangle().getTranslateX();
	}
	
	public int getYPos()
	{
		return (int)head.getRectangle().getTranslateY();
	}
	
	public void setXPos(int xPos)
	{
		head.getRectangle().setTranslateX(xPos);
	}
	
	public void setYPos(int yPos)
	{
		head.getRectangle().setTranslateY(yPos);
	}
	
	public RectangleView getHead()
	{
		return head;
	}
	
}
