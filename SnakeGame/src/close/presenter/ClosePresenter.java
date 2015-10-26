package close.presenter;

import close.view.CloseView;
import javafx.stage.Stage;
import welcome.WelcomeScene;

public class ClosePresenter {
	
	public ClosePresenter(CloseView view, Stage stage)
	{
		view.getBackButton().setOnAction(e-> returnToWelcomeWindow(stage));
		view.getExitButton().setOnAction(e-> closeGame(stage));
	}

	private void closeGame(Stage stage) {
		stage.close();
	}

	private void returnToWelcomeWindow(Stage stage) {
		(new WelcomeScene()).show(stage);
	}

}
