package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WelcomeWindow {

	Stage parent;
	Label titleLabel;
	Button startButton;
	Button exitButton;
	Button optionButton;
	Button multiplayerButton;
	VBox vBox;
	Scene scene;
	

	public WelcomeWindow(Stage primaryStage) {
		
		this.parent = primaryStage;
		

		titleLabel = new Label("Welcome to Snake");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font("Calibri",38));
		titleLabel.setTextFill(Color.GREEN);
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, null));
		titleLabel.setBorder(border);

		startButton = new Button("Start Game");
		startButton.setAlignment(Pos.CENTER);
		startButton.setMaxWidth(100);
		startButton.setOnAction(e -> openGameWindow());
		
		multiplayerButton = new Button ("Multiplayer");
		multiplayerButton.setAlignment(Pos.CENTER);
		multiplayerButton.setMaxWidth(100);
		multiplayerButton.setOnAction(e -> openMultiplayerWindow());
		
		optionButton = new Button ("Game Option");
		optionButton.setAlignment(Pos.CENTER);
		optionButton.setMaxWidth(100);
		optionButton.setOnAction(e -> openOptionWindow());

		exitButton = new Button("Exit Game");
		exitButton.setAlignment(Pos.CENTER);
		exitButton.setMaxWidth(100);
		exitButton.setOnAction(e -> closeWelcomeWindow());
	

		vBox = new VBox(10, titleLabel,startButton, multiplayerButton, optionButton, exitButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(10);
		scene = new Scene(vBox, 500, 500);
		
		parent.setScene(scene);
		parent.setTitle("Snake");

	}

	public Scene getScene() {
		return scene;
	}

	public void openGameWindow() {
		closeWelcomeWindow();
		SnakeGameWindow gameWindow = new SnakeGameWindow(parent);
		gameWindow.showGameStage();

	}

	private void closeWelcomeWindow() {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}
	
	private void openOptionWindow(){
		closeWelcomeWindow();
		OptionWindow gameWindow = new OptionWindow(parent);
		gameWindow.showGameStage();
		
	}
	
	private void openMultiplayerWindow() {
		closeWelcomeWindow();
		MultiplayerWindow gameWindow = new MultiplayerWindow(parent);
		gameWindow.showGameStage();
		
	}
	
	public void showWelcomeWindow()
	{
		parent.show();
	}

}
