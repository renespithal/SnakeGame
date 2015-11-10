package highscore.view;

import highscore.model.HighscoreModel;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class HighscoreView extends BorderPane {

	@SuppressWarnings("unused")
	private HighscoreModel model;

	private Label titleLabel;
	private Button backButton;
	private Button clearButton;
	private Button playButton;
	private RotateTransition t1;
	private RotateTransition t2;

	public TableView<HighscoreModel> highscoreTable;
	TableColumn<HighscoreModel,Number> ranking;
	TableColumn<HighscoreModel, String> player;
	TableColumn<HighscoreModel, Number> highscore; // Number instead of Integer

	@SuppressWarnings("unchecked")
	public HighscoreView() {

		//Background
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/ground2.jpg",650,500,false,false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		//Button Color
		Background buttonbackgrd = new Background(new BackgroundFill(Color.LIGHTGREEN,CornerRadii.EMPTY, Insets.EMPTY));

		//Images
		Image logo1 = new Image("file:src/images/yinyan1.png", 50, 50, true, true);
		ImageView ivlogo1 = new ImageView();
		ivlogo1.setImage(logo1);

		Image logo2 = new Image("file:src/images/yinyan1.png", 50, 50, true, true);
		ImageView ivlogo2 = new ImageView();
		ivlogo2.setImage(logo2);

		//DropShadow
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetY(3.5);
		dropShadow.setOffsetX(-3.5);
		dropShadow.setColor(Color.DARKGREEN);

		// Animation
		rotate1(ivlogo1, Duration.millis(1500), Interpolator.LINEAR);
		rotate2(ivlogo2, Duration.millis(1500), Interpolator.LINEAR);

		//Controls
		titleLabel = new Label("Highscore");
		titleLabel.setFont(Font.font ("AR DESTINE", 40));
		titleLabel.setTextFill(Color.DARKGREEN);

		//Create Controls
		clearButton = new Button("Clear Highscores");
		clearButton.setBackground(buttonbackgrd);
		clearButton.setEffect(dropShadow);

		playButton= new Button ("Start Game");
		playButton.setBackground(buttonbackgrd);
		playButton.setEffect(dropShadow);

		backButton = new Button("Main Menu");
		backButton.setBackground(buttonbackgrd);
		backButton.setEffect(dropShadow);

		highscoreTable = new TableView<HighscoreModel>();

		//Create Table
		ranking = new TableColumn<HighscoreModel, Number>("Ranking");
		ranking.setMinWidth(70);

		player = new TableColumn<HighscoreModel, String>("Player");
		player.setMinWidth(150);
		player.setCellValueFactory(new PropertyValueFactory<>("Player"));
		player.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().playernameProperty()); //Binding

		highscore = new TableColumn<HighscoreModel, Number>("Highscore");
		highscore.setMinWidth(280);
		highscore.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().getValueProperty());//Binding

		highscoreTable.getColumns().addAll(ranking, player, highscore);

		highscoreTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);



		//Create boxes
		HBox hBox1 = new HBox(ivlogo2,titleLabel,ivlogo1);
		hBox1.setAlignment(Pos.CENTER);

		VBox vBox1 = new VBox(highscoreTable, clearButton);
		vBox1.setAlignment(Pos.CENTER);

        HBox hBox2= new HBox(backButton,playButton);
		hBox2.setSpacing(347);


		// add Boxes to BorderPane
		this.setTop(hBox1);
		this.setCenter(vBox1);
		this.setBottom(hBox2);
		this.setBackground(new Background(backgrd));
	}

	public TableView<HighscoreModel> getHighscoreTable() {
		return highscoreTable;
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
	public Button getPlayButton() {
		return playButton;
	}

	public Button clearButton() {
		return clearButton;
	}

	
	public Button getBackButton() {
		return backButton;
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

