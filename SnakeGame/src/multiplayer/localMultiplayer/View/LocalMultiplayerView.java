package multiplayer.localMultiplayer.View;

import game.model.GameModel;
import game.model.SnakeModel;
import game.model.SnakePartModel;
import game.view.GameView;
import highscore.model.HighscoreModel;
import javafx.beans.binding.StringBinding;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import options.Options;

public class LocalMultiplayerView extends GameView {
	
	private Pane secondSnakePane;
	private Pane highscorePane2;
	private Pane winPane;
	private Label winLabel;
	private Label infoLabel;
	private Rectangle snakeHead2;
	private HighscoreModel highScore2;
	private SnakeModel snake;
	
	public LocalMultiplayerView(GameModel model,SnakeModel multiplayerModel,HighscoreModel highscore) {
		super(model);
		super.setHBoxUnvisible();
		this.snake = multiplayerModel;
		this.highScore2 = highscore;
		
		secondSnakePane = new Pane();
		snakeHead2 = new Rectangle(20, 20);
		snakeHead2.setFill(chooseColor());
		secondSnakePane.getChildren().add(snakeHead2);
		bindSnakePart(snake.getHead(), snakeHead2);
		
		snake.getList().addListener(new ListChangeListener<SnakePartModel>()
		{

			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends SnakePartModel> c) {
				while(c.next()){
					Rectangle snakePartView = new Rectangle(20, 20);
					snakePartView.setFill(chooseColor());
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


		VBox vBoxwin = new VBox();
		winLabel = new Label();
		winLabel.setFont(new Font (40));
		infoLabel = new Label();
		infoLabel.setFont(new Font(12));
		vBoxwin.setSpacing(30);
		vBoxwin.getChildren().addAll(winLabel,infoLabel);

		winPane = new StackPane();
		winPane.setVisible(false);
		winPane.setLayoutX(150);
		winPane.setLayoutY(200);
		highscorePane2.setLayoutY(440);
		winPane.getChildren().add(vBoxwin);

		addPanesToMainPane(secondSnakePane,highscorePane2,winPane);

	}

	public Label getWinLabel(){
		return winLabel;
	}
	
	public Label getInfoLabel() {
		return infoLabel;
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
	
	public Pane getSnakePane2() {
		return secondSnakePane;
	}
	
	public Rectangle getSnakeHead2() {
		return snakeHead2;
	}
	
	private Color chooseColor(){
		
		if(Options.color == Options.GREEN)
		{
			return Options.BLACK;
		} else if(Options.color == Options.RED)
		{
			return Options.BLUE;
		} else if(Options.color == Options.BLUE)
		{
			return Options.RED;
		} else if(Options.color == Options.YELLOW)
		{
			return Options.GREEN;
		} else if(Options.color == Options.BLACK)
		{
			return Options.YELLOW;
		}
		return null;
		
	}

}
