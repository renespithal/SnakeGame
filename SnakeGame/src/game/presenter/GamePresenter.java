package game.presenter;


import game.GameScene;
import game.model.FoodModel;
import game.model.GameModel;
import game.model.HighscoreModel;
import game.model.SnakeModel;
import game.model.SnakeModel.Direction;
import game.model.YinYangFoodModel;
import game.view.GameView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import welcome.WelcomeScene;

public class GamePresenter {
	private GameModel model;
	private GameView view;
	private Timeline loop;
	private KeyFrame snakeMovement;
	private KeyFrame collision;
	private KeyFrame grow;
	public GamePresenter(GameModel model, GameView view, GameScene scene) {
		this.model = model;
		this.view = view;

		// TODO create loop properly:
		snakeMovement = new KeyFrame(Duration.seconds(0.1),
				e -> moveSnake(model.getSnake(),scene,view));
		collision = new KeyFrame(Duration.seconds(0.1), e->checkCollision(model.getSnake(), model.getFood(), model.getYinYang(),model.getHighscore()));
		
		loop = new Timeline(snakeMovement,collision);
		loop.setCycleCount(Timeline.INDEFINITE);
		scene.setOnKeyPressed(e -> moveSnakeControl(e, model.getSnake()));
	}

	private void moveSnake(SnakeModel snake,Scene scene, GameView view) {

		snake.increaseValue();
			if (snake.getHead().getY() < 0 || snake.getHead().getY() > 24 || snake.getHead().getX() < 0 || snake.getHead().getX() > 24) {
				snakeDead(scene, view);
			}
	}

	private void snakeDead(Scene scene, GameView view) {
		stopLoop();
		view.getHighscorePane().setVisible(true);
		scene.setOnKeyPressed(e->returnToWelcomeWindow(scene));
	}

	private void returnToWelcomeWindow(Scene scene) {
		(new WelcomeScene()).show((Stage) scene.getWindow());
	}

	private void moveSnakeControl(KeyEvent e, SnakeModel snake) {

		switch (e.getCode()) {

		case UP:

			if (snake.getDirection() != Direction.DOWN) {
				snake.setDirection(Direction.UP);
			}
			break;

		case DOWN:

			if (snake.getDirection() != Direction.UP) {
				snake.setDirection(Direction.DOWN);
			}
			break;

		case LEFT:

			if (snake.getDirection() != Direction.RIGHT) {
				snake.setDirection(Direction.LEFT);
			}
			break;

		case RIGHT:

			if (snake.getDirection() != Direction.LEFT) {
				snake.setDirection(Direction.RIGHT);
			}
			break;
		default:
			break;

		}
	}

	private void checkCollision(SnakeModel snake, FoodModel food, YinYangFoodModel yin,HighscoreModel highscore) {
		
		if(snake.getHead().getX() == food.getX() && snake.getHead().getY() == food.getY())
		{
			snake.grow();
			highscore.increaseValue();
			if (highscore.getValue()%20==0 || highscore.getValue() ==0){
				yin.generateRandomPosition();
			}
			food.generateRandomPosition();
		}
		
		if(snake.getHead().getX() == yin.getX() && snake.getHead().getY() == yin.getY())
		{
			highscore.increaseSpecialValue();
			if (highscore.getValue()%20 == 0){
			yin.generateRandomPosition();}
		}
		 if (highscore.getValue()%20 != 0){
			yin.deletePosition();}


	}
	
	public void startLoop() {
		loop.play();
	}

	public void stopLoop() {
		loop.stop();
	}
}
