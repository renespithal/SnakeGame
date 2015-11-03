package multiplayer.onlineMultiplayer.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import network.client.model.ClientModel;
import network.client.view.ClientView;
import network.server.view.ServerView;

public class MultiplayerView extends BorderPane {
	
	private Button backButton;
	private TabPane tabPane;
	private Tab clientTab;
	private Tab serverTab;
	
	public MultiplayerView(ClientModel model)
	{
		backButton = new Button("Back");
		serverTab = new ServerView();
		clientTab = new ClientView(model);
		tabPane = new TabPane(serverTab,clientTab);
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		VBox buttonBox = new VBox(backButton);
		buttonBox.setAlignment(Pos.BOTTOM_LEFT);
		
		this.setTop(tabPane);
		this.setBottom(buttonBox);

	}
	
	public Button getBackButton()
	{
		return backButton;
	}
	
	public Tab getServerTab() {
		return serverTab;
	}
	
	public Tab getClientTab() {
		return clientTab;
	}

}
