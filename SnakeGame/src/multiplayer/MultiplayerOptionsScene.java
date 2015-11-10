package multiplayer;

import framework.MyScene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import multiplayer.presenter.MultiplayerOptionsPresenter;
import multiplayer.view.MultiplayerOptionsView;

public class MultiplayerOptionsScene extends MyScene {
	
	private MultiplayerOptionsView view;
	@SuppressWarnings("unused")
	private MultiplayerOptionsPresenter presenter;
	@Override
	protected void createModel() {
		//no model here
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

	@Override
	public void show(Stage parent) {
		super.show(parent);
		// start rotation!
		view.startRotation();
	}


}
