package highscore.presenter;

import javafx.stage.Stage;
import highscore.view.HighscoreView;
import welcome.WelcomeScene;
import highscore.model.HighscoreModel;

public class HighscorePresenter {
		
	public HighscorePresenter(HighscoreView view, Stage stage)
	{
		view.getBackButton().setOnAction(e->returnToWelcomeWindow(stage));
		//view.clearButton().setOnAction(e-> clearTable());
		view.saveButton().setOnAction(e-> saveTable());
	}
	
	public void saveTable(){
		//kommt noch was rein
	}
	
	/*public void clearTable(){
		view.name.setText(null);
		view.txtname.setText(null);
	}*/
	
	private void returnToWelcomeWindow(Stage stage) {
		(new WelcomeScene()).show(stage);
	}
}


