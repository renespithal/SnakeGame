package multiplayer.presenter;

import javafx.stage.Stage;
import multiplayer.view.MultiplayerView;
import welcome.WelcomeScene;

public class MultiplayerPresenter {
	
	private MultiplayerView view;
	private Stage stage;
	
	public MultiplayerPresenter(MultiplayerView view, Stage stage)
	{
		this.view = view;
		this.stage = stage;
		view.getBackButton().setOnAction(e->returnToWelcomeWindow());
	}

	private void returnToWelcomeWindow() {
		(new WelcomeScene()).show(stage);
	}
}
