package highscore.view;

import highscore.model.HighscoreModel;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.util.Duration;

import java.util.LinkedList;


public class HighscoreView extends BorderPane {

	private HighscoreModel model;

	private Label titleLabel;
	private Button backButton;
	private Button clearButton;
	private Button playButton;
	private RotateTransition t1;
	private RotateTransition t2;


	public TableView<HighscoreModel> highscoreTable;
	TableColumn<HighscoreModel, String> player;
	TableColumn<HighscoreModel, Number> highscore; // Number instead of Integer

	/**
	 * Creates the view of the highscore.
	 */
	public HighscoreView() {
		//Background
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/ground2.jpg",650,500,false,false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		//Button Color
		Background buttonbackgrd = new Background(new BackgroundFill(Color.DARKGREEN,CornerRadii.EMPTY, Insets.EMPTY));

		//Button Font
		Font buttonfont = new Font("AR DESTINE", 22);

		//DropShadow for Button
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

		// Animation
		rotate1(ivlogo1, Duration.millis(1500), Interpolator.LINEAR);
		rotate2(ivlogo2, Duration.millis(1500), Interpolator.LINEAR);

		//Controls
		titleLabel = new Label("Highscore");
		titleLabel.setFont(new Font("AR DESTINE", 50));
		titleLabel.setTextFill(Color.DARKGREEN);

		//Create Controls
		clearButton = new Button("Clear Highscore");
		clearButton.setFont(buttonfont);
		clearButton.setTextFill(Color.WHITE);
		clearButton.setBackground(buttonbackgrd);
		clearButton.setEffect(dropShadow);
		clearButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				clearButton.setTextFill(Color.GOLD);
			}
		});
		clearButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				clearButton.setTextFill(Color.WHITE);
			}
		});

		playButton= new Button ("Start Game");
		playButton.setFont(buttonfont);
		playButton.setTextFill(Color.WHITE);
		playButton.setBackground(buttonbackgrd);
		playButton.setEffect(dropShadow);
		playButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				playButton.setTextFill(Color.GOLD);
			}
		});
		playButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				playButton.setTextFill(Color.WHITE);
			}
		});

		backButton = new Button("Main Menu");
		backButton.setFont(buttonfont);
		backButton.setTextFill(Color.WHITE);
		backButton.setBackground(buttonbackgrd);
		backButton.setEffect(dropShadow);
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

		//Create Table
		highscoreTable = new TableView<HighscoreModel>();

		//Create Column

		player = new TableColumn<HighscoreModel, String>("Player");
		player.setPrefWidth(150);
		player.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().playernameProperty()); //Binding

		highscore = new TableColumn<HighscoreModel, Number>("Highscore");
		highscore.setPrefWidth(150);
		highscore.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().getValueProperty());//Binding


		highscoreTable.getColumns().addAll( player, highscore);
		highscoreTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


		titleLabel.setFont(Font.font ("AR DESTINE", 45));
		titleLabel.setTextFill(Color.DARKGREEN);



		//Create boxes
		HBox hBox1 = new HBox();
		hBox1.getChildren().addAll(ivlogo2,titleLabel,ivlogo1);
		hBox1.setAlignment(Pos.CENTER);

        HBox hBox2= new HBox(backButton,playButton);
		hBox2.setSpacing(210);

		VBox vBox1 = new VBox();
		vBox1.getChildren().addAll(highscoreTable,clearButton);
		vBox1.setAlignment(Pos.CENTER);


		// add Boxes to BorderPane
		this.setTop(hBox1);
		this.setCenter(vBox1);
		this.setBottom(hBox2);
		this.setBackground(new Background(backgrd));
	}

	public TableView<HighscoreModel> getHighscoreTable() {
		return highscoreTable;
	}

	/**
	 *
	 * @param logo1 the object to be animated
	 * @param duration the duration of the animation
	 * @param interpolator
	 */
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
	public Button getPlayButton() {
		return playButton;
	}

	public Button clearButton() {
		return clearButton;
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

