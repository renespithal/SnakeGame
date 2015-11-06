package game.view;

import game.model.FoodModel;
import game.model.GameModel;
import game.model.SnakeModel;
import game.model.SnakePartModel;
import game.model.YinYangFoodModel;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.StringBinding;
import javafx.collections.ListChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import options.Options;

public class GameView extends Pane{
	
	protected Pane highscorePane;
	private FadeTransition t;
	private SnakeModel snake;
	private FoodModel food;
	private YinYangFoodModel yin;
	protected Pane snakePane;
	protected Pane imagePane;
	protected Pane wallPaneTop;
	protected Pane wallPaneBottom;
	protected Pane wallPaneRight;
	protected Pane wallPaneLeft;
	public final TextField textField;
	private HBox hBox;
	private AudioClip bonusFoodEaten;
	private AudioClip foodEaten;
	private AudioClip gameOver;
	
	public GameView(GameModel model) {
		
		this.snake = model.getSnake();
		this.food = model.getFood();
		this.yin = model.getYinYang();

		snakePane = new Pane(); 
				
		Rectangle snakeHead = new Rectangle(20, 20);
		snakeHead.setFill(Options.color);
		snakePane.getChildren().add(snakeHead);
		bindSnakePart(snake.getHead(), snakeHead);
		
		snake.getList().addListener(new ListChangeListener<SnakePartModel>()
				{

					@Override
					public void onChanged(javafx.collections.ListChangeListener.Change<? extends SnakePartModel> c) {
						while(c.next()){
							Rectangle snakePartView = new Rectangle(20, 20);
							snakePartView.setFill(Options.color);
							SnakePartModel newPart = c.getAddedSubList().get(0);
							bindSnakePart(newPart, snakePartView);
							snakePane.getChildren().add(snakePartView);
						}
					}
				});

		Image imageYin = new Image("file:src/images/yinyan2.png", 20, 20, true, true);
		ImageView ivYin = new ImageView();
		ivYin.setImage(imageYin);
		

		fade(ivYin, Duration.millis(1000),Transition.INDEFINITE, Interpolator.TANGENT(Duration.millis(0),100));

		ivYin.xProperty().bind(new IntegerBinding() {
			{bind(yin.getXProperty());}

			@Override
			protected int computeValue() {
				return yin.getX()*20;
			}});

		ivYin.yProperty().bind(new IntegerBinding() {
			{bind(yin.getYProperty());}
			{
				bind(yin.getYProperty());
			}

			@Override
			protected int computeValue() {
				return yin.getY()*20;
			}});
		
		ivYin.visibleProperty().bind(new BooleanBinding() {
			{bind(yin.getVisibleProperty());}
			{
				bind(yin.getYProperty());
			}
			@Override
			protected boolean computeValue() {
				return yin.getVisible();
			}
			
		});
		
		bonusFoodEaten = new AudioClip("file:src/sounds/BonusFoodSound.wav");

		Image imageFood = new Image("file:src/images/apple2.png", 20, 20, true, true);
		ImageView ivFood = new ImageView();
		ivFood.setImage(imageFood);

		ivFood.xProperty().bind(new IntegerBinding() {
			{bind(food.getXProperty());}

			@Override
			protected int computeValue() {
				return food.getX()*20;
			}});

		ivFood.yProperty().bind(new IntegerBinding() {
			{bind(food.getYProperty());}
			{
				
				bind(food.getYProperty());
			}

			@Override
			protected int computeValue() {
				return food.getY()*20;
			}});
		
		foodEaten = new AudioClip("file:src/sounds/FoodSound.wav");

		Label highscore = new Label();
		highscore.textProperty().bind(new StringBinding() {
			{
				bind(model.getHighscore().getValueProperty());
			}

			@Override
			protected String computeValue() {
				return "Highscore: "+model.getHighscore().getValue();
			}
		});


		gameOver = new AudioClip("file:src/sounds/GameOver.wav");
		
		imagePane = new Pane();
		imagePane.getChildren().addAll(ivFood, ivYin);

		Label enterName = new Label("Player Name:");
		enterName.setFont(new Font (15));
		textField = new TextField();

		highscore.setFont(new Font(40));

		hBox = new HBox (enterName, textField);
		hBox.setSpacing(10);

		VBox vBox = new VBox(highscore);
		vBox.setSpacing(10);
		highscore.setFont(new Font(40));
		vBox.getChildren().add(hBox);

		highscorePane = new StackPane();
		highscorePane.getChildren().add(vBox);
		highscoreSetPosition();
		highscorePane.setVisible(false);


		//Create wall
		wallPaneTop = new Pane();
		Image imageWallTop = new Image("file:src/images/bamboowall2.jpg");
		ImageView ivWallTop = new ImageView();
		ivWallTop.setImage(imageWallTop);
		ivWallTop.setFitHeight(20);
		ivWallTop.setFitWidth(500);
		wallPaneTop.getChildren().add(ivWallTop);

		wallPaneBottom = new Pane();
		Image imageWallBottom = new Image("file:src/images/bamboowall2.jpg");
		ImageView ivWallBottom = new ImageView();
		ivWallBottom.setImage(imageWallBottom);
		ivWallBottom.setFitHeight(20);
		ivWallBottom.setFitWidth(500);
		ivWallBottom.setLayoutY(480);
		wallPaneBottom.getChildren().add(ivWallBottom);

		wallPaneLeft = new Pane();
		Image imageWallLeft = new Image("file:src/images/bamboowall1.jpg");
		ImageView ivWallLeft = new ImageView();
		ivWallLeft.setImage(imageWallLeft);
		ivWallLeft.setFitHeight(500);
		ivWallLeft.setFitWidth(20);
		wallPaneLeft.getChildren().add(ivWallLeft);

		wallPaneRight = new Pane();
		Image imageWallRight = new Image("file:src/images/bamboowall1.jpg");
		ImageView ivWallRight = new ImageView();
		ivWallRight.setImage(imageWallRight);
		ivWallRight.setFitHeight(500);
		ivWallRight.setFitWidth(20);
		ivWallRight.setLayoutX(480);
		wallPaneRight.getChildren().add(ivWallRight);


		addPanesToMainPane(wallPaneTop, wallPaneBottom, wallPaneLeft, wallPaneRight,snakePane, imagePane, highscorePane);


		// Background
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/ground1.jpg", 700, 600, false, false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);


		this.setBackground(new Background(backgrd));

	}

