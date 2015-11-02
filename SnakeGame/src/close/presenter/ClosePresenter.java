package close.presenter;

import close.view.CloseView;
import javafx.stage.Stage;
import welcome.WelcomeScene;

public class ClosePresenter {
	
	private CloseView view;
	private Stage stage;
	
	public ClosePresenter(CloseView view, Stage stage)
	{
		this.view = view;
		this.stage = stage;
		view.getBackButton().setOnAction(e-> returnToWelcomeWindow());
		view.getExitButton().setOnAction(e-> closeGame());
	}

	private void closeGame() {
		stage.close();
	}

	private void returnToWelcomeWindow() {
		(new WelcomeScene()).show(stage);
	}

}
