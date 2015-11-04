package highscore.presenter;

import highscore.model.HighscoreModel;
import highscore.view.HighscoreView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import welcome.WelcomeScene;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class HighscorePresenter {
	
	private HighscoreView view;
	private Stage stage;
		
	public HighscorePresenter(HighscoreView view, Stage stage)
	{
		this.view = view;
        ObservableList<HighscoreModel> highscoreList = createHighscoreList();
        view.highscoreTable.setItems(highscoreList);
		this.stage = stage;
		view.getBackButton().setOnAction(e->returnToWelcomeWindow());
		//view.playButton().setOnAction(e-> returnToGameScene(stage));
		//view.clearButton().setOnAction(e-> clearTable());
	}

	private ObservableList<HighscoreModel> createHighscoreList() {
		ObservableList<HighscoreModel> highscores = FXCollections.observableArrayList();

		Properties properties = new Properties();

		try(FileInputStream is = new FileInputStream("res/Highscore.properties")) {
			properties.load(is);
		} catch (IOException e) {}

		for (Map.Entry<Object, Object> entry : properties.entrySet()) {
			highscores.add(new HighscoreModel(
					(String) entry.getKey(),
					Integer.valueOf((String) entry.getValue())));
		}

        return highscores;
	}


	/*public void clearTable(){
		highscoreTable.set
	}

	/*public void returnToGameScene(Stage stage){
		(new GameScene()).show(stage);
	}*/

	private void returnToWelcomeWindow() {
		view.stopRotation();
		(new WelcomeScene()).show(stage);
	}
}


