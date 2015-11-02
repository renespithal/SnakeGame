package multiplayer;

import framework.MyScene;
import javafx.scene.Parent;
import multiplayer.presenter.MultiplayerPresenter;
import multiplayer.view.MultiplayerView;
import network.client.model.ClientModel;

public class MultiplayerScene extends MyScene{

	private ClientModel model;
	private MultiplayerView view;
	private MultiplayerPresenter presenter;
	
	
	@Override
	protected void createModel() {
		model = new ClientModel(); 
		
	}

	@Override
	protected Parent createView() {
		view = new MultiplayerView(model);
		return view;
	}

	@Override
	protected void createPresenter() {
		parent.setTitle("Snake Multiplayer");
		presenter = new MultiplayerPresenter(view, parent);
		
	}

}
