package highscore;

import framework.MyScene;
import highscore.presenter.HighscorePresenter;
import highscore.view.HighscoreView;
import javafx.scene.Parent;

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
