package options;

import framework.MyScene; 
import javafx.scene.Parent;
import options.model.SpeedSettingModel;
import options.presenter.OptionsPresenter;
import options.view.OptionsView;

public class OptionsScene extends MyScene {
	
	private SpeedSettingModel model;
	private OptionsView view;
	private OptionsPresenter presenter; 

	@Override
	protected void createModel() {
		model = new SpeedSettingModel();
	}

	@Override
	protected Parent createView() {
		view = new OptionsView();
		return view;
	}

	@Override
	protected void createPresenter() {
		parent.setTitle("Options");
		presenter = new OptionsPresenter(model,view, parent);
		
	}
	
	public SpeedSettingModel getModel() {
		return model;
	}

}
