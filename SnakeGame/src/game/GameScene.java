package game;

import framework.MyScene;
import game.model.GameModel;
import game.presenter.GamePresenter;
import game.view.GameView;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class GameScene extends MyScene{
	private GameModel model;
	private GamePresenter presenter;
	private GameView view;
	
	@Override
	protected void createModel() {
		model = new GameModel();
	}

	@Override
	protected Parent createView() {
		view = new GameView(model);
		return view;
	}

	@Override
	protected void createPresenter() {
		parent.setTitle("Snake");
		presenter = new GamePresenter(model,view,this);
	}

	@Override
	public void show(Stage parent) {
		super.show(parent);
		
		// start loop!
		presenter.startLoop();
	}
}
