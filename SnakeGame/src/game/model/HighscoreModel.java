package game.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class HighscoreModel {
private SimpleIntegerProperty highscoreValue = new SimpleIntegerProperty(0);
	
	public void increaseValue(){
		highscoreValue.set(highscoreValue.get()+1);
	}
	
	public void increaseSpecialValue()
	{
		highscoreValue.set(highscoreValue.get()+5);
	}
	
	public int getValue(){
		return highscoreValue.get();
	}
	
	public IntegerProperty getValueProperty(){
		return highscoreValue;
	}

}
