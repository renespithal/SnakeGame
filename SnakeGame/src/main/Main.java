package main;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import welcome.WelcomeScene;
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		(new WelcomeScene()).show(primaryStage);
		primaryStage.getIcons().add(new Image("file:src/images/yinyanyolologo.jpg")); // Icon on Window
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
