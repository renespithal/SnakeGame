package multiplayer.onlineMultiplayer.presenter;

import javafx.stage.Stage;
import multiplayer.MultiplayerOptionsScene;
import multiplayer.onlineMultiplayer.view.MultiplayerView;
import network.server.presenter.ServerPresenter;
import network.server.view.ServerView;

public class MultiplayerPresenter {
	
	private MultiplayerView view;
	private Stage stage;
	private ServerPresenter serverPresenter;
	
	public MultiplayerPresenter(MultiplayerView view, Stage stage)
	{
		this.view = view;
		this.stage = stage;
		this.serverPresenter = new ServerPresenter((ServerView) view.getServerTab());
		
		view.getBackButton().setOnAction(e->returnToMultiplayerOptionsWindow());
	}

	private void returnToMultiplayerOptionsWindow() {
		(new MultiplayerOptionsScene()).show(stage);
	}
}
