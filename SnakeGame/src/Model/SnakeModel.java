package Model;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SnakeModel {
	
	private Color snakeColor;
	private int xPos;
	private int yPos;
	
	private ObservableList<Node> snake;
	
	public SnakeModel()
	{
		this.snakeColor = Color.GREEN;
		
		Group snakeBody = new Group();
		snakeBody.setTranslateX(1);
		snakeBody.setTranslateY(1);
		
		Rectangle head = new Rectangle(20,20);
		head.setTranslateX(1);
		head.setTranslateY(1);
		head.setFill(snakeColor);
		
		snake = snakeBody.getChildren();
		snake.add(head);
		
	}
	
	public ObservableList<Node> getObservableList()
	{
		return snake;
	}
	

}
