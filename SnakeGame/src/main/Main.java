package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import welcome.WelcomeScene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
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
