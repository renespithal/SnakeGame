package Model;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import Model.SnakeModel;

public class FoodModel {


	SnakeModel snake = new SnakeModel();
	Rectangle head;


	private int blockSize;
	private int screenWidth;
	private int screenHeight;

	private Circle food;

	private ObservableList<Node> foodList;
	
	public FoodModel(int blockSize, int screenWidth, int screenHeight)
	{
		food = new Circle(blockSize);
		food.setFill(Color.RED);
		food.setTranslateX((int) (Math.random()*(screenWidth - blockSize)) / blockSize * blockSize);
		food.setTranslateY((int) (Math.random()*(screenHeight - blockSize)) / blockSize * blockSize);
		
		
	}

	
	public Circle getCircle()
	{
		return food;
	}

	public void ConsumeFood() {
		if (head.getTranslateX() == food.getTranslateX() && head.getTranslateY() == food.getTranslateY()) {

			food.setTranslateX((int) (Math.random() * (screenWidth - blockSize)) / blockSize * blockSize);

			food.setTranslateY((int) (Math.random() * (screenHeight - blockSize)) / blockSize * blockSize);
		}
	}



}
