package Model;

import View.RectangleView;
import javafx.scene.paint.Color;

/**
 * Created by Rene on 20.10.2015.
 */
public class YinYangFoodModel {

	private RectangleView yin;
	private int blockSize;
	private int screenWidth;
	private int screenHeight;

	public YinYangFoodModel(int blockSize, int screenWidth, int screenHeight) {

		this.setBlockSize(blockSize);
		this.setScreenWidth(screenWidth);
		this.setScreenHeight(screenHeight);

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
