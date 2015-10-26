package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//Abfrage, ob man das spiel wirklich verlassen möchte

public class CloseWindow{
	
	Stage stage;
	Label titleLabel;
	Button backButton;
	Button exitButton;
	VBox vBox;
	Scene scene;
	
	public CloseWindow(Stage primaryStage)
	{
		this.stage = primaryStage;
		
		titleLabel = new Label("Do you really want to leave?");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(20));
		titleLabel.setTextFill(Color.GREEN);
		Border border = new Border(new BorderStroke(Color.GREEN, null, null, null));
		titleLabel.setBorder(border);
		
		backButton = new Button("NOOOOOOOO!!!");
		backButton.setAlignment(Pos.CENTER);
		backButton.setMaxWidth(200);
		backButton.setOnAction(e->returnToWelcomeWindow());
		
		exitButton  = new Button ("Yes, exit the game");
		exitButton.setAlignment(Pos.CENTER);
		exitButton.setMaxWidth(200);
		exitButton.setOnAction(e -> closeCloseWindow());

		vBox = new VBox(titleLabel,backButton,exitButton);
		vBox.setSpacing(10);
		vBox.setAlignment(Pos.TOP_CENTER);
		scene = new Scene(vBox,500,500);	
		
		stage.setScene(scene);
		stage.setTitle("Exit");
	}
	
	protected void showCloseStage()
	{
		stage.show();
	}
	
	private void closeCloseWindow() {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}
	
	private void returnToWelcomeWindow()
	{
		closeCloseWindow();
		WelcomeWindow welWin = new WelcomeWindow(stage);
		welWin.showWelcomeWindow();
	}

}