package framework;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public abstract class MyScene extends Scene {
	protected Stage parent;

	public MyScene() {
		super(new HBox(),500,500);
	}

	
	public void init(){
		createModel();
		setRoot(createView());
		createPresenter();
	}
	
	protected abstract void createModel();
	protected abstract Parent createView();
	protected abstract void createPresenter();
	
	/**
	 * Shows this scene to the user
	 * @param parent which stage to use
	 */
	public void show(Stage parent){
		this.parent = parent;
		parent.hide();
		
		this.init();
		parent.getIcons().add(new Image("file:src/images/yinyanyolologo2.png")); // Icon on Window
		parent.setResizable(false);
		parent.setScene(this);
		parent.sizeToScene();
		parent.show();

	}
}
