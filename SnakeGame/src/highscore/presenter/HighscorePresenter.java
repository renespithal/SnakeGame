package highscore.presenter;

import highscore.view.HighscoreView;
import javafx.stage.Stage;
import welcome.WelcomeScene;

public class HighscorePresenter {
	
	private HighscoreView view;
	private Stage stage;
		
	public HighscorePresenter(HighscoreView view, Stage stage)
	{
		this.view = view;
		this.stage = stage;
		view.getBackButton().setOnAction(e->returnToWelcomeWindow());
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

	private void returnToWelcomeWindow() {
		view.stopRotation();
		(new WelcomeScene()).show(stage);
	}
}


