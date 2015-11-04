package close.view;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class CloseView extends BorderPane{
	
	private Label titleLabel;
	private Button backButton;
	private Button exitButton;
	private RotateTransition t1;
	private RotateTransition t2;
	
	public CloseView()
	{
		titleLabel = new Label("Do you really want to leave?");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(23));
		titleLabel.setTextFill(Color.BLACK);
		
		backButton = new Button("NOOOOOOOO!!!");
		backButton.setAlignment(Pos.CENTER);
		backButton.setMaxWidth(150);
		
		exitButton  = new Button ("Yes,bye");
		exitButton.setAlignment(Pos.CENTER);
		exitButton.setMaxWidth(80);

		//Background
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/background2.jpg",600,500,false,false),
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

		//Create Boxes
		HBox hBox = new HBox(ivlogo1,titleLabel,ivlogo2);
		hBox.setAlignment(Pos.CENTER);

		VBox vBox = new VBox(hBox,backButton,exitButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(10);

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
	
	public Button getBackButton()
	{
		return backButton;
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
