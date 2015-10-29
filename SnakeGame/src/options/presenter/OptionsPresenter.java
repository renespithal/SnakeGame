package options.presenter;

import javafx.stage.Stage;
import options.model.SpeedSettingModel;
import options.view.OptionsView;
import welcome.WelcomeScene;

public class OptionsPresenter {
	
	private final static String slow ="Slow";
	private final static String normal ="Normal";
	private final static String fast ="Fast";
	
	public OptionsPresenter(SpeedSettingModel model,OptionsView view,Stage stage )
	{
		view.getBackButton().setOnAction(e-> returnToWelcomeWindow(stage));
		model.setSpeed(model.getMedium());
		view.getSpeedBox().setOnAction(e->test(model,view));
	}
	
	private void test(SpeedSettingModel model,OptionsView view)
	{
		String value = view.getSpeedBox().getValue();
		if(value.equals(slow))
		{
			model.setSpeed(model.getSlow());
		} else if(value.equals(normal))
		{
			model.setSpeed(model.getMedium());
		}
		else if(value.equals(fast))
		{
			model.setSpeed(model.getFast());
		}
		System.out.println(model.getSpeed());
	}

	private void returnToWelcomeWindow(Stage stage) {
		(new WelcomeScene()).show(stage);
	}

}
