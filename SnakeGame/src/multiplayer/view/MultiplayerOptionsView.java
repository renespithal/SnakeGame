package multiplayer.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MultiplayerOptionsView extends BorderPane {

	private Button localButton;
	private Button onlineButton;
	private Button backButton;
	
	public MultiplayerOptionsView()
	{
		localButton = new Button("Start local multiplayer game");
		localButton.setAlignment(Pos.CENTER);
		onlineButton = new Button("Start online multiplayer game");
		onlineButton.setAlignment(Pos.CENTER);
		backButton = new Button("back to welcome window");
		backButton.setAlignment(Pos.CENTER);
		
		VBox vBox = new VBox(localButton,onlineButton,backButton);
		vBox.setAlignment(Pos.CENTER);
		
		this.setCenter(vBox);
	}
	
	public Button getLocalButton() {
		return localButton;
	}
	
	public Button getOnlineButton() {
		return onlineButton;
	}
	
	public Button getBackButton() {
		return backButton;
	}
}
