package close;

import close.presenter.ClosePresenter;
import close.view.CloseView;
import framework.MyScene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class CloseScene extends MyScene {

	private CloseView view;
	private ClosePresenter presenter;
	@Override
	protected void createModel() {
		// no model here
		
	}

	@Override
	protected Parent createView() {
		view = new CloseView();
		return view;
	}

	@Override
	protected void createPresenter() {
		parent.setTitle("Exit Game");
		presenter = new ClosePresenter(view, parent);
		
	}

	@Override
	public void show(Stage parent) {
		super.show(parent);

		// start rotation!
		view.startRotation();
	}


}
