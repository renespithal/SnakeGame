package welcome.presenter;

import close.CloseScene;
import game.GameScene;
import highscore.HighscoreScene;
import javafx.stage.Stage;
import multiplayer.MultiplayerScene;
import options.OptionsScene;
import welcome.view.WelcomeView;

public class WelcomePresenter {
	
	public WelcomePresenter(WelcomeView view,Stage stage)
	{
		view.getStartButton().setOnAction(e->showGameScene(view,stage));
		view.getMultiplayerButton().setOnAction(e->showMultiplayerScene(view,stage));
		view.getOptionsButton().setOnAction(e->showOptionsScene(view,stage));
     	view.getHighscoreButton().setOnAction(e-> showHighscoreScene (view,stage));
		view.getExitButton().setOnAction(e->exitGame(view,stage));
	}

	private void showGameScene(WelcomeView view,Stage stage) 
	{
		view.stopRotation();
		(new GameScene()).show(stage);
	}
	
	private void showMultiplayerScene(WelcomeView view,Stage stage)
	{	
		view.stopRotation();
		(new MultiplayerScene()).show(stage);
	}
	
	private void showOptionsScene(WelcomeView view,Stage stage)
	{
		view.stopRotation();
		(new OptionsScene()).show(stage);
	}
	
	private void showHighscoreScene (WelcomeView view,Stage stage)
	{
		view.stopRotation();
		(new HighscoreScene()).show(stage);
	}
	
	private void exitGame(WelcomeView view,Stage stage)
	{
		view.stopRotation();
		(new CloseScene()).show(stage);
	}
	
	

}
