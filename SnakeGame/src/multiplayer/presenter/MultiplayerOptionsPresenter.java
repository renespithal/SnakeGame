package multiplayer.presenter;

import javafx.stage.Stage;
import multiplayer.localMultiplayer.LocalMultiplayerScene;
import multiplayer.view.MultiplayerOptionsView;
import welcome.WelcomeScene;

public class MultiplayerOptionsPresenter {
	
	private MultiplayerOptionsView view;
	private Stage stage;
	
	/**
	 * Creates the presenter for the multiplayer options.
	 * @param view the created view
	 * @param stage the stage
	 */
	public MultiplayerOptionsPresenter(MultiplayerOptionsView view,Stage stage)
	{
		this.view = view;
		this.stage = stage;
		activateEvents();
	}

	private void activateEvents() {
		view.getNormalButton().setOnAction(e->startMultiplayer(true));
		view.getSurvivalButton().setOnAction(e->startMultiplayer(false));
		view.getBackButton().setOnAction(e->backToWelcomeWindow());
		
	}

	private void backToWelcomeWindow() {
		view.stopRotation();
		(new WelcomeScene()).show(stage);
	}

	private void startMultiplayer(boolean normalMode) {
		view.stopRotation();
		(new LocalMultiplayerScene(normalMode)).show(stage);
	}

}
