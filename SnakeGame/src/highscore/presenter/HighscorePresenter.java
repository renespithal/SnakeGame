package highscore.presenter;

import highscore.view.HighscoreView;
import javafx.stage.Stage;
import welcome.WelcomeScene;

public class HighscorePresenter {
		
	public HighscorePresenter(HighscoreView view, Stage stage)
	{
		view.getBackButton().setOnAction(e->returnToWelcomeWindow(view,stage));
		//view.playButton().setOnAction(e-> returnToGameScene(stage));
		//view.clearButton().setOnAction(e-> clearTable());
		/*view.saveButton().setOnAction(e-> saveTable());*/
	}
	
	/*public void saveTable(){
		view.getValue();
	}
	*/

	/*public void clearTable(){
		highscoreTable.set
	}

	/*public void returnToGameScene(Stage stage){
		(new GameScene()).show(stage);
	}*/

	private void returnToWelcomeWindow(HighscoreView view,Stage stage) {
		view.stopRotation();
		(new WelcomeScene()).show(stage);
	}
}


