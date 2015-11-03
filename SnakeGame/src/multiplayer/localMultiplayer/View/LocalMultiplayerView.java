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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class LocalMultiplayerView extends GameView {
	
	private Pane secondSnakePane;
	private Pane highscorePane2;
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

		hBox.setAlignment(Pos.BOTTOM_RIGHT);
		hBox.getChildren().add(highscoreLabel);
		
		highscorePane2 = new StackPane(); 
		highscorePane2.getChildren().add(hBox);
		highscorePane2.setVisible(false);
		highscorePane2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		highscorePane2.autosize();
		
		addPanesToMainPane(secondSnakePane,highscorePane2);
		
	}
	
	public Pane getHighscorePane2() {
		return highscorePane2;
	}
	
}
