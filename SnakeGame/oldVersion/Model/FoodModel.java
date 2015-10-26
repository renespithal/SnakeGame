package Model;

import View.CircleView;
import javafx.scene.paint.Color;

public class FoodModel {

	private int blockSize;
	private int screenWidth;
	private int screenHeight;
	
	private CircleView food;
	
	public FoodModel(int blockSize, int screenWidth, int screenHeight)
	{
		this.setBlockSize(blockSize);
		this.setScreenWidth(screenWidth);
		this.setScreenHeight(screenHeight);
		
		food = new CircleView(blockSize/2, Color.RED);
		food.setTranslateX((int) (Math.random()*(screenWidth - blockSize/2)) / blockSize/2 * blockSize/2);
		food.setTranslateY((int) (Math.random() * (screenHeight - blockSize / 2)) / blockSize / 2 * blockSize / 2);

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
		food.getCircle().setTranslateX((int) posY); 
		
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}


}
