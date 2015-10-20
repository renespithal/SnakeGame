package Model;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

<<<<<<< HEAD



=======
>>>>>>> cf7ec27bfb65f145ac3989542c0e63f1ae771d1d
/**

 * Created by Duy on 20.10.2015.

 */

public class SnakeModel {

	private int blockSize;
	Circle food;

	
	private Color snakeColor;
	Rectangle head;
	Group snakeBody;
	
	private ObservableList<Node> snake;
	
	public SnakeModel()
	{
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
	
	public int getXPos()
	{
		return (int) head.getTranslateX();
	}
	
	public int getYPos()
	{
		return (int) head.getTranslateY();
	}
	

}
