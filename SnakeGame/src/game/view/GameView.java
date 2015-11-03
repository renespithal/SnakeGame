package game.view;

import com.sun.javafx.scene.layout.region.BorderImageSlices;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class GameView extends Pane{
	
	private Pane highscorePane;
	private FadeTransition t;
	private SnakeModel snake;
	private FoodModel food;
	private YinYangFoodModel yin;
	
	public GameView(GameModel model) {
		
		this.snake = model.getSnake();
		this.food = model.getFood();
		this.yin = model.getYinYang();
		
		Pane snakePane = new Pane(); 
		
//		Image imageSnake = new Image("file:src/images/snakePart.jpg", 20, 20, true, true);
//		ImageView ivSnake = new ImageView();
//		ivSnake.setImage(imageSnake);
		
		Rectangle snakeHead = new Rectangle(20, 20);
		snakeHead.setFill(Color.GOLD);
		snakePane.getChildren().add(snakeHead);
		bindSnakePart(snake.getHead(), snakeHead);
		
		snake.getList().addListener(new ListChangeListener<SnakePartModel>()
				{

					@Override
					public void onChanged(javafx.collections.ListChangeListener.Change<? extends SnakePartModel> c) {
						while(c.next()){
							Rectangle snakePartView = new Rectangle(20, 20);
							snakePartView.setFill(Color.GREEN);
							SnakePartModel newPart = c.getAddedSubList().get(0);
							bindSnakePart(newPart, snakePartView);
							snakePane.getChildren().add(snakePartView);
						}
					}
				});

		Image imageYin = new Image("file:src/images/yinyan2.png", 20, 20, true, true);
		ImageView ivYin = new ImageView();
		ivYin.setImage(imageYin);
		

		fade(ivYin, Duration.millis(1000), Interpolator.TANGENT(Duration.millis(0),100));

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

		/*hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(highscore);*/
		
		Pane imagePane = new Pane();
		imagePane.getChildren().addAll(ivFood, ivYin);

		Label enterName = new Label("Player Name:");
		TextField textField = new TextField();
		highscore.setFont(new Font(40));

		HBox hBox = new HBox (enterName,textField);

		VBox vBox = new VBox(highscore,hBox);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(10);


		highscorePane = new StackPane();
		highscorePane.getChildren().add(vBox);
		highscorePane.setLayoutX(140);
		highscorePane.setLayoutY(180);
		highscorePane.setVisible(false);
		highscorePane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		
		this.getChildren().addAll(snakePane,imagePane,highscorePane);
	}

	private void bindSnakePart(SnakePartModel snakePart, Rectangle snakePartView) {
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
		//this.setBackground(new Background(new BackgroundFill(Color.MEDIUMSPRINGGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		//this.setBorder(new Border(new BorderImage(new Image("file:src/images/background3.jpg",600,600,false,false),null,null, BorderImageSlices.DEFAULT,true,null));

	}

	public void fade(ImageView ivYin, Duration duration, Interpolator interpolator) {
		t = new FadeTransition(duration, ivYin );
		t.setFromValue(0);
		t.setToValue(1000);
		t.setCycleCount(Transition.INDEFINITE);
		t.setAutoReverse(true);
		t.setInterpolator(interpolator);

	}


	public Pane getHighscorePane()
	{
		return highscorePane;
	}
	
	public void startAnimation() {
		t.play();
	}

	public void stopAnimation() {
		t.stop();
	}
}
