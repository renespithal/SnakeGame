package options.presenter;

import javafx.stage.Stage;
import options.Options;
import options.view.OptionsView;
import welcome.WelcomeScene;

public class OptionsPresenter {
	
	private final static String slow ="Slow";
	private final static String normal ="Normal";
	private final static String fast ="Fast";
	private Stage stage;
	private OptionsView view;
	
	public OptionsPresenter(OptionsView view,Stage stage )
	{
		this.stage = stage;
		this.view = view;
		
		view.getBackButton().setOnAction(e-> returnToWelcomeWindow());
		view.getSpeedBox().setOnAction(e->setSpeed());
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


	private void returnToWelcomeWindow() {
		view.stopRotation();
		(new WelcomeScene()).show(stage);
	}

}
