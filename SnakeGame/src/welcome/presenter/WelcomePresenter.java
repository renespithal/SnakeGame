package welcome.presenter;


import game.GameScene;
import highscore.HighscoreScene;
import javafx.stage.Stage;
import multiplayer.MultiplayerOptionsScene;
import options.OptionsScene;
import welcome.view.WelcomeView;

public class WelcomePresenter {
	
	private Stage stage;
	private WelcomeView view;
	
	/**
	 * Creates the presenter for the welcome window.
	 * @param view the created view
	 * @param stage the stage on which it is shown
	 */
	public WelcomePresenter(WelcomeView view,Stage stage)
	{
		this.view = view;
		this.stage = stage;
		
		view.getStartButton().setOnAction(e->showGameScene());
		view.getMultiplayerButton().setOnAction(e->showMultiplayerScene());
		view.getOptionsButton().setOnAction(e->showOptionsScene());
     	view.getHighscoreButton().setOnAction(e-> showHighscoreScene ());
		view.getExitButton().setOnAction(e->closeGame());

	}

	private void closeGame() {
		stage.close();
	}

	private void showGameScene() 
	{
		view.stopRotation();
		(new GameScene()).show(stage);
	}
	
	private void showMultiplayerScene()
	{	
		view.stopRotation();
		(new MultiplayerOptionsScene()).show(stage);
	}
	
	private void showOptionsScene()
	{
		view.stopRotation();
		(new OptionsScene()).show(stage);
	}
	
	private void showHighscoreScene ()
	{
		view.stopRotation();
		(new HighscoreScene()).show(stage);
	}


}
