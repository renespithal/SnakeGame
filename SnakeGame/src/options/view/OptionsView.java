package options.view;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;
import javafx.util.Duration;
import options.Options;

public class OptionsView extends BorderPane {

	//Controls
	private Label titleLabel;
	private Label speedLabel;
	private Label colorLabel;
	private Button backButton;
	private RadioButton onButton;
	private RadioButton offButton;
	private ComboBox<String> speedBox = new ComboBox<>();    //Geschwindigkeit
	private ComboBox<String> colorBox = new ComboBox<>();    //Farbe der Schlange
	/*
	 *private ComboBox<String> StageBox = new ComboBox<String>();  // Hintergrund aussuchen (brauchen wir nicht unbedingt)
	 */
	/*ChoiceBox music = new ChoiceBox();
	 music.getItems().addAll("on", "off"); */
	
	public OptionsView() {


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
		Border border = new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.DOTTED, null, null));
		titleLabel.setBorder(border);

		speedLabel = new Label("Choose Speed:");
		speedLabel.setFont(new Font(13));

		colorLabel = new Label("Choose Color:");
		colorLabel.setFont(new Font(13));

		backButton = new Button("back to menu");
		;

		//Create Options
		speedBox.getItems().addAll("Slow", "Normal", "Fast");
		
		if(Options.speed == Options.SLOW)
		{
			speedBox.setValue("Slow");
		} else if(Options.speed == Options.MEDIUM)
		{
			speedBox.setValue("Normal");
		}
		else if(Options.speed == Options.FAST)
		{
			speedBox.setValue("Fast");
		}

		colorBox.getItems().addAll("Green", "Red", "Blue", "Yellow", "Black"); // Farbe der Schalnge
		colorBox.setValue("Green");

		/*ImageView image = new ImageView();

		onButton.setonOption("on");
		offButton.setffOption("off");


		final ToggleGroup group = new ToggleGroup();
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
			public void changed(ObservableValue<? extends Toggle> ov,
								Toggle old_toggle, Toggle new_toggle) {
				if (group.getSelectedToggle() != null) {
					final Image image = new Image(
							getClass().getResourceAsStream(
									group.getSelectedToggle().getUserData().toString() +
											".jpg"
							)
					);
					icon.setImage(image);
				}
			}
		});*/

		/*ToggleGroup group = new ToggleGroup();
		RadioButton button1 = new RadioButton("on");
		button1.setToggleGroup(group);
		button1.setSelected(true);
		RadioButton button2 = new RadioButton("off");
		button2.setToggleGroup(group);*/

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
		this.setBackground(new Background(new BackgroundFill(Color.FLORALWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	//Animation
	public void rotate1(ImageView logo1, Duration duration, Interpolator interpolator) {

		RotateTransition t = new RotateTransition(duration, logo1);
		t.setFromAngle(0);
		t.setToAngle(360);
		t.setCycleCount(Transition.INDEFINITE);
		t.setAutoReverse(false);
		t.setInterpolator(interpolator);
		t.play();

	}

	public void rotate2(ImageView logo2, Duration duration, Interpolator interpolator) {

		RotateTransition t = new RotateTransition(duration, logo2);
		t.setFromAngle(0);
		t.setToAngle(360);
		t.setCycleCount(Transition.INDEFINITE);
		t.setAutoReverse(false);
		t.setInterpolator(interpolator);
		t.play();

	}
	public Button getBackButton()
	{
		return backButton;
	}

	public ComboBox<String>getSpeedBox() {
		return speedBox;
	}

	public ComboBox<String>getColorBox(){ return colorBox; }

	//public ToggleGroup.getSelectedToggle(){ return }

}
