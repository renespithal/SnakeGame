package game.presenter;


import game.GameScene;
import game.model.FoodModel;
import game.model.GameModel;
import game.model.SnakeModel;
import game.model.SnakeModel.Direction;
import game.model.SnakePartModel;
import game.model.YinYangFoodModel;
import game.view.GameView;
import highscore.model.HighscoreModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import welcome.WelcomeScene;

public class GamePresenter {
	private Timeline loop;
	private Timeline bonusLoop;
	private KeyFrame snakeMovement;
	private KeyFrame showBonusFood;
	private KeyFrame hideBonusFood;
	private KeyFrame collision;
	private Direction direction;
	
	private GameView view;
	private FoodModel food;
	private SnakeModel snake;
	private YinYangFoodModel yin;
	private HighscoreModel highscore;
	private GameScene scene;

	
	public GamePresenter(GameModel model, GameView view, GameScene scene) {
		this.view = view;
		this.food = model.getFood();
		this.snake = model.getSnake();
		this.yin = model.getYinYang();
		this.highscore = model.getHighscore();
		this.scene = scene;
		
		direction = model.getSnake().getDirection();
		scene.setOnKeyPressed(e -> moveSnakeControl(e));
		
		createKeyFrames();
		createTimelines();

	}

	private void createKeyFrames()
	{
		snakeMovement = new KeyFrame(Duration.seconds(0.1),
				e -> moveSnake());
		collision = new KeyFrame(Duration.seconds(0.1), e->checkCollision());
		showBonusFood = new KeyFrame(Duration.seconds((int)(Math.random() * 5) + 1), e-> showBonusFood());
		hideBonusFood = new KeyFrame(Duration.seconds((int)(Math.random() * 10) + 6), e->hideBonusFood());
	}
	
	private void createTimelines()
	{
		bonusLoop = new Timeline(showBonusFood,hideBonusFood);
		bonusLoop.setCycleCount(Timeline.INDEFINITE);
		loop = new Timeline(snakeMovement,collision);
		loop.setCycleCount(Timeline.INDEFINITE);
	}
	private void moveSnake() {
		snake.setDirection(direction);
		snake.increaseValue();
			if (snake.getHead().getY() < 0 || snake.getHead().getY() > 24 || snake.getHead().getX() < 0 || snake.getHead().getX() > 24) {
				snakeDead(scene, view);
			}
			
			for(SnakePartModel currentPart : snake.getList())
			{
				if(snake.getHead().getX() == currentPart.getX() && snake.getHead().getY() == currentPart.getY())
				{
					snakeDead(scene, view);
				}
			}
	}

	private void snakeDead(Scene scene, GameView view ) {
		stopLoop();
		view.getHighscorePane().setVisible(true);
		scene.setOnKeyPressed(e->returnToWelcomeWindow(scene));
	}

	private void returnToWelcomeWindow(Scene scene) {
		(new WelcomeScene()).show((Stage) scene.getWindow());
	}

	private void moveSnakeControl(KeyEvent e) {

		switch (e.getCode()) {

		case UP:

			if (snake.getDirection() != Direction.DOWN) {
				direction = Direction.UP;
			}
			break;

		case DOWN:

			if (snake.getDirection() != Direction.UP) {
				direction = Direction.DOWN;
			}
			break;

		case LEFT:

			if (snake.getDirection() != Direction.RIGHT) {
				direction = Direction.LEFT;
			}
			break;

		case RIGHT:

			if (snake.getDirection() != Direction.LEFT) {
				direction = Direction.RIGHT;
			}
			break;
		default:
			break;

		}
	}

	private void checkCollision() {
		
		if(snake.getHead().getX() == food.getX() && snake.getHead().getY() == food.getY())
		{
			snake.grow();
			highscore.increaseValue();
			generateFood();
		}
		
		if(snake.getHead().getX() == yin.getX() && snake.getHead().getY() == yin.getY())
		{
			highscore.increaseSpecialValue();
			yin.setVisible(false);
			generateYin();
		}
	}
	
	private void showBonusFood()
	{
		view.startAnimation();
		yin.generateRandomPosition();
		yin.setVisible(true);
		  
	}
	
	private void hideBonusFood()
	{
			yin.setVisible(false);
			view.stopAnimation();
	}
	
	private void generateFood()
	{
		food.generateRandomPosition();
		if(snake.getHead().getX() == food.getX() && snake.getHead().getY() == food.getY())
		{
			food.generateRandomPosition();
		}
		
		for(SnakePartModel currentPart : snake.getList())
		{
			if(food.getX() == currentPart.getX() && food.getY() == currentPart.getY())
			{
				food.generateRandomPosition();
			}
		}
		
		if(food.getX() == yin.getX() && food.getY() == yin.getY())
		{
			food.generateRandomPosition();
		}
	}
	
	private void generateYin()
	{
		yin.generateRandomPosition();
		if(snake.getHead().getX() == yin.getX() && snake.getHead().getY() == yin.getY())
		{
			yin.generateRandomPosition();
		}
		
		for(SnakePartModel currentPart : snake.getList())
		{
			if(yin.getX() == currentPart.getX() && yin.getY() == currentPart.getY())
			{
				yin.generateRandomPosition();
			}
		}
		
		if(food.getX() == yin.getX() && food.getY() == yin.getY())
		{
			food.generateRandomPosition();
		}
	}
	
	public void startLoop() {
		loop.play();
		bonusLoop.play();
	}

	private void stopLoop() {
		loop.stop();
		bonusLoop.stop();
	}
}
