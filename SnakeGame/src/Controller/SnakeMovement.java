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

	private Timeline timeline;
	private KeyFrame keyframe;
	private Duration duration;
	private Direction direction;

	Layout layout = new Layout(500,500);
	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT
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
			if(snake.getYPos() <= 0-layout.getBlockSize()) System.out.println("tot");
			break;

		case DOWN:

			snake.setYPos(snake.getYPos() + layout.getBlockSize());
			if(snake.getYPos() > layout.getScreenHeight() - layout.getBlockSize()) System.out.println("tot");
			break;

		case LEFT:

			snake.setXPos(snake.getXPos() - layout.getBlockSize());
			if(snake.getXPos() <= 0-layout.getBlockSize()) System.out.println("tot");
			break;

		case RIGHT:

			snake.setXPos(snake.getXPos() + layout.getBlockSize());
			if(snake.getXPos() > layout.getScreenWidth() - layout.getBlockSize()) System.out.println("tot");
			break;

		}
	}
	
}
