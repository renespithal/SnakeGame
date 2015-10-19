package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SnakeGameWindow {
	
	Stage stage;
	Button backButton;
	VBox vBox;
	Scene scene;
	
	public SnakeGameWindow(Stage primaryStage)
	{
		stage = new Stage();
		backButton = new Button("Back");
		backButton.setOnAction(e->returnToWelcomeWindow());

		vBox = new VBox(backButton);
		scene = new Scene(vBox, 500,500);	
		
		stage.setScene(scene);
		stage.setTitle("Snake");
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
