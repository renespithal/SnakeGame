package game.model;

public class GameModel {
	
	private SnakeModel snake;
	private FoodModel food;
	private YinYangFoodModel yin;
	public GameModel()
	{
		snake = new SnakeModel();
		food = new FoodModel();
		yin = new YinYangFoodModel();
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
}
