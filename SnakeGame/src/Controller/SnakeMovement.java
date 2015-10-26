package Controller;

import Model.Layout;
import Model.SnakeModel;
import View.WelcomeWindow;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * Created by Duy on 21.10.2015.
 * 
 */
public class SnakeMovement {

	private Timeline timeline;
	private KeyFrame keyframe;
	private Direction direction;

	//hardcoded
	Layout layout = new Layout(500, 500);

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	public void moveSnake(Scene scene, SnakeModel snake) {
		keyframe = new KeyFrame(Duration.seconds(0.2));
		timeline = new Timeline();
		timeline.getKeyFrames().add(keyframe);
		timeline.setCycleCount(Timeline.INDEFINITE);

		scene.setOnKeyPressed(e -> moveSnakeControl(e, snake,scene));

	}

	private void moveSnakeControl(KeyEvent e, SnakeModel snake, Scene scene) {

		switch (e.getCode()) {

		case UP:

			snake.setYPos(snake.getYPos() - layout.getBlockSize());
			if (snake.getYPos() <= 0 - layout.getBlockSize())
			{
				snakeDead(scene);
			}
			break;

		case DOWN:

			snake.setYPos(snake.getYPos() + layout.getBlockSize());
			if (snake.getYPos() > layout.getScreenHeight() - layout.getBlockSize())
			{
				snakeDead(scene);
			}
			break;

		case LEFT:

			snake.setXPos(snake.getXPos() - layout.getBlockSize());
			if (snake.getXPos() <= 0 - layout.getBlockSize())
			{
				snakeDead(scene);
			}
			break;

		case RIGHT:
	
			snake.setXPos(snake.getXPos() + layout.getBlockSize());
			if (snake.getXPos() > layout.getScreenWidth() - layout.getBlockSize())
			{
				snakeDead(scene);
			}
			break;
		default:
			break;

		}
	}

	private void snakeDead(Scene scene) {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
		WelcomeWindow welWin = new WelcomeWindow(stage);
		welWin.showWelcomeWindow();
	}

}
