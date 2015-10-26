package View;

import Model.FoodModel;
import Model.Layout;
import Model.SnakeModel;
import Model.YinYangFoodModel;
import Presenter.SnakeMovement;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**

 * Created by Duy on 20.10.2015.

 */
public class SnakeGameWindow {
	private Stage stage;
	private Scene scene;
	private int screenWidth;
	private int screenHeight;
	
	public SnakeGameWindow(Stage primaryStage)
	{
		this.stage = primaryStage;
		
		screenWidth = 500;
		screenHeight = 500;
		Layout layoutTest = new Layout(screenWidth,screenHeight);
		SnakeModel snake = new SnakeModel();
		FoodModel food = new FoodModel(layoutTest.getBlockSize(), screenWidth, screenHeight);
		YinYangFoodModel yin = new YinYangFoodModel(layoutTest.getBlockSize(), screenWidth, screenHeight);
		
		Pane foodPane = new Pane();
		foodPane.getChildren().addAll((food.getFood().getCircle()),yin.getYin().getRectangle());
		Pane snakePane = new Pane();
		snakePane.getChildren().addAll(snake.getObservableList());
		Pane allPane = new Pane();
		allPane.getChildren().addAll(foodPane, snakePane);

		scene = new Scene(allPane,screenWidth,screenHeight);

		
		SnakeMovement moveSnake = new SnakeMovement();
		moveSnake.moveSnake(scene,snake);
		
		stage.setScene(scene);
		stage.setTitle("Snake");

		
	}
	
	protected void showGameStage()
	{
		stage.show();
	}
	
	private void closeGameWindow() {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}
	
	public void returnToWelcomeWindow()
	{
		closeGameWindow();
		WelcomeWindow welWin = new WelcomeWindow(stage);
		welWin.showWelcomeWindow();
	}
	
	public Stage getStage()
	{
		return stage;
	}

	public Scene getScene() {
		return scene;
	}

}
