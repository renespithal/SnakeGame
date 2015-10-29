package game.model;

import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**

 * Created by Duy on 20.10.2015.

 */

public class SnakeModel {

	private Direction direction;
	private ObservableList<SnakePartModel> list = FXCollections.observableList(new LinkedList<SnakePartModel>());
	private SnakePartModel head = new SnakePartModel(0,0);
	
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
	
	public void grow()
	{
		SnakePartModel tail = list.isEmpty() ? head : list.get(list.size()-1);
		list.add(new SnakePartModel(tail.getX(),tail.getY()));
	}
	
	public ObservableList<SnakePartModel> getList() {
		return list;
	}
}
