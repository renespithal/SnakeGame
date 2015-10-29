package close.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CloseView extends VBox{
	
	private Label titleLabel;
	private Button backButton;
	private Button exitButton;
	
	public CloseView()
	{
		titleLabel = new Label("Do you really want to leave?");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(20));
		titleLabel.setTextFill(Color.GREEN);
		
		backButton = new Button("NOOOOOOOO!!!");
		backButton.setAlignment(Pos.CENTER);
		backButton.setMaxWidth(200);
		
		exitButton  = new Button ("Yes, exit the game");
		exitButton.setAlignment(Pos.CENTER);
		exitButton.setMaxWidth(200);

		this.getChildren().addAll(titleLabel,backButton,exitButton);
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
	
	}
	
	public Button getBackButton()
	{
		return backButton;
	}
	
	public Button getExitButton()
	{
		return exitButton;
	}

}
