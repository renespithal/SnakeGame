package multiplayer.localMultiplayer.View;

import game.model.GameModel;
import game.model.SnakeModel;
import game.model.SnakePartModel;
import game.view.GameView;
import highscore.model.HighscoreModel;
import javafx.beans.binding.StringBinding;
import javafx.collections.ListChangeListener;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class LocalMultiplayerView extends GameView {
	
	private Pane secondSnakePane;
	private Pane highscorePane2;
	private Pane winPane;
	private Label winLabel;
	private HighscoreModel highScore2;
	private SnakeModel snake;
	
	public LocalMultiplayerView(GameModel model,SnakeModel multiplayerModel,HighscoreModel highscore) {
		super(model);
		
		this.snake = multiplayerModel;
		this.highScore2 = highscore;
		
		secondSnakePane = new Pane();
		Rectangle snakeHead = new Rectangle(20, 20);
		snakeHead.setFill(Color.BLACK);
		secondSnakePane.getChildren().add(snakeHead);
		bindSnakePart(snake.getHead(), snakeHead);
		
		snake.getList().addListener(new ListChangeListener<SnakePartModel>()
		{

			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends SnakePartModel> c) {
				while(c.next()){
					Rectangle snakePartView = new Rectangle(20, 20);
					snakePartView.setFill(Color.RED);
					SnakePartModel newPart = c.getAddedSubList().get(0);
					bindSnakePart(newPart, snakePartView);
					secondSnakePane.getChildren().add(snakePartView);
				}
			}
		});
		

		HBox hBox = new HBox();
		Label highscoreLabel = new Label();
		highscoreLabel.textProperty().bind(new StringBinding() {
			{
				bind(highScore2.getValueProperty());
			}

			@Override
			protected String computeValue() {
				return "Highscore: "+highScore2.getValue();
			}
		});
		highscoreLabel.setFont(new Font(40));

		hBox.getChildren().add(highscoreLabel);

		highscorePane2 = new StackPane();
		highscorePane2.setLayoutX(275);
		highscorePane2.setLayoutY(440);
		highscorePane2.getChildren().add(hBox);
		highscorePane2.setVisible(false);
		//highscorePane2.setMinSize(280,50);
		//highscorePane2.setPrefWidth(500);
		highscorePane2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		//highscorePane2.autosize();

		HBox hBoxwin = new HBox();
		winLabel = new Label();
		winLabel.setFont(new Font (40));
		hBoxwin.getChildren().add(winLabel);

		winPane = new StackPane();
		winPane.setVisible(false);
		winPane.setLayoutX(150);
		winPane.setLayoutY(200);
		highscorePane2.setLayoutY(440);
		winPane.getChildren().add(hBoxwin);
		
		addPanesToMainPane(secondSnakePane,highscorePane2,winPane);

	}

	public Label getWinLabel(){
		return winLabel;
	}

	public Pane getWinPane(){
		return winPane;
	}

	public Pane getHighscorePane2() {
		return highscorePane2;
	}

	@Override
	protected void highscoreSetPosition() {
		highscorePane.setLayoutX(0);
		highscorePane.setLayoutY(0);
	}
	
}
