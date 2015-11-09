package options;


import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Options {
	
	//speed selection for snake
	public static final Duration SLOW = Duration.seconds(0.2);
	public static final Duration MEDIUM = Duration.seconds(0.1);
	public static final Duration FAST = Duration.seconds(0.05);
	
	public static Duration speed = MEDIUM;
	
	//color selection for snake
	public static final Color GREEN = Color.GREEN;
	public static final Color RED = Color.RED;
	public static final Color BLUE = Color.BLUE;
	public static final Color YELLOW = Color.YELLOW;
	public static final Color BLACK = Color.BLACK;
	
	public static Color color = Color.GREEN;
	
	
}
