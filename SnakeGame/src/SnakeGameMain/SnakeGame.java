package SnakeGameMain;

import View.WelcomeWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeGame extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		@SuppressWarnings("unused")
		WelcomeWindow welcomeWindow = new WelcomeWindow(primaryStage);
		
		primaryStage.show();

	}

	public static void main(String[] args) {

		System.out.println("Starts JavaFX...");
		launch(args);
		System.out.println("JavaFX is finished.");
	}
}
