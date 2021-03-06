package highscore.presenter;

import game.GameScene;
import highscore.model.HighscoreModel;
import highscore.view.HighscoreView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import welcome.WelcomeScene;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;

public class HighscorePresenter {
	
	private HighscoreView view;
	private Stage stage;
    private final ObservableList<HighscoreModel> highscoreList;

    /**
     *
     * @param view contains the view of the Highscore
     * @param stage the stage on which it is shown
     */

    public HighscorePresenter(HighscoreView view, Stage stage)
	{
		this.view = view;
        this.stage = stage;

		view.getBackButton().setOnAction(e -> returnToWelcomeWindow());
        view.getPlayButton().setOnAction(e->showGameScene());
		view.clearButton().setOnAction(e -> clearHighscore());

        highscoreList = createHighscoreList();
        updateTableItems(view, highscoreList);
	}

    /**
     * Delete all highscore and player name in file.
     */
    private void clearHighscore() {
        Properties properties = new Properties();

        try (FileWriter writer = new FileWriter("res/Highscore.properties")) {
         properties.store(writer,null);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        updateTableItems(view, FXCollections.emptyObservableList());
    }

    /**
     *
     * @return the mapped highscores
     */
    private ObservableList<HighscoreModel> createHighscoreList() {
        Properties properties = tryLoadProperties();

        ObservableList<HighscoreModel> highscores = FXCollections.observableArrayList();

		for (Map.Entry<Object, Object> entry : properties.entrySet()) {
			highscores.add(new HighscoreModel(
                    (String) entry.getKey(),
					Integer.valueOf((String) entry.getValue())));
		}

        sortHighsore(highscores);

        return highscores;
	}

    /**
     *
     * @param highscores which were mapped
     */
    private void sortHighsore(ObservableList<HighscoreModel> highscores) {
        Comparator<HighscoreModel> comparator = new Comparator<HighscoreModel>() {
            @Override
            public int compare(HighscoreModel score1, HighscoreModel score2) {
                return ((Integer) score2.getValue()).compareTo(((Integer) score1.getValue()));
            }
        };

        Collections.sort(highscores, comparator);
    }

    /**
     *
     * @param view  contains the view of the Highscore
     * @param highscoreList the list which is shown
     */
    protected void updateTableItems(HighscoreView view, ObservableList<HighscoreModel> highscoreList) {

        try
        {
            ObservableList<HighscoreModel> fixedSizeList = FXCollections.observableList(highscoreList.subList(0,14));
            view.highscoreTable.setItems(fixedSizeList);
        }
        catch(IndexOutOfBoundsException e)
        {
            ObservableList<HighscoreModel> fixedSizeList = FXCollections.observableList(highscoreList);
            view.highscoreTable.setItems(fixedSizeList);
        }
    }


    /**
     * try to load entrys from file
     */
    private Properties tryLoadProperties() {
        Properties properties = new Properties();

        try(FileInputStream is = new FileInputStream("res/Highscore.properties")) {
            properties.load(is);
        } catch (IOException e) {}
        return properties;
    }


    private void showGameScene()
    {
        view.stopRotation();
        (new GameScene()).show(stage);
    }

    private void returnToWelcomeWindow() {
		view.stopRotation();
		(new WelcomeScene()).show(stage);
	}
}


