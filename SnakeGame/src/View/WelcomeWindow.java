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

/**

 * Created by Duy on 20.10.2015.

 */
public class WelcomeWindow {

	Stage parent;
	Label titleLabel;
	Button startButton;
	Button optionButton;
	Button exitButton;
	VBox vBox;
	Scene scene;

	public WelcomeWindow(Stage primaryStage) {
		
		this.parent = primaryStage;

		titleLabel = new Label("Welcome to Snake");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.GREEN);
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, null));
		titleLabel.setBorder(border);

		startButton = new Button("Start game");
		startButton.setAlignment(Pos.CENTER);
		startButton.setMaxWidth(100);
		startButton.setOnAction(e -> openGameWindow());

		optionButton = new Button("Options");
		optionButton.setAlignment(Pos.CENTER);
		optionButton.setMaxWidth(100);
		optionButton.setOnAction(e -> openOptionWindow());
		
		exitButton = new Button("Exit game");
		exitButton.setAlignment(Pos.CENTER);
		exitButton.setMaxWidth(100);
		exitButton.setOnAction(e -> closeWelcomeWindow());

		vBox = new VBox(10, titleLabel, startButton,optionButton, exitButton);
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
	
	public void openOptionWindow()
	{
		closeWelcomeWindow();
		OptionWindow optionWindow = new OptionWindow(parent);
		optionWindow.showOptionStage();
	}

	private void closeWelcomeWindow() {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}
	
	public void showWelcomeWindow()
	{
		parent.show();
	}

}
