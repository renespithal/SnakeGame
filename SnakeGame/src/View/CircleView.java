package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleView {
	
	private Circle circle;
	private Color color;
	private int blockSize;
	
	public CircleView(int blockSize, Color color)
	{
		this.setColor(color);
		this.blockSize = blockSize;
		setCircle(new Circle(this.blockSize, color));
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public void setTranslateX(int posX) {
		this.circle.setTranslateX((int) posX);
		
	}

	public void setTranslateY(int posY) {
		this.circle.setTranslateY((int) posY);
		
	}
	
	

}
