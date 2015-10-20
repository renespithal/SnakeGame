package Model;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class SnakeModel {

	private int blockSize;
	Circle food;

	
	private Color snakeColor;
	Rectangle head;
	
	private ObservableList<Node> snake;
	
	public SnakeModel()
	{
		this.snakeColor = Color.GREEN;
		
		Group snakeBody = new Group();

		head = new Rectangle(20,20);
		head.setTranslateX(40);
		head.setTranslateY(40);
		head.setFill(snakeColor);
		
		snake = snakeBody.getChildren();
		snake.add(head);
		
		
		
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
	
	public int getXPos()
	{
		return (int) head.getTranslateX();
	}
	
	public int getYPos()
	{
		return (int) head.getTranslateY();
	}
	

}
