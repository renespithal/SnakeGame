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

public class GamePresenter {
	private Timeline loop;
	private Timeline bonusLoop;
	private Timeline deadSnake;
	private Timeline moveSnake;
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

	/**
	 * Creates the presenter of the game.
	 * 
	 * @param model
	 *            contains all important information for the game
	 * @param view
	 *            contains the view of the game
	 * @param scene
	 *            to get the key event
	 */
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

	private void createKeyFrames() {
		snakeMovement = new KeyFrame(Options.speed, e -> moveSnake());
		collision = new KeyFrame(Options.speed, e -> checkCollision(view));
		showBonusFood = new KeyFrame(Duration.seconds((int) (Math.random() * 5) + 1), e -> showBonusFood());
		hideBonusFood = new KeyFrame(Duration.seconds((int) (Math.random() * 10) + 6), e -> hideBonusFood());
		disposeSnake = new KeyFrame(Duration.seconds(0.1), e -> disposeSnake());
	}

	private void createTimelines() {
		bonusLoop = new Timeline(showBonusFood, hideBonusFood);
		bonusLoop.setCycleCount(Timeline.INDEFINITE);
		loop = new Timeline(collision);
		loop.setCycleCount(Timeline.INDEFINITE);
		moveSnake = new Timeline(snakeMovement);
		moveSnake.setCycleCount(Timeline.INDEFINITE);
		deadSnake = new Timeline(disposeSnake);
		deadSnake.setCycleCount(1);
	}

	/**
	 * Sets the new direction of the snake.
	 */
	protected void moveSnake() {
		snake.setDirection(direction);
		snake.increaseValue();
	}

	protected void snakeDead() {
		startDisposeSnake();
		view.stopAnimation();
		stopLoop();
		view.playGameOverMusic();
		view.getHighscorePane().setVisible(true);
		highscore.playernameProperty().bind(view.getTextField().textProperty());
		scene.setOnKeyPressed(e -> enterHighscore(e));
	}

	/**
	 * Saves the highscore.
	 * 
	 * @param e
	 *           key which needs to be press
	 */
	private void enterHighscore(KeyEvent e) {
		if (!(view.getTextField().getText().trim().isEmpty())) {
			if (e.getCode() == KeyCode.ENTER) {
				saveHisghscore();
				returnToHighscore(scene);
				stopDisposeSnake();
			}
		}
	}

	protected void stopDisposeSnake() {
		deadSnake.stop();
	}

	protected void startDisposeSnake() {
		deadSnake.play();
	}

	/**
	 * Adds the fade transition to all parts of the snake.
	 */
	protected void disposeSnake() {
		for (Node body : view.getSnakePane().getChildren()) {
			view.fade(body);
			view.startDisposeAnimation();
		}
	}

	/**
	 * Save the highscore and player name in an additional file.
	 */
	private void saveHisghscore() {
		Properties properties = new Properties();

		try (FileInputStream is = new FileInputStream("res/Highscore.properties")) {
			properties.load(is);
		} catch (IOException e) {
		}


		properties.put(highscore.getPlayername(), String.valueOf(highscore.getValue()));
		properties.put(highscore.getPlayername(), String.valueOf(highscore.getValue()));


		try (FileWriter writer = new FileWriter("res/Highscore.properties")) {
			properties.store(writer, "highscore snake");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void returnToHighscore(Scene scene) {
		(new HighscoreScene()).show((Stage) scene.getWindow());
	}

	/**
	 * Depending which key is pressed(W,S,A,D) the snake is moving.
	 * 
	 * @param e
	 *            the direction in which the snake head is heading
	 */
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

	/**
	 * Checks the collision of the snake with the wall/body/food.
	 * 
	 * @param view
	 *            the view of the snake game
	 */
	protected void checkCollision(GameView view) {

		if (snake.getHead().getY() < 1 || snake.getHead().getY() > 23 || snake.getHead().getX() < 1
				|| snake.getHead().getX() > 23) {
			snakeDead();
		}

		for (SnakePartModel currentPart : snake.getList()) {
			if (snake.getHead().getX() == currentPart.getX() && snake.getHead().getY() == currentPart.getY()) {
				snakeDead();
			}
		}

		if (snake.getHead().getX() == food.getX() && snake.getHead().getY() == food.getY()) {
			snake.grow();
			view.playFoodMusic();
			highscore.increaseValue();
			generateFood();
		}

		if (snake.getHead().getX() == yin.getX() && snake.getHead().getY() == yin.getY()) {
			highscore.increaseSpecialValue();
			view.playBonusFoodMusic();
			yin.setVisible(false);
		}
	}

	/**
	 * Set the visible of the bonus food on true and start the animation.
	 */
	protected void showBonusFood() {
		generateYin();
		yin.setVisible(true);
		view.startAnimation();

	}

	/**
	 * Sets the visible of the bonus food on false and stop the animation.
	 */
	protected void hideBonusFood() {
		yin.deletePosition();
		yin.setVisible(false);
		view.stopAnimation();
	}

	/**
	 * Generates the the food and check if the position would collision with other objects.
	 */
	protected void generateFood() {
		food.generateRandomPosition();
		if (snake.getHead().getX() == food.getX() && snake.getHead().getY() == food.getY()) {
			generateFood();
		}

		for (SnakePartModel currentPart : snake.getList()) {
			if (food.getX() == currentPart.getX() && food.getY() == currentPart.getY()) {
				generateFood();
			}
		}

		if (food.getX() == yin.getX() && food.getY() == yin.getY()) {
			generateFood();
		}
	}

	/**
	 * Generates the the bonus food and check if the position would collision with other objects.
	 */
	protected void generateYin() {
		yin.generateRandomPosition();
		if (snake.getHead().getX() == yin.getX() && snake.getHead().getY() == yin.getY()) {
			generateYin();
		}

		for (SnakePartModel currentPart : snake.getList()) {
			if (yin.getX() == currentPart.getX() && yin.getY() == currentPart.getY()) {
				generateYin();
			}
		}

		if (yin.getX() == food.getX() && yin.getY() == food.getY()) {
			generateYin();
		}
	}

	public void startLoop() {
		moveSnake.play();
		loop.play();
		bonusLoop.play();
	}

	public void stopLoop() {
		moveSnake.stop();
		loop.stop();
		bonusLoop.stop();
	}

	protected void stopMoveSnake() {
		moveSnake.stop();
	}
}
