package welcome.view;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.util.Duration;


public class WelcomeView extends BorderPane{

	//Controls
	private Label titleLabel;
	private Button startButton;
	private Button optionsButton;
	private Button exitButton;
	private Button multiplayerButton;
	private Button highscoreButton;
	private RotateTransition t1;
	private RotateTransition t2;
	
	public WelcomeView() {

		//Background
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/background3.jpg",600,600,false,false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		//Images
		Image logo1 = new Image("file:src/images/yinyan1.png", 50, 50,true,true);
		ImageView ivlogo1 = new ImageView();
		ivlogo1.setImage(logo1);

		Image logo2 = new Image("file:src/images/yinyan1.png", 50, 50,true,true);
		ImageView ivlogo2 = new ImageView();
		ivlogo2.setImage(logo2);

		//Animation
		rotate1(ivlogo1, Duration.millis(1500), Interpolator.LINEAR);
		rotate2(ivlogo2, Duration.millis(1500), Interpolator.LINEAR);

		//Title
		titleLabel = new Label("Welcome to Snake");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.GREEN);
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.DOTTED, null, null));
		titleLabel.setBorder(border);

		//Create Controls
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

		//Create Boxes
		HBox hBox = new HBox(ivlogo1,titleLabel,ivlogo2);
		hBox.setAlignment(Pos.CENTER);

		VBox vBox1 = new VBox(hBox,startButton,multiplayerButton,optionsButton,highscoreButton,exitButton);
		vBox1.setAlignment(Pos.CENTER);
		vBox1.setSpacing(10);

		//add Boxes to BorderPane
		this.setCenter(vBox1);
		this.setBackground(new Background(backgrd));

	}
	//Animation
	public void rotate1(ImageView logo1, Duration duration, Interpolator interpolator) {

		t1 = new RotateTransition(duration, logo1);
		t1.setFromAngle(0);
		t1.setToAngle(360);
		t1.setCycleCount(Transition.INDEFINITE);
		t1.setAutoReverse(false);
		t1.setInterpolator(interpolator);
	}

	public void rotate2(ImageView logo2, Duration duration, Interpolator interpolator) {

		t2 = new RotateTransition(duration, logo2);
		t2.setFromAngle(0);
		t2.setToAngle(360);
		t2.setCycleCount(Transition.INDEFINITE);
		t2.setAutoReverse(false);
		t2.setInterpolator(interpolator);

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
	
	public void startRotation()
	{
		t1.play();
		t2.play();
	}
	
	public void stopRotation()
	{
		t1.stop();
		t2.stop();
	}
}