	protected void highscoreSetPosition() {
		highscorePane.setLayoutX(140);
		highscorePane.setLayoutY(180);
	}

	protected void addPanesToMainPane(Pane... panes) {
		this.getChildren().addAll(panes);
	}

	protected void bindSnakePart(SnakePartModel snakePart, Rectangle snakePartView) {
		snakePartView.xProperty().bind(new IntegerBinding() {
			{bind(snakePart.getXProperty());}

			@Override
			protected int computeValue() {

				return snakePart.getX()*20;
			}});

		snakePartView.yProperty().bind(new IntegerBinding() {
			{bind(snakePart.getYProperty());}

			@Override
			protected int computeValue() {
				return snakePart.getY() *20;
			}
		});

	}
	
	public void fade(Node node, Duration duration,int cycle, Interpolator interpolator) {
		t = new FadeTransition(duration, node);
		t.setFromValue(0);
		t.setToValue(100);
		t.setCycleCount(cycle);
		t.setAutoReverse(true);
		t.setInterpolator(interpolator);

	}


	public Pane getHighscorePane()
	{
		return highscorePane;
	}
	
	protected Pane getSnakePane() {
		return snakePane;
	}
	
	protected void setHBoxUnvisible()
	{
		hBox.setVisible(false);
	}
	
	public void startAnimation() {
		t.play();
	}

	public void stopAnimation() {
		t.stop();
	}
	
	public void playBonusFoodMusic()
	{
		bonusFoodEaten.play();
	}
	
	public void playFoodMusic()
	{
		foodEaten.play();
	}
	
	public void playGameOverMusic()
	{
		gameOver.play();
	}

}
