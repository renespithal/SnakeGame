package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OptionWindow{
	
	Stage stage;
	Button backButton;
	VBox vBox;
	Scene scene;
	
	public OptionWindow(Stage primaryStage)
	{
		stage = new Stage();
		backButton = new Button("back to menu");
		backButton.setOnAction(e->returnToWelcomeWindow());

		vBox = new VBox(backButton);
		scene = new Scene(vBox, 500,500);	
		
		stage.setScene(scene);
		stage.setTitle("Option");
	}
	
	protected void showGameStage()
	{
		stage.show();
	}
	
	private void closeGameWindow() {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}
	
	private void returnToWelcomeWindow()
	{
		closeGameWindow();
		WelcomeWindow welWin = new WelcomeWindow(stage);
		welWin.showWelcomeWindow();
	}

}
