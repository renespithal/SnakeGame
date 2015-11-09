package game.model;

import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Duy on 20.10.2015.
 */

public class SnakeModel {

	private ObservableList<SnakePartModel> list = FXCollections.observableList(new LinkedList<SnakePartModel>());
	private SnakePartModel head;
	private Direction direction;
	
	/**
	 * Direction for the snake
	 * @author Duy
	 */
	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	/**
	 * Create a snake with standard direction right
	 * and place it on the scene with x and y coordinates
	 * @param x the x coordinate of the snake
	 * @param y the y coordinate of the snake
	 */
	public SnakeModel(int x,int y)
	{
		head = new SnakePartModel(x, y);
		direction = Direction.RIGHT;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	/**
	 * Set the snake movement
	 * @param direction where the snake should head
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	/**
	 * The new part of the snake is set on the last position of the snake.
	 * All the other snake parts are moved one position forward and the head,
	 * depends in which direction it moves, gets a new position.
	 */
	public void increaseValue()
	{
		int oldX = head.getX();
		int oldY = head.getY();
		
		if(direction == Direction.UP)
		{
			head.setY(head.getY() -1);
		}
		else if(direction == Direction.DOWN){
			head.setY(head.getY() +1);
		}
		else if(direction == Direction.LEFT)
		{
			head.setX(head.getX()-1);
		}
		else if (direction == Direction.RIGHT)
		{
			head.setX(head.getX() +1);
		}
		
		//Update the rest of the snake by iterating the list
		int tempX, tempY;
		for(SnakePartModel currentPart : list){
			tempX = currentPart.getX();
			tempY = currentPart.getY();
			
			currentPart.setX(oldX);
			currentPart.setY(oldY);
			
			oldX = tempX;
			oldY = tempY;
		}
	}
	
	public SnakePartModel getHead()
	{
		return head;
	}
	
	/**
	 * Adds a new part to the body of the snake.
	 */
	public void grow()
	{
		SnakePartModel tail = list.isEmpty() ? head : list.get(list.size()-1);
		list.add(new SnakePartModel(tail.getX(),tail.getY()));
	}
	
	public ObservableList<SnakePartModel> getList() {
		return list;
	}

}
