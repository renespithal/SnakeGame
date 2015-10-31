package highscore;

import framework.MyScene;
import javafx.scene.Parent;
import highscore.model.HighscoreModel;
import highscore.presenter.HighscorePresenter;
import highscore.view.HighscoreView;

public class HighscoreScene extends MyScene{

	private HighscoreView view;
	private HighscorePresenter presenter;
	
	@Override
	protected void createModel() {
		// 	
	}

	@Override
	protected Parent createView() {
		view = new HighscoreView();
		return view;
	}

	@Override
	protected void createPresenter() {
		parent.setTitle("Highscore");
		presenter = new HighscorePresenter(view,parent);
		
	}

}
