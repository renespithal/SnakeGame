package options.presenter;

import javafx.stage.Stage;
import options.model.SpeedSettingModel;
import options.view.OptionsView;
import welcome.WelcomeScene;

public class OptionsPresenter {
	
	private final static String slow ="Slow";
	private final static String normal ="Normal";
	private final static String fast ="Fast";
	private Stage stage;
	private OptionsView view;
	private SpeedSettingModel model;
	
	public OptionsPresenter(SpeedSettingModel model,OptionsView view,Stage stage )
	{
		this.model = model;
		this.stage = stage;
		this.view = view;
		
		view.getBackButton().setOnAction(e-> returnToWelcomeWindow());
		model.setSpeed(model.getMedium());
		view.getSpeedBox().setOnAction(e->test());
	}
	
	private void test()
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

	private void returnToWelcomeWindow() {
		(new WelcomeScene()).show(stage);
	}

}
