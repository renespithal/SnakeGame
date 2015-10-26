package welcome;

import framework.MyScene;
import javafx.scene.Parent;
import welcome.presenter.WelcomePresenter;
import welcome.view.WelcomeView;

public class WelcomeScene extends MyScene{
	private WelcomeView view;
	private WelcomePresenter presenter;
	
	@Override
	protected void createModel() {
		// no model here
	}

	@Override
	protected Parent createView() {
		view = new WelcomeView();
		return view;
	}

	@Override
	protected void createPresenter() {
		parent.setTitle("Welcome to Snake");
		presenter = new WelcomePresenter(view, parent);
	}

}
