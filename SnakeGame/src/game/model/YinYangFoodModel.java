package game.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Rene on 20.10.2015.
 */
public class YinYangFoodModel {

	private SimpleIntegerProperty x = new SimpleIntegerProperty();
	private SimpleIntegerProperty y = new SimpleIntegerProperty();
	private SimpleBooleanProperty visible = new SimpleBooleanProperty(false); 
		
	public YinYangFoodModel()
	{
		generateRandomPosition();
	}
	public void generateRandomPosition() {
		x.set((int)(Math.floor(Math.random()*24+1)));
		y.set((int)(Math.floor(Math.random()*24+1)));
		
	}
	public void deletePosition(){
		x.set(-20);
		y.set(-20);
	}
	public SimpleIntegerProperty getXProperty() {
		return x;
	}
	
	public SimpleIntegerProperty getYProperty() {
		return y;
	}
	
	public int getX()
	{
		return x.get();
	}
	
	public int getY()
	{
		return y.get();
	}
	
	public void setXProperty(SimpleIntegerProperty x) {
		this.x = x;
	}
	
	public void setYProperty(SimpleIntegerProperty y) {
		this.y = y;
	}
	
	public SimpleBooleanProperty getVisibleProperty() {
		return visible;
	}
	
	public void setVisible(boolean isVisible)
	{
		visible.set(isVisible);
	}
	
	public Boolean getVisible()
	{
		return visible.get();
	}
}
