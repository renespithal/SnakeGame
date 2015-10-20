package View;

import Controller.SnakeMovement;
import Model.FoodModel;
import Model.Layout;
import Model.SnakeModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**

 * Created by Duy on 20.10.2015.

 */
public class SnakeGameWindow {
	
	private Stage stage;
	private Button backButton;
	private Scene scene;
	private int screenWidth;
	private int screenHeight;
	
	public SnakeGameWindow(Stage primaryStage)
	{
		stage = new Stage();
//		backButton = new Button("Back");
//		backButton.setOnAction(e->returnToWelcomeWindow());

//		vBox = new VBox(backButton);
		
		screenWidth = 500;
		screenHeight = 500;
		Layout layoutTest = new Layout(screenWidth,screenHeight);
		SnakeModel snake = new SnakeModel();
		FoodModel food = new FoodModel(layoutTest.getBlockSize(), screenWidth, screenHeight);
		
		Pane pane = new Pane();
		pane.getChildren().addAll(snake.getObservableList());
		
		scene = new Scene(pane,screenWidth,screenHeight);	
		
		SnakeMovement moveSnake = new SnakeMovement(snake);
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
	
	private void returnToWelcomeWindow()
	{
		closeGameWindow();
		WelcomeWindow welWin = new WelcomeWindow(stage);
		welWin.showWelcomeWindow();
	}
	

}
