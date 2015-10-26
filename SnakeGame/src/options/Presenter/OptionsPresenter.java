package options.Presenter;

import javafx.stage.Stage;
import options.view.OptionsView;
import welcome.WelcomeScene;

public class OptionsPresenter {
	
	public OptionsPresenter(OptionsView view,Stage stage )
	{
		view.getBackButton().setOnAction(e-> returnToWelcomeWindow(stage));
	}

	private void returnToWelcomeWindow(Stage stage) {
		(new WelcomeScene()).show(stage);
	}

}
