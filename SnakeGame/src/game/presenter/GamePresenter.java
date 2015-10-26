package game.presenter;

import game.model.FoodModel;
import game.model.GameModel;
import game.model.SnakeModel;
import game.model.SnakeModel.Direction;
import game.model.YinYangFoodModel;
import game.view.GameView;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.geometry.Bounds;
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
	private KeyFrame bonusFood;
	private KeyFrame collision;
	public GamePresenter(GameModel model, GameView view, Scene scene) {
		this.model = model;
		this.view = view;

		// TODO create loop properly:
		snakeMovement = new KeyFrame(Duration.seconds(0.1),
				e -> moveSnake(model.getSnake(),scene));
		collision = new KeyFrame(Duration.seconds(0.01), e->checkCollision(model.getSnake(), model.getFood(), model.getYinYang()));
//		bonusFood = new KeyFrame(Duration.seconds(5), e-> bonusFoodEffect(model.getYinYang()));
		loop = new Timeline(snakeMovement,collision);
		loop.setCycleCount(Timeline.INDEFINITE);

		// TODO logic; if snake dies, stop loop and create new welcomeScene ->
		// show(parent)

		scene.setOnKeyPressed(e -> moveSnakeControl(e, model.getSnake()));
	}

	private void moveSnake(SnakeModel snake,Scene scene) {
		Direction dir = snake.getDirection();
		if (dir == Direction.UP) {
			snake.setYPos(snake.getYPos() - 20);
			if (snake.getYPos() <= 0 - 20) {
				stopLoop();
				snakeDead(scene);
			}
		} else if (dir == Direction.LEFT) {
			snake.setXPos(snake.getXPos() - 20);
			if (snake.getXPos() <= 0 - 20) {
				stopLoop();
				snakeDead(scene);
			}
		} else if (dir == Direction.RIGHT) {
			snake.setXPos(snake.getXPos() + 20);
			if (snake.getXPos() > 500 - 20) {
				stopLoop();
				snakeDead(scene);
			}
		} else if (dir == Direction.DOWN) {
			snake.setYPos(snake.getYPos() + 20);
			if (snake.getYPos() > 500 - 20) {
				stopLoop();
				snakeDead(scene);
			}
		}
	}

	private void snakeDead(Scene scene) {
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

	private void checkCollision(SnakeModel snake, FoodModel food, YinYangFoodModel yin) {
		
//		if (snake.getXPos() == food.getTranslateX() && snake.getYPos() == food.getTranslateY()) {
//
//			food.setTranslateX((int) (Math.random() * (500 - 20)) / 20 * 20);
//
//			food.setTranslateY((int) (Math.random() * (500 - 20)) / 20 * 20);
//			
//		}
		
		Bounds snakeBounds = snake.getHead().getRectangle().getBoundsInParent();
		Bounds foodBounds = food.getFood().getCircle().getBoundsInParent();

		if(snakeBounds.intersects(foodBounds))
		{
			food.setTranslateX((int) (Math.random() * (500 - 20)) / 20 * 20);
			food.setTranslateY((int) (Math.random() * (500 - 20)) / 20 * 20);
		}
			
			
		if (snake.getXPos() == yin.getXPos() && snake.getYPos() == yin.getYPos()) {

			yin.setXPos((int) (Math.random() * (500 - 20)) / 20 * 20);
			yin.setYPos((int) (Math.random() * (500 - 20)) / 20 * 20);
		}
	}
//	private void bonusFoodEffect(YinYangFoodModel yin)
//	{
//		  FadeTransition t = new FadeTransition(Duration.seconds(4),yin.getYin().getRectangle());
//	        t.setFromValue(0);
//	        t.setToValue(90);
//	        t.setCycleCount(Transition.INDEFINITE);
//	        t.setAutoReverse(false);
//	        t.setInterpolator(Interpolator.LINEAR);
//	        t.play();
//	}
	public void startLoop() {
		loop.play();
	}

	public void stopLoop() {
		loop.stop();
	}
}
