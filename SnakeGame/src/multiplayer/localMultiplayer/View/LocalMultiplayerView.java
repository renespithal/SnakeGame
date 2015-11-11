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
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import options.Options;

public class LocalMultiplayerView extends GameView {
	
	private HighscoreModel highScore2;
	private SnakeModel snake;
	
	private Pane secondSnakePane;
	private Pane highscorePane2;
	private Pane winPane;
	private Label winLabel;
	private Label infoLabel;
	private Rectangle snakeHead2;
	
	/**
	 * Creates the multiplayer view.
	 * @param model contains essential information of the game
	 * @param multiplayerModel contains the model for the second snake
	 * @param highscore the highscore table
	 */
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
		highscoreLabel.setFont(new Font("AR DESTINE",40));
		highscoreLabel.setTextFill(Color.GOLD);

		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetY(3.5);
		dropShadow.setOffsetX(-3.5);
		dropShadow.setColor(Color.BLACK);

		VBox vBox = new VBox(highscoreLabel);
		//vBox.setAlignment(Pos.CENTER);

		highscorePane2 = new StackPane();
		highscorePane2.setLayoutX(220);
		highscorePane2.setLayoutY(425);
		highscorePane2.setEffect(dropShadow);
		highscorePane2.getChildren().add(vBox);
		highscorePane2.setVisible(false);

		VBox vBoxwin = new VBox();
		winLabel = new Label();
		winLabel.setFont(new Font ("AR DESTINE",40));
		winLabel.setTextFill(Color.WHITE);
		winLabel.setEffect(dropShadow);
		infoLabel = new Label();
		infoLabel.setFont(new Font("AR DESTINE",18));
		infoLabel.setTextFill(Color.WHITESMOKE);
		infoLabel.setEffect(dropShadow);
		vBoxwin.setSpacing(15);
		vBoxwin.setAlignment(Pos.CENTER);
		vBoxwin.getChildren().addAll(winLabel, infoLabel);

		winPane = new StackPane();
		winPane.setVisible(false);
		winPane.setLayoutX(110);
		winPane.setLayoutY(190);
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
		highscorePane.setLayoutX(20);
		highscorePane.setLayoutY(20);
	}
	
	public Pane getSnakePane2() {
		return secondSnakePane;
	}
	
	public Rectangle getSnakeHead2() {
		return snakeHead2;
	}
	
	/**
	 * Control method to avoid that the two snakes have the same color.
	 * @return the color which was selected in the combo box
	 */
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
