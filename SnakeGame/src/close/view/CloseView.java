package close.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;

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
		
		exitButton  = new Button ("Yes,bye");
		exitButton.setAlignment(Pos.CENTER);
		exitButton.setMaxWidth(200);

		//Background
		BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/background3.jpg",500,500,false,false),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		this.getChildren().addAll(titleLabel,backButton,exitButton);
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		this.setBackground(new Background(backgrd));

	
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
