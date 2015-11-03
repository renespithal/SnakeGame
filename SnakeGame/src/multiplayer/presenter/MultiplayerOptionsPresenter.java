package multiplayer.presenter;

import javafx.stage.Stage;
import multiplayer.MultiplayerScene;
import multiplayer.localMultiplayer.LocalMultiplayerScene;
import multiplayer.view.MultiplayerOptionsView;
import welcome.WelcomeScene;

public class MultiplayerOptionsPresenter {
	
	private MultiplayerOptionsView view;
	private Stage stage;
	
	public MultiplayerOptionsPresenter(MultiplayerOptionsView view,Stage stage)
	{
		this.view = view;
		this.stage = stage;
		activateEvents();
	}

	private void activateEvents() {
		view.getLocalButton().setOnAction(e->startLocalGame());
		view.getOnlineButton().setOnAction(e->startOnlineGame());
		view.getBackButton().setOnAction(e->backToWelcomeWindow());
		
	}

	private void backToWelcomeWindow() {
		(new WelcomeScene()).show(stage);
	}

	private void startOnlineGame() {
		(new MultiplayerScene()).show(stage);
	}

	private void startLocalGame() {
		(new LocalMultiplayerScene()).show(stage);
	}

}
