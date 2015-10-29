package highscore.model;

import javafx.beans.property.IntegerProperty; 
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

public class HighscoreModel {
	
private SimpleIntegerProperty highscoreValue = new SimpleIntegerProperty(0);

//private StringProperty name = new StringProperty();

	
	public void increaseValue(){
		highscoreValue.set(highscoreValue.get()+2);
	}
	
	public void increaseSpecialValue()
	{
		highscoreValue.set(highscoreValue.get()+10);
	}
	
	public int getValue(){
		return highscoreValue.get();
	}
	
	/*public StringProperty strProperty() {
		//
	}*/
	       
	
	
	public IntegerProperty getValueProperty(){
		return highscoreValue;
	}
	
	
}
