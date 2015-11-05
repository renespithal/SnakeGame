package multiplayer.localMultiplayer;

import framework.MyScene;
import game.model.GameModel;
import game.model.SnakeModel;
import game.view.GameView;
import highscore.model.HighscoreModel;
import javafx.scene.Parent;
import javafx.stage.Stage;
import multiplayer.localMultiplayer.View.LocalMultiplayerView;
import multiplayer.localMultiplayer.presenter.LocalMultiplayerPresenter;

public class LocalMultiplayerScene extends MyScene{

	private GameModel model;
	private GameView view;
	private LocalMultiplayerView localView;
	private LocalMultiplayerPresenter localPresenter;
	private SnakeModel snakeModel;
	private HighscoreModel highscoreModel;
	private boolean normalMode;
	
	/**
	 * 
	 * @param normalMode if true start normal mode else start survival mode
	 */
	public LocalMultiplayerScene(boolean normalMode) {
		this.normalMode = normalMode;
	}
	@Override
	protected void createModel() {
		model = new GameModel();
		snakeModel = new SnakeModel(24, 24);
		highscoreModel = new HighscoreModel();
	}

	@Override
	protected Parent createView() {
		localView = new LocalMultiplayerView(model,snakeModel,highscoreModel);
		return localView;
	}

	@Override
	protected void createPresenter() {
		localPresenter = new LocalMultiplayerPresenter(model, view, this, localView, snakeModel,highscoreModel,normalMode);
	}
	
	@Override
	public void show(Stage parent) {
		super.show(parent);
		
		// start loop!
		localPresenter.startLoop();
	}

}
