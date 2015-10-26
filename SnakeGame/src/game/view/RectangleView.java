package game.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleView {

	private int width;
	private int height;
	private Color color;
	private Rectangle rectangle;
	
	public RectangleView(int width, int height, Color rectColor)
	{
		this.width = width;
		this.height = height;
		this.color = rectColor;
		
		this.rectangle = new Rectangle(this.width, this.height);
		this.rectangle.setFill(color);
	}
	
	public Rectangle getRectangle()
	{
		return rectangle;
	}

}
