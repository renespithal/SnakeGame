package welcome.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WelcomeView extends VBox{
	private Label titleLabel;
	private Button startButton;
	private Button optionsButton;
	private Button exitButton;
	private Button multiplayerButton;
	
	public WelcomeView() {
		titleLabel = new Label("Welcome to Snake");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.GREEN);
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, null));
		titleLabel.setBorder(border);

		multiplayerButton = new Button ("Multiplayer");
		multiplayerButton.setAlignment(Pos.CENTER);
		multiplayerButton.setMaxWidth(100);

		startButton = new Button("Start game");
		startButton.setAlignment(Pos.CENTER);
		startButton.setMaxWidth(100);

		optionsButton = new Button("Options");
		optionsButton.setAlignment(Pos.CENTER);
		optionsButton.setMaxWidth(100);

		exitButton = new Button("Exit game");
		exitButton.setAlignment(Pos.CENTER);
		exitButton.setMaxWidth(100);
		
		this.getChildren().addAll(titleLabel,startButton,multiplayerButton,optionsButton,exitButton);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
	}
	
	public Button getStartButton(){
		return startButton;
	}
	
	public Button getMultiplayerButton()
	{
		return multiplayerButton;
	}
	public Button getOptionsButton()
	{
		return optionsButton;
	}
	
	public Button getExitButton()
	{
		return exitButton;
	}
}
