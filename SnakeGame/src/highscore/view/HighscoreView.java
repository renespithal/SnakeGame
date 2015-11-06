package highscore.view;

import highscore.model.HighscoreModel;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class HighscoreView extends BorderPane {

	private HighscoreModel model;

	private Label titleLabel;
	private Button getbackButton;
	private Button clearButton;
	private RotateTransition t1;
	private RotateTransition t2;

	public TableView<HighscoreModel> highscoreTable;
	TableColumn<HighscoreModel, String> player;
	TableColumn<HighscoreModel, Number> highscore; // Number instead of Integer

	public HighscoreView() {

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

		// Animation
		rotate1(ivlogo1, Duration.millis(1500), Interpolator.LINEAR);
		rotate2(ivlogo2, Duration.millis(1500), Interpolator.LINEAR);

		//Controls
		titleLabel = new Label("Highscore");
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.DARKGREEN);

		//Create Controls
		clearButton = new Button("Clear Table");
		getbackButton = new Button("Main Menu");
		highscoreTable = new TableView<HighscoreModel>();


		//Create Table
		player = new TableColumn<HighscoreModel, String>("Player");
		player.setMinWidth(150);
		player.setCellValueFactory(new PropertyValueFactory<>("Player"));
		player.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().playernameProperty()); //Binding

		highscore = new TableColumn<HighscoreModel, Number>("Highscore");
		highscore.setMinWidth(350);
		highscore.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().getValueProperty());//Binding

		highscoreTable.getColumns().addAll(player, highscore);


		//Create boxes
		HBox hbox1 = new HBox(ivlogo2,titleLabel,ivlogo1);
		hbox1.setAlignment(Pos.CENTER);

		HBox hBox2 = new HBox(8);
		hBox2.setAlignment(Pos.CENTER);
		hBox2.getChildren().addAll(clearButton);


		VBox vBox1 = new VBox(highscoreTable, hBox2);
		VBox vBox2= new VBox (getbackButton);
		vBox2.setAlignment(Pos.BOTTOM_RIGHT);


		// add Boxes to BorderPane
		this.setTop(hbox1);
		this.setCenter(vBox1);
		this.setBottom(vBox2);
		this.setBackground(new Background(backgrd));
	}

	public TableView<HighscoreModel> gethighscoreTable() {
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
	 
	public Button clearButton() {
		return clearButton;
	}

	
	public Button getBackButton() {
		return getbackButton;
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

