package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultiplayerWindow{
	
	Stage stage;
	Button backButton;
	VBox vBox;
	Scene scene;
	
	public MultiplayerWindow(Stage primaryStage)
	{
		this.stage = primaryStage;
		backButton = new Button("Multiplayer");
		backButton.setOnAction(e->returnToWelcomeWindow());

		vBox = new VBox(backButton);
		scene = new Scene(vBox,500,500);	
		
		stage.setScene(scene);
		stage.setTitle("Snake Multiplayer");
	}
	
	protected void showMultiplayerStage()
	{
		stage.show();
	}
	
	private void closeMultiplayerWindow() {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}
	
	private void returnToWelcomeWindow()
	{
		closeMultiplayerWindow();
		WelcomeWindow welWin = new WelcomeWindow(stage);
		welWin.showWelcomeWindow();
	}

}
