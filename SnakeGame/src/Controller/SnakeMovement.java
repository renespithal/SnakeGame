package Controller;

import Model.Layout;
import Model.SnakeModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SnakeMovement {

	private boolean moved;
	private boolean running;
	private Timeline timeline;
	private KeyFrame keyframe;
	private Duration duration;
	private SnakeModel snake;
	private Direction direction;

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	public SnakeMovement() {
		this.moved = false;
		this.running = false;
		moveSnake();
		startGame();
	}

	public void moveSnake() {
		keyframe = new KeyFrame(Duration.seconds(0.1), e -> moveSnakeControl());
		timeline = new Timeline();

		timeline.getKeyFrames().add(keyframe);
		timeline.setCycleCount(Timeline.INDEFINITE);
	}

	public void moveSnakeControl() {
		SnakeModel snake = new SnakeModel();
		Layout layout = new Layout();
		
		int xPos = snake.getXPos();
		int yPos = snake.getYPos();
		
		if (!running)

			return;

		switch (direction) {

		case UP:

			break;

		case DOWN:


			break;

		case LEFT:

		
			break;

		case RIGHT:

			snake.setXPos(snake.getXPos() + layout.getBlockSize());

			break;

		}

	}

	public void startGame() {

		direction = Direction.RIGHT;
		timeline.play();
		running = true;
		moved = true;
	}

}
