package Controller;

import Model.Layout;
import Model.SnakeModel;
import View.SnakeGameWindow;
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
	private Duration duration;
	private Direction direction;

	Layout layout = new Layout(500, 500);

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	public void moveSnake(Scene scene, SnakeModel snake) {
		KeyFrame frame = new KeyFrame(Duration.seconds(0.1));
		timeline = new Timeline();
		timeline.getKeyFrames().add(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);

		scene.setOnKeyPressed(e -> moveSnakeControl(e, snake));

	}

	private void moveSnakeControl(KeyEvent e, SnakeModel snake) {

		switch (e.getCode()) {

		case UP:

			snake.setYPos(snake.getYPos() - layout.getBlockSize());
			if (snake.getYPos() <= 0 - layout.getBlockSize())
				snakeDead();
			break;

		case DOWN:

			snake.setYPos(snake.getYPos() + layout.getBlockSize());
			if (snake.getYPos() > layout.getScreenHeight() - layout.getBlockSize())
				snakeDead();
			break;

		case LEFT:

			snake.setXPos(snake.getXPos() - layout.getBlockSize());
			if (snake.getXPos() <= 0 - layout.getBlockSize())
				snakeDead();
			break;

		case RIGHT:

			snake.setXPos(snake.getXPos() + layout.getBlockSize());
			if (snake.getXPos() > layout.getScreenWidth() - layout.getBlockSize())
				snakeDead();
			break;

		}
	}

	private void snakeDead() {
		SnakeGameWindow gameWindow = new SnakeGameWindow(null);
		gameWindow.returnToWelcomeWindow();
	}

}
