package multiplayer.presenter;

import javafx.stage.Stage;
import multiplayer.view.MultiplayerView;
import welcome.WelcomeScene;

public class MultiplayerPresenter {
	
	public MultiplayerPresenter(MultiplayerView view, Stage stage)
	{
		view.getBackButton().setOnAction(e->returnToWelcomeWindow(stage));
	}

	private void returnToWelcomeWindow(Stage stage) {
		(new WelcomeScene()).show(stage);
	}
}
