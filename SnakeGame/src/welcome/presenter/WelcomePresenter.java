package welcome.presenter;

import close.CloseScene;
import game.GameScene;
import javafx.stage.Stage;
import multiplayer.MultiplayerScene;
import options.OptionsScene;
import welcome.view.WelcomeView;

public class WelcomePresenter {
	
	public WelcomePresenter(WelcomeView view,Stage stage)
	{
		view.getStartButton().setOnAction(e->showGameScene(stage));
		view.getMultiplayerButton().setOnAction(e->showMultiplayerScene(stage));
		view.getOptionsButton().setOnAction(e->showOptionsScene(stage));
//		view.getHighscoreButton().setOnAction(e-> showHighscoreScene (stage));
		view.getExitButton().setOnAction(e->exitGame(stage));
	}

	private void showGameScene(Stage stage) {
		(new GameScene()).show(stage);
	}
	
	private void showMultiplayerScene(Stage stage)
	{
		(new MultiplayerScene()).show(stage);
	}
	
	private void showOptionsScene(Stage stage)
	{
		(new OptionsScene()).show(stage);
	}
	
//	private void showHighscoreScene (Stage stage)
//	{
//		(new HighscoreScene()).show(stage);
//	}
	
	private void exitGame(Stage stage)
	{
		(new CloseScene()).show(stage);
	}
	
	

}
