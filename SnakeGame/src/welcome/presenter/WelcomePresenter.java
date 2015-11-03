package welcome.presenter;

import close.CloseScene;
import game.GameScene;
import highscore.HighscoreScene;
import javafx.stage.Stage;
import multiplayer.MultiplayerOptionsScene;
import options.OptionsScene;
import welcome.view.WelcomeView;

public class WelcomePresenter {
	
	private Stage stage;
	private WelcomeView view;
	
	public WelcomePresenter(WelcomeView view,Stage stage)
	{
		this.view = view;
		this.stage = stage;
		
		view.getStartButton().setOnAction(e->showGameScene());
		view.getMultiplayerButton().setOnAction(e->showMultiplayerScene());
		view.getOptionsButton().setOnAction(e->showOptionsScene());
     	view.getHighscoreButton().setOnAction(e-> showHighscoreScene ());
		view.getExitButton().setOnAction(e->exitGame());
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
	
	private void exitGame()
	{
		view.stopRotation();
		(new CloseScene()).show(stage);
	}
	
	

}
