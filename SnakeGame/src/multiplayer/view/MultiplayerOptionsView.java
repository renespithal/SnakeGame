package multiplayer.view;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class MultiplayerOptionsView extends BorderPane {

	private Label titleLabel;
	private Button normalButton;
	private Button survivalButton;
	private Button backButton;
	private RotateTransition t1;
	private RotateTransition t2;
	
	/**
	 * Creates the view of the options in the multiplayer.
	 */
	public MultiplayerOptionsView()
	{
		//Background
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/ground2.jpg",650,500,false,false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		//Button Color
		Background buttonbackgrd = new Background(new BackgroundFill(Color.DARKGREEN,CornerRadii.EMPTY, Insets.EMPTY));

		//Button Font
		Font buttonfont = new Font("AR DESTINE", 20);

		//DropShadow
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetY(3.5);
		dropShadow.setOffsetX(-3.5);
		dropShadow.setColor(Color.DARKGREEN);

		//Images
		Image logo1 = new Image("file:src/images/yinyan1.png", 50, 50, true, true);
		ImageView ivlogo1 = new ImageView();
		ivlogo1.setImage(logo1);

		Image logo2 = new Image("file:src/images/yinyan1.png", 50, 50, true, true);
		ImageView ivlogo2 = new ImageView();
		ivlogo2.setImage(logo2);

		//Animation
		rotate1(ivlogo1, Duration.millis(1500), Interpolator.LINEAR);
		rotate2(ivlogo2, Duration.millis(1500), Interpolator.LINEAR);

		//Title
		titleLabel = new Label("Multiplayer");
		titleLabel.setFont(Font.font ("AR DESTINE", 40));
		titleLabel.setTextFill(Color.DARKGREEN);

		//Create Controls
		normalButton = new Button("Normal Mode");
		normalButton.setFont (buttonfont);
		normalButton.setTextFill(Color.WHITE);
		normalButton.setEffect(dropShadow);
		normalButton.setBackground(buttonbackgrd);
		normalButton.setMaxWidth(180);
		normalButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				normalButton.setTextFill(Color.GOLD);
			}
		});
		normalButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				normalButton.setTextFill(Color.WHITE);
			}
		});

		survivalButton = new Button("Survival Mode");
		survivalButton.setFont(buttonfont);
		survivalButton.setTextFill(Color.WHITE);
		survivalButton.setEffect(dropShadow);
		survivalButton.setBackground(buttonbackgrd);
		survivalButton.setMaxWidth(180);
		survivalButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				survivalButton.setTextFill(Color.GOLD);
			}
		});
		survivalButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				survivalButton.setTextFill(Color.WHITE);
			}
		});

		backButton = new Button("Main Menu");
		backButton.setFont (buttonfont);
		backButton.setTextFill(Color.WHITE);
		backButton.setBackground(new Background(new BackgroundFill(Color.DARKGREEN,CornerRadii.EMPTY, Insets.EMPTY)));
		backButton.setEffect(dropShadow);
		backButton.setMaxWidth(180);
		backButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				backButton.setTextFill(Color.GOLD);
			}
		});
		backButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				backButton.setTextFill(Color.WHITE);
			}
		});


		//Create Boxes
		HBox hBox = new HBox(ivlogo1,titleLabel,ivlogo2);
		hBox.setAlignment(Pos.CENTER);

		
		VBox vBox = new VBox(hBox,normalButton,survivalButton,backButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(15);


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

	public Button getNormalButton() {
		return normalButton;
	}
	
	public Button getSurvivalButton() {
		return survivalButton;
	}
	
	public Button getBackButton() {
		return backButton;
	}

	/**
	 * Starts the rotation of the yin yang icon.
	 */
	public void startRotation()
	{
		t1.play();
		t2.play();
	}

	/**
	 * Stops the rotation of the yin yang icon.
	 */
	public void stopRotation()
	{
		t1.stop();
		t2.stop();
	}
}
