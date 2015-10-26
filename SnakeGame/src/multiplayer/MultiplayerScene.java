package multiplayer;

import framework.MyScene;
import javafx.scene.Parent;
import multiplayer.presenter.MultiplayerPresenter;
import multiplayer.view.MultiplayerView;

public class MultiplayerScene extends MyScene{

	private MultiplayerView view;
	private MultiplayerPresenter presenter;
	
	@Override
	protected void createModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Parent createView() {
		view = new MultiplayerView();
		return view;
	}

	@Override
	protected void createPresenter() {
		parent.setTitle("Multiplayer");
		presenter = new MultiplayerPresenter(view, parent);
		
	}

}
