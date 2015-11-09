package game.presenter;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import framework.MyScene;
import game.model.FoodModel;
import game.model.GameModel;
import game.model.SnakeModel;
import game.model.SnakeModel.Direction;
import game.model.SnakePartModel;
import game.model.YinYangFoodModel;
import game.view.GameView;
import highscore.HighscoreScene;
import highscore.model.HighscoreModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import options.Options;
import welcome.WelcomeScene;

public class GamePresenter {
	private Timeline loop;
	private Timeline bonusLoop;
	private Timeline deadSnake;
	private KeyFrame snakeMovement;
	private KeyFrame showBonusFood;
	private KeyFrame hideBonusFood;
	private KeyFrame collision;
	private KeyFrame disposeSnake;
	protected Direction direction;

	private GameView view;
	protected FoodModel food;
	protected SnakeModel snake;
	protected YinYangFoodModel yin;
	protected HighscoreModel highscore;
	private Scene scene;

	
	public GamePresenter(GameModel model, GameView view, MyScene scene) {
		this.view = view;
		this.food = model.getFood();
		this.snake = model.getSnake();
		this.yin = model.getYinYang();
		this.highscore = model.getHighscore();
		this.scene = scene;
		
		direction = snake.getDirection();
		this.scene.setOnKeyPressed(e -> moveSnakeControl(e));
		
		createKeyFrames();
		createTimelines();

	}

	private void createKeyFrames()
	{
		snakeMovement = new KeyFrame(Options.speed, e -> moveSnake());
		collision = new KeyFrame(Options.speed, e->checkCollision(view));
		showBonusFood = new KeyFrame(Duration.seconds((int)(Math.random() * 5) + 1), e-> showBonusFood());
		hideBonusFood = new KeyFrame(Duration.seconds((int)(Math.random() * 10) + 6), e->hideBonusFood());
		disposeSnake = new KeyFrame(Duration.seconds(0.1), e-> disposeSnake());
	}
	
	private void createTimelines()
	{
		bonusLoop = new Timeline(showBonusFood,hideBonusFood);
		bonusLoop.setCycleCount(Timeline.INDEFINITE);
		loop = new Timeline(snakeMovement,collision);
		loop.setCycleCount(Timeline.INDEFINITE);
		deadSnake = new Timeline(disposeSnake);
		deadSnake.setCycleCount(1);
	}
	
	protected void moveSnake() {
		snake.setDirection(direction);
		snake.increaseValue();
	}

	protected void snakeDead() {
//		view.getSnakeHead().setVisible(false);
		startDisposeSnake();
		view.stopAnimation();
		stopLoop();
		view.playGameOverMusic();
		view.getHighscorePane().setVisible(true);
        highscore.playernameProperty().bind(view.textField.textProperty());
		scene.setOnKeyPressed(e -> enterHighscore(e));
	}

    private void enterHighscore(KeyEvent e)
    {

        if (e.getCode() == KeyCode.ENTER){
            saveHisghscore();
            returnToHighscore(scene);
            stopDisposeSnake();
        }
    }

	protected void stopDisposeSnake() {
		deadSnake.stop();
	}

	protected void startDisposeSnake() {
		deadSnake.play();
	}

	protected void disposeSnake()
	{
		for( Node body : view.getSnakePane().getChildren())
		{
			view.fade(body);
			view.startDisposeAnimation();
		}
	}

	private void saveHisghscore() {
		Properties properties = new Properties();

		try(FileInputStream is = new FileInputStream("res/Highscore.properties")) {
			properties.load(is);
		} catch (IOException e) {}

		properties.put(highscore.getPlayername(), String.valueOf(highscore.getValue())); //Value to String

        try(FileWriter writer = new FileWriter("res/Highscore.properties")) {
			properties.store(writer, "highscore snake");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


    protected void returnToHighscore(Scene scene) {
		(new HighscoreScene()).show((Stage) scene.getWindow());
	}

	protected void moveSnakeControl(KeyEvent e) {

		switch (e.getCode()) {

		case W:

			if (snake.getDirection() != Direction.DOWN) {
				direction = Direction.UP;
			}
			break;

		case S:

			if (snake.getDirection() != Direction.UP) {
				direction = Direction.DOWN;
			}
			break;

		case A:

			if (snake.getDirection() != Direction.RIGHT) {
				direction = Direction.LEFT;
			}
			break;

		case D:

			if (snake.getDirection() != Direction.LEFT) {
				direction = Direction.RIGHT;
			}
			break;
		default:
			break;

		}
	}

	protected void checkCollision(GameView view) {
		
		if (snake.getHead().getY() < 1 || snake.getHead().getY() > 23 || snake.getHead().getX() < 1 || snake.getHead().getX() > 23) {
			snakeDead();
		}
		
		for(SnakePartModel currentPart : snake.getList())
		{
			if(snake.getHead().getX() == currentPart.getX() && snake.getHead().getY() == currentPart.getY())
			{
				snakeDead();
			}
		}
		
		if(snake.getHead().getX() == food.getX() && snake.getHead().getY() == food.getY())
		{
			snake.grow();
			view.playFoodMusic();
			highscore.increaseValue();
			generateFood();
		}
		
		if(snake.getHead().getX() == yin.getX() && snake.getHead().getY() == yin.getY())
		{
			highscore.increaseSpecialValue();
			view.playBonusFoodMusic();
			yin.setVisible(false);
			generateYin();
		}
	}
	
	protected void showBonusFood()
	{
		view.startAnimation();
        yin.setVisible(true);
		yin.generateRandomPosition();
		  
	}
	
	protected void hideBonusFood()
	{
            yin.deletePosition();
			yin.setVisible(false);
			view.stopAnimation();
	}
	
	protected void generateFood()
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
	
	protected void generateYin()
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

	public void stopLoop() {
		loop.stop();
		bonusLoop.stop();
	}
}
