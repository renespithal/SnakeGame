package multiplayer;

import framework.MyScene;
import javafx.scene.Parent;
import multiplayer.presenter.MultiplayerOptionsPresenter;
import multiplayer.view.MultiplayerOptionsView;

public class MultiplayerOptionsScene extends MyScene {
	
	private MultiplayerOptionsView view;
	private MultiplayerOptionsPresenter presenter;
	@Override
	protected void createModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Parent createView() {
		view = new MultiplayerOptionsView();
		return view;
	}

	@Override
	protected void createPresenter() {
		parent.setTitle("Snake Multiplayer");
		presenter = new MultiplayerOptionsPresenter(view, parent);
		
	}

}
