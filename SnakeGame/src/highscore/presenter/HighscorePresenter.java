package highscore.presenter;

import game.GameScene;
import javafx.stage.Stage;
import highscore.view.HighscoreView;
import welcome.WelcomeScene;
import highscore.model.HighscoreModel;

public class HighscorePresenter {
		
	public HighscorePresenter(HighscoreView view, Stage stage)
	{
		view.getBackButton().setOnAction(e->returnToWelcomeWindow(stage));
		//view.playButton().setOnAction(e-> returnToGameScene(stage));
		//view.clearButton().setOnAction(e-> clearTable());
		/*view.saveButton().setOnAction(e-> saveTable());*/
	}
	
	/*public void saveTable(){
		view.getValue();
	}
	*/

	/*public void clearTable(){
		highscore.clear();
		player.clear();
	}*/

	/*public void returnToGameScene(Stage stage){
		(new GameScene()).show(stage);
	}*/

	private void returnToWelcomeWindow(Stage stage) {
		(new WelcomeScene()).show(stage);
	}
}


