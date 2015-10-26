package game.model;

import View.CircleView;
import javafx.scene.paint.Color;

public class FoodModel {

	private int blockSize = 20;
	private int screenWidth = 500;
	private int screenHeight = 500;;
	
	private CircleView food;
	
	public FoodModel()
	{		
		food = new CircleView(blockSize/2, Color.RED);
		generateRandomFood();

	}
	
	private void generateRandomFood()
	{
		int randomXPos = (int)(Math.random()*(screenWidth - blockSize/2)) / blockSize/2 * blockSize/2;
		int randomYPos = (int) (Math.random() * (screenHeight - blockSize / 2)) / blockSize / 2 * blockSize / 2;
		
		if(randomXPos <= 0-40 || randomXPos > 500 -40 || randomYPos <= 0-40 || randomYPos > 500-40 )
		{
			generateRandomFood();
		}
		
		food.setTranslateX(randomXPos);
		food.setTranslateY(randomYPos);
	}

	public CircleView getFood()
	{
		return food;
	}
	public int getTranslateX() {
		return (int) food.getCircle().getTranslateX();
	}

	public int getTranslateY() {
		return (int) food.getCircle().getTranslateY();
	}

	public void setTranslateX(int posX) {
		food.getCircle().setTranslateX((int) posX); 
		
	}

	public void setTranslateY(int posY) {
		food.getCircle().setTranslateY((int) posY); 
		
	}

}
