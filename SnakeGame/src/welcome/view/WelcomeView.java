package welcome.view;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.awt.*;


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
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/background3.jpg",650,500,false,false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);


		Background buttonbackgrd = new Background(new BackgroundFill(Color.DARKGREEN,CornerRadii.EMPTY, Insets.EMPTY));


		//Button Style
		Font buttonfont = new Font("AR DESTINE", 20);

		//DropShadow
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetY(3.5);
		dropShadow.setOffsetX(-3.5);
		dropShadow.setColor(Color.DARKGREEN);

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
		titleLabel.setFont(new Font("AR DESTINE", 40));
		titleLabel.setTextFill(Color.DARKGREEN);

		//Create Controls
		startButton = new Button("Start Game");
		startButton.setFont(buttonfont);
		startButton.setEffect(dropShadow);
		startButton.setBackground(buttonbackgrd);
		//startButton.setOnMouseEntered();
		startButton.setTextFill(Color.WHITE);
		startButton.setMaxWidth(150);

		multiplayerButton = new Button ("Multiplayer");
		multiplayerButton.setFont(buttonfont);
		multiplayerButton.setEffect(dropShadow);
		multiplayerButton.setBackground(buttonbackgrd);
		multiplayerButton.setTextFill(Color.WHITE);
		multiplayerButton.setMaxWidth(150);

		optionsButton = new Button("Options");
		optionsButton.setFont(buttonfont);
		optionsButton.setEffect(dropShadow);
		optionsButton.setBackground(buttonbackgrd);
		optionsButton.setTextFill(Color.WHITE);
		optionsButton.setMaxWidth(150);
		
		highscoreButton = new Button("Highscore");
		highscoreButton.setFont(buttonfont);
		highscoreButton.setEffect(dropShadow);
		highscoreButton.setBackground(buttonbackgrd);
		highscoreButton.setTextFill(Color.WHITE);
		highscoreButton.setMaxWidth(150);

		exitButton = new Button("Exit Game");
		exitButton.setFont(buttonfont);
		exitButton.setEffect(dropShadow);
		exitButton.setBackground(buttonbackgrd);
		exitButton.setTextFill(Color.WHITE);
		exitButton.setMaxWidth(150);

		//Create Boxes
		HBox hBox = new HBox(ivlogo1,titleLabel,ivlogo2);
		hBox.setAlignment(Pos.CENTER);
		hBox.setLayoutY(100);
		hBox.setLayoutX(300);

		VBox vBox = new VBox(hBox,startButton,multiplayerButton,optionsButton,highscoreButton,exitButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(15);

		//add Boxes to BorderPane
		this.setCenter(vBox);
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
