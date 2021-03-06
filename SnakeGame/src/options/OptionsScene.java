package options;

import framework.MyScene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import options.presenter.OptionsPresenter;
import options.view.OptionsView;

public class OptionsScene extends MyScene {
	
	private OptionsView view;
	@SuppressWarnings("unused")
	private OptionsPresenter presenter; 

	@Override
	protected void createModel() {
	}

	@Override
	protected Parent createView() {
		view = new OptionsView();
		return view;
	}

	@Override
	protected void createPresenter() {
		parent.setTitle("Options");
		presenter = new OptionsPresenter(view, parent);
		
	}
	@Override
	public void show(Stage parent) {
		super.show(parent);

		// start rotation!
		view.startRotation();
	}
}
