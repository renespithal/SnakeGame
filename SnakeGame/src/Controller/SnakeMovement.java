package Controller;

import Model.SnakeModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SnakeMovement {

	private boolean moved;
	private boolean running;
	private Timeline timeline;
	private KeyFrame keyframe;
	private Duration duration;
	private SnakeModel snake;

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	public SnakeMovement()
	{
		this.moved = false;
		this.running = false;
	}
	
	

}
