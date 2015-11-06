package options.view;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import options.Options;

public class OptionsView extends BorderPane {

	//Controls
	private Label titleLabel;
	private Label speedLabel;
	private Label colorLabel;
	private Button backButton;
	private ComboBox<String> speedBox;   //Speed
	private ComboBox<String> colorBox;  //Color
	private RotateTransition t1;
	private RotateTransition t2;

	
	public OptionsView() {

		//Background
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/ground2.jpg",650,500,false,false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);


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

		//Create Controls
		titleLabel = new Label("Welcome to Options");
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.CORNFLOWERBLUE);

		speedLabel = new Label("Choose Speed:");
		speedLabel.setFont(new Font(13));
		speedLabel.setMaxWidth(150);

		colorLabel = new Label("Choose Color:");
		colorLabel.setFont(new Font(13));
		colorLabel.setMaxWidth(150);

		backButton = new Button("Main Menu");
		backButton.setMaxWidth(150);
		

		//Create Options
		speedBox = new ComboBox<>();
		speedBox.setMaxWidth(150);
		speedBox.getItems().addAll("Slow", "Normal", "Fast");

		if (Options.speed == Options.SLOW) {
			speedBox.setValue("Slow");
		} else if (Options.speed == Options.MEDIUM) {
			speedBox.setValue("Normal");
		} else if (Options.speed == Options.FAST) {
			speedBox.setValue("Fast");
		}
		
		colorBox = new ComboBox<>();
		colorBox.setMaxWidth(150);
		colorBox.getItems().addAll("Green", "Red", "Blue", "Yellow", "Black");
		if (Options.color == Options.GREEN) {
			colorBox.setValue("Green");
		} else if (Options.color == Options.RED) {
			colorBox.setValue("Red");
		} else if (Options.color == Options.BLUE) {
			colorBox.setValue("Blue");
		} else if (Options.color == Options.YELLOW) {
			colorBox.setValue("Yellow");
		} else if (Options.color == Options.BLACK) {
			colorBox.setValue("Black");
		}


		//add Boxes to Border Pane
		HBox hBox1 = new HBox(ivlogo1, titleLabel, ivlogo2);
		hBox1.setAlignment(Pos.CENTER);

		VBox vBox2 = new VBox(speedLabel, speedBox);
		vBox2.setAlignment(Pos.CENTER);

		VBox vBox3 = new VBox(colorLabel, colorBox);
		vBox3.setAlignment(Pos.CENTER);

		VBox vBox = new VBox(hBox1, vBox2, vBox3, backButton);
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


	public Button getBackButton()
	{
		return backButton;
	}

	public ComboBox<String>getSpeedBox() {
		return speedBox;
	}

	public ComboBox<String>getColorBox(){ return colorBox; }


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
