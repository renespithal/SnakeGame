package Model;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import Model.SnakeModel;
import javafx.scene.image.Image;

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
		food = new Circle(blockSize/2);
		food.setFill(Color.RED);
		food.setTranslateX((int) (Math.random()*(screenWidth - blockSize/2)) / blockSize/2 * blockSize/2);
		food.setTranslateY((int) (Math.random() * (screenHeight - blockSize / 2)) / blockSize / 2 * blockSize / 2);

	}


	
	public Circle getCircle()
	{
		return food;
	}

	public void ConsumeFood() {
		if (snake.getXPos() == food.getTranslateX() && snake.getYPos() == food.getTranslateY()) {

			food.setTranslateX((int) (Math.random() * (screenWidth - blockSize)) / blockSize * blockSize);

			food.setTranslateY((int) (Math.random() * (screenHeight - blockSize)) / blockSize * blockSize);


		}
	}



}
