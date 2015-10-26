package multiplayer.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MultiplayerView extends VBox {
	
	private Button backButton;
	
	public MultiplayerView()
	{
		backButton = new Button("Back to Welcome Window");
		
		this.getChildren().addAll(backButton);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
	}
	
	public Button getBackButton()
	{
		return backButton;
	}

}
