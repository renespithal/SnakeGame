package highscore.model;

import javafx.beans.property.IntegerProperty; 
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.*;


public class HighscoreModel {


private IntegerProperty highscoreValue = new SimpleIntegerProperty(0);
private StringProperty playername = new SimpleStringProperty();


	public HighscoreModel(){}

	/**
	 *
	 * @param name  the playername
	 * @param value the highscore value
	 */
	public HighscoreModel(String name, int value) {
		highscoreValue.set(value);
		playernameProperty().set(name);
	}

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

	public String getPlayername() {
		return playername.get();
	}

	public StringProperty playernameProperty() {
		return playername;
	}

	public IntegerProperty getValueProperty(){
		return highscoreValue;
	}
	
	
}
