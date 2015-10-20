package Model;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FoodModel {

	private Circle food;
	private ObservableList<Node> foodList;
	
	public FoodModel(int blocksize, int screenWidth, int screenHeight)
	{
		food = new Circle(blocksize);
		food.setFill(Color.RED);
		food.setTranslateX((int) (Math.random()*(screenWidth - blocksize)) / blocksize * blocksize);
		food.setTranslateY((int) (Math.random()*(screenHeight - blocksize)) / blocksize * blocksize);
		
		
	}
	
	public Circle getCircle()
	{
		return food;
	}
	
	
}
