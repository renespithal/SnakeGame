package main;

import javafx.application.Application;
import javafx.stage.Stage;
import welcome.WelcomeScene;
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		(new WelcomeScene()).show(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
