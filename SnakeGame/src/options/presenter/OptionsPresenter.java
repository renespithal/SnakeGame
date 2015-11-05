package options.presenter;

import javafx.stage.Stage;
import options.Options;
import options.view.OptionsView;
import welcome.WelcomeScene;

public class OptionsPresenter {
	
	private final static String slow ="Slow";
	private final static String normal ="Normal";
	private final static String fast ="Fast";
	private final static String green ="Green";
	private final static String red ="Red";
	private final static String blue ="Blue";
	private final static String yellow ="Yellow";
	private final static String black ="Black";

	private Stage stage;
	private OptionsView view;
	
	public OptionsPresenter(OptionsView view,Stage stage )
	{
		this.stage = stage;
		this.view = view;
		
		view.getBackButton().setOnAction(e-> returnToWelcomeWindow());
		view.getSpeedBox().setOnAction(e->setSpeed());
		view.getColorBox().setOnAction(e->setColor());
	}
	
	private void setSpeed()
	{
		String value = view.getSpeedBox().getValue();
		if(value.equals(slow))
		{
			Options.speed = Options.SLOW;
		} else if(value.equals(normal))
		{
			Options.speed = Options.MEDIUM;
		}
		else if(value.equals(fast))
		{
			Options.speed = Options.FAST;
		}
	}
	
	private void setColor() {
		String value = view.getColorBox().getValue();
		if(value.equals(green))
		{
			Options.color = Options.GREEN;
		} else if(value.equals(red))
		{
			Options.color = Options.RED;
		}
		else if(value.equals(blue))
		{
			Options.color = Options.BLUE;
		}
		else if(value.equals(yellow))
		{
			Options.color = Options.YELLOW;
		}
		else if(value.equals(black))
		{
			Options.color = Options.BLACK;
		}
	}


	private void returnToWelcomeWindow() {
		view.stopRotation();
		(new WelcomeScene()).show(stage);
	}

}
