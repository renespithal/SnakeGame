package game.model;

import View.RectangleView;
import javafx.scene.paint.Color;

/**
 * Created by Rene on 20.10.2015.
 */
public class YinYangFoodModel {

	private RectangleView yin;
	private int blockSize = 20;
	private int screenWidth = 500;
	private int screenHeight = 500;

	public YinYangFoodModel() {

		yin = new RectangleView(blockSize, blockSize, Color.ORANGE);
		yin.getRectangle().setTranslateX((int) (Math.random() * (screenWidth - blockSize)) / blockSize * blockSize);
		yin.getRectangle().setTranslateY((int) (Math.random() * (screenHeight - blockSize)) / blockSize * blockSize);
	}

	public RectangleView getYin() {
		return yin;
	}
	
	public int getXPos()
	{
		return (int)yin.getRectangle().getTranslateX();
	}
	
	public int getYPos()
	{
		return (int)yin.getRectangle().getTranslateY();
	}
	
	public void setXPos(int xPos)
	{
		yin.getRectangle().setTranslateX(xPos);
	}
	
	public void setYPos(int yPos)
	{
		yin.getRectangle().setTranslateY(yPos);
	}

}
