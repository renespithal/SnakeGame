package close;

import close.presenter.ClosePresenter; 
import close.view.CloseView;
import framework.MyScene;
import javafx.scene.Parent;

public class CloseScene extends MyScene {

	private CloseView view;
	private ClosePresenter presenter;
	@Override
	protected void createModel() {
		// TODO Auto-generated method stub
		
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

}
