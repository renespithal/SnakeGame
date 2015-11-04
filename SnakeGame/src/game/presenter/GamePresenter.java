package game.presenter;


import framework.MyScene;
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
import options.Options;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.FileUtils;
import welcome.WelcomeScene;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class GamePresenter {
	private Timeline loop;
	private Timeline bonusLoop;
	private KeyFrame snakeMovement;
	private KeyFrame showBonusFood;
	private KeyFrame hideBonusFood;
	private KeyFrame collision;
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
		collision = new KeyFrame(Options.speed, e->checkCollision());
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
	
	protected void moveSnake() {
		snake.setDirection(direction);
		snake.increaseValue();
	}

	protected void snakeDead() {
		stopLoop();
		view.getHighscorePane().setVisible(true);
        highscore.playernameProperty().bind(view.textField.textProperty());
		//scene.setOnKeyPressed(e->returnToWelcomeWindow(scene));
		scene.setOnKeyPressed(e -> {
            saveHisghscore();
            returnToWelcomeWindow(scene);
        });
	}

	private void saveHisghscore() {
		Properties properties = new Properties();

		try(FileInputStream is = new FileInputStream("res/Highscore.properties")) {
			properties.load(is);
		} catch (IOException e) {}

		properties.put(highscore.getPlayername(), String.valueOf(highscore.getValue()));
		try(FileWriter writer = new FileWriter("res/Highscore.properties")) {
			properties.store(writer, "highscore snake");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*private void saveHisghscore() {
        String jsonData = FileUtils.readFile("res/Highscore.json");
        JSONObject jobj = new JSONObject(jsonData);

        JSONArray jsonArray;
        if (jobj.has("highscore")){
            jsonArray = jobj.getJSONArray("highscore");
        }
        else {
            jsonArray = new JSONArray();
        }

        JSONObject newhighscore = new JSONObject();
        newhighscore.put(highscore.getPlayername(),highscore.getValue());
        jsonArray.put(newhighscore);

        jobj.put("highscore",jsonArray);

        try (FileWriter fw= new FileWriter("res/Highscore.json")){
            fw.write(jobj.toString());
            fw.flush();
        } catch (IOException e){
            e.printStackTrace();
        };

    }
    */

    protected void returnToWelcomeWindow(Scene scene) {
		(new WelcomeScene()).show((Stage) scene.getWindow());
	}

	protected void moveSnakeControl(KeyEvent e) {

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

	protected void checkCollision() {
		
		if (snake.getHead().getY() < 0 || snake.getHead().getY() > 24 || snake.getHead().getX() < 0 || snake.getHead().getX() > 24) {
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
	
	protected void showBonusFood()
	{
		view.startAnimation();
		yin.generateRandomPosition();
		yin.setVisible(true);
		  
	}
	
	protected void hideBonusFood()
	{
			yin.setVisible(false);
		    yin.deletePosition();
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

	protected void stopLoop() {
		loop.stop();
		bonusLoop.stop();
	}
}
