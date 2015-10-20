package Controller;

import Model.Layout;
import Model.SnakeModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**

 * Created by Duy on 21.10.2015.

 */
public class SnakeMovement {

	private boolean moved;
	private boolean running;
	private Timeline timeline;
	private KeyFrame keyframe;
	private Duration duration;
	private Direction direction;

	Layout layout = new Layout();
	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	public SnakeMovement(SnakeModel snake) {
		this.moved = false;
		this.running = false;
	}

	public void moveSnake(Scene scene, SnakeModel snake) {
		KeyFrame frame = new KeyFrame(Duration.seconds(0.1));
		timeline = new Timeline();
		timeline.getKeyFrames().add(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        
		scene.setOnKeyPressed(e->moveSnakeControl(e,snake));

	}

	private void moveSnakeControl(KeyEvent e,SnakeModel snake)
	{
		
		switch (e.getCode()) {

		case UP:
			
			snake.setYPos(snake.getYPos() - layout.getBlockSize());
			break;

		case DOWN:

			snake.setYPos(snake.getYPos() + layout.getBlockSize());
			break;

		case LEFT:

			snake.setXPos(snake.getXPos() - layout.getBlockSize());
			break;

		case RIGHT:

			snake.setXPos(snake.getXPos() + layout.getBlockSize());
			break;

		}
	}
	
}
