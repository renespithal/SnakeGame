package highscore.model;

import javafx.beans.property.IntegerProperty; 
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.*;


public class HighscoreModel {


private IntegerProperty highscoreValue = new SimpleIntegerProperty(0);
private StringProperty playername = new SimpleStringProperty();


	public HighscoreModel(){}

	public HighscoreModel(String name, int value) {
		highscoreValue.set(value);
		playernameProperty().set(name);
	}

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

	public String getPlayername() {
		return playername.get();
	}

	public StringProperty playernameProperty() {
		return playername;
	}
	
	/*public StringProperty strProperty() {
		//
	}*/
	
	
	public IntegerProperty getValueProperty(){
		return highscoreValue;
	}
	
	
}
