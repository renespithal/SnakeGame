package welcome.view;

import javafx.geometry.Pos;  
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/*import javafx.scene.image.Image;
import javafx.scene.image.ImageView;*/
import javafx.scene.text.Font;

public class WelcomeView extends VBox{
	private Label titleLabel;
	private Button startButton;
	private Button optionsButton;
	private Button exitButton;
	private Button multiplayerButton;
	private Button highscoreButton;
	
	public WelcomeView() {
		
		titleLabel = new Label("Welcome to Snake");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.GREEN);
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.DOTTED, null, null));
		titleLabel.setBorder(border);

		multiplayerButton = new Button ("Multiplayer");
		multiplayerButton.setAlignment(Pos.CENTER);
		multiplayerButton.setMaxWidth(100);

		startButton = new Button("Start Game");
		startButton.setAlignment(Pos.CENTER);
		startButton.setMaxWidth(100);

		optionsButton = new Button("Options");
		optionsButton.setAlignment(Pos.CENTER);
		optionsButton.setMaxWidth(100);
		
		highscoreButton = new Button("Highscore");
		highscoreButton.setAlignment(Pos.CENTER);
		highscoreButton.setMaxWidth(100);

		exitButton = new Button("Exit Game");
		exitButton.setAlignment(Pos.CENTER);
		exitButton.setMaxWidth(100);
		
		/*Image img = new Image ("yinyanyolo.jpg");
		ImageView imgView = new ImageView(img);*/
	
		this.getChildren().addAll(titleLabel,startButton,multiplayerButton,optionsButton,highscoreButton,exitButton);
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
	
	public Button getHighscoreButton()
	{
		return highscoreButton;
	}
	
	public Button getExitButton()
	{
		return exitButton;
	}
}
