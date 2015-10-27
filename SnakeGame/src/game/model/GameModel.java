package game.model;

public class GameModel {
	
	private SnakeModel snake;
	private FoodModel food;
	private YinYangFoodModel yin;
	private HighscoreModel highscore;
	
	public GameModel()
	{
		snake = new SnakeModel();
		food = new FoodModel();
		yin = new YinYangFoodModel();
		highscore = new HighscoreModel();
	}
	
	public SnakeModel getSnake()
	{
		return snake;
	}

	public FoodModel getFood()
	{
		return food;
	}
	
	public YinYangFoodModel getYinYang()
	{
		return yin;
	}
	
	public HighscoreModel getHighscore()
	{
		return highscore;
	}
}
