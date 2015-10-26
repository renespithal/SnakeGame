package Presenter;

import Model.Layout;
import Model.SnakeModel;
import Model.SnakeModel.Direction;
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
	
//	public SnakeMovement(WelcomeWindow snakeGame, SnakeModel snake)
//	{
//		moveSnake(snakeGame.getScene(), snake);
//	}

	private Timeline timeline = new Timeline();
	private KeyFrame keyframe;
	//hardcoded
	Layout layout = new Layout();

	public void moveSnake(Scene scene, SnakeModel snake) {
		keyframe = new KeyFrame(Duration.seconds(0.1),e-> moveSnake(snake, scene,timeline));
		timeline.getKeyFrames().add(keyframe);
		timeline.setCycleCount(Timeline.INDEFINITE);

		scene.setOnKeyPressed(e -> moveSnakeControl(e, snake));
		timeline.playFromStart();

	}
	
	private void moveSnake(SnakeModel snake, Scene scene,Timeline timeline )
	{
		Direction dir = snake.getDirection();
		if(dir == Direction.UP)
		{
			snake.setYPos(snake.getYPos() - layout.getBlockSize());
			if (snake.getYPos() <= 0 - layout.getBlockSize())
			{
				timeline.stop();
				snakeDead(scene,snake,timeline);
			}
		} 
		else if(dir == Direction.LEFT)
		{
			snake.setXPos(snake.getXPos() - layout.getBlockSize());
			if (snake.getXPos() <= 0 - layout.getBlockSize())
			{
				timeline.stop();
				snakeDead(scene,snake,timeline);
			}
		}
		else if(dir == Direction.RIGHT)
		{
			snake.setXPos(snake.getXPos() + layout.getBlockSize());
			if (snake.getXPos() > layout.getScreenWidth() - layout.getBlockSize())
			{
				timeline.stop();
				snakeDead(scene,snake,timeline);
			}
		}
		else if(dir == Direction.DOWN)
		{
			snake.setYPos(snake.getYPos() + layout.getBlockSize());
			if (snake.getYPos() > layout.getScreenHeight() - layout.getBlockSize())
			{
				timeline.stop();
				snakeDead(scene,snake,timeline);
			}
		}
	}

	private void moveSnakeControl(KeyEvent e, SnakeModel snake) {

		switch (e.getCode()) {

		case UP:

			if(snake.getDirection() != Direction.DOWN)
			{
			snake.setDirection(Direction.UP);
			}
			break;

		case DOWN:

			if(snake.getDirection() != Direction.UP)
			{
			snake.setDirection(Direction.DOWN);
			}
			break;

		case LEFT:

			if(snake.getDirection() != Direction.RIGHT)
			{
			snake.setDirection(Direction.LEFT);
			}
			break;

		case RIGHT:
	
			if(snake.getDirection() != Direction.LEFT)
			{
			snake.setDirection(Direction.RIGHT);
			}
			break;
		default:
			break;

		}
	}

	private void snakeDead(Scene scene, SnakeModel snake, Timeline timeline) {
		timeline.stop();
		Stage stage = (Stage) scene.getWindow();
		stage.close();
		WelcomeWindow welWin = new WelcomeWindow(stage);
		welWin.showWelcomeWindow();
	}

}
