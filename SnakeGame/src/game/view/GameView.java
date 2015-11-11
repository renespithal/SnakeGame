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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import options.Options;

public class GameView extends Pane{
	
	private FadeTransition t;
	private FadeTransition snakeDispose;
	private SnakeModel snake;
	private FoodModel food;
	private YinYangFoodModel yin;
	
	protected Pane highscorePane;
	private Pane snakePane;
	private Pane imagePane;
	private Pane wallPaneTop;
	private Pane wallPaneBottom;
	private Pane wallPaneRight;
	private Pane wallPaneLeft;
	private Rectangle snakeHead;
	private TextField textField;
	private HBox hBox;
	
	private AudioClip bonusFoodEaten;
	private AudioClip foodEaten;
	private AudioClip gameOver;
	
	/**
	 * Crates the view for the game.
	 * 
	 * @param model contains all information of the game
	 */
	public GameView(GameModel model) {
		
		this.snake = model.getSnake();
		this.food = model.getFood();
		this.yin = model.getYinYang();

		snakePane = new Pane(); 
				
		snakeHead = new Rectangle(20, 20);
		snakeHead.setFill(Options.color);
		snakePane.getChildren().add(snakeHead);
		bindSnakePart(snake.getHead(), snakeHead);
		
		
		/**
		 * updates the view for the snake if the list changed
		 */
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

		gameOver = new AudioClip("file:src/sounds/GameOver.wav");

		imagePane = new Pane();
		imagePane.getChildren().addAll(ivFood, ivYin);


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

		highscore.setFont(new Font("AR DESTINE",40));
		highscore.setTextFill(Color.GOLD);


		textField = new TextField(){

			/**
			 *
			 * @param start
			 * @param end
			 * @param text
			 */
			@Override public void replaceText(int start, int end, String text) {

				if (getText().length() <= 13|| text == "" ) {	//maximal 13
					super.replaceText(start, end, text);
				}
			}
			@Override public void replaceSelection(String text) {
				if (getText().length() < 13 || text == "") {
					super.replaceSelection(text);
				}
			}
		};

		Label enterName = new Label("Player Name:");
		enterName.setFont(new Font ("AR DESTINE",20));
		enterName.setTextFill(Color.GOLD);

		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetY(3.5);
		dropShadow.setOffsetX(-3.5);
		dropShadow.setColor(Color.BLACK);

		hBox = new HBox (enterName, textField);
		hBox.setSpacing(10);

		VBox vBox = new VBox(highscore,hBox);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(10);


		highscorePane = new StackPane();
		highscorePane.getChildren().add(vBox);
		highscoreSetPosition();
		highscorePane.setEffect(dropShadow);
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


		// Background of game
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/bckgrdyinyan.png", 500, 500, false, false),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);


		this.setBackground(new Background(backgrd));

	}

	protected void highscoreSetPosition() {
		highscorePane.setLayoutX(120);
		highscorePane.setLayoutY(210);
	}

	/**
	 * Add all created panes to the main pane.
	 * @param panes all created panes
	 */
	protected void addPanesToMainPane(Pane... panes) {
		this.getChildren().addAll(panes);
	}

	/**
	 * Binds the snake body of the model to the view.
	 * @param snakePart the new created snake part
	 * @param snakePartView the new created rectangle
	 */
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
	
	/**
	 * Fade effect for the bonus food.
	 * @param node the object to be animated
	 * @param duration the duration of the animation
	 * @param cycle how often it shall be repeated
	 * @param interpolator
	 */
	public void fade(Node node, Duration duration,int cycle, Interpolator interpolator) {
		t = new FadeTransition(duration, node);
		t.setFromValue(0);
		t.setToValue(100);
		t.setCycleCount(cycle);
		t.setAutoReverse(true);
		t.setInterpolator(interpolator);
	}
	
	/**
	 * Fade effect for the dead of snake.
	 * @param node all nodes which shall be animated
	 */
	public void fade(Node node)
	{
		snakeDispose = new FadeTransition(Duration.millis(1000), node);
		snakeDispose.setFromValue(1);
		snakeDispose.setToValue(0);
		snakeDispose.setCycleCount(1);
		t.setInterpolator(Interpolator.LINEAR);
	}

	public Pane getHighscorePane()
	{
		return highscorePane;
	}
	
	public Pane getSnakePane() {
		return snakePane;
	}
	
	public Rectangle getSnakeHead() {
		return snakeHead;
	}
	
	public FadeTransition getSnakeDispose() {
		return snakeDispose;
	}
	
	public TextField getTextField() {
		return textField;
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
	
	public void startDisposeAnimation()
	{
		snakeDispose.play();
	}
	
	public void stopDisposeAnimation()
	{
		snakeDispose.stop();
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
