package multiplayer.localMultiplayer.presenter;

import framework.MyScene;
import game.model.GameModel;
import game.model.SnakeModel;
import game.model.SnakeModel.Direction;
import game.model.SnakePartModel;
import game.presenter.GamePresenter;
import game.view.GameView;
import highscore.model.HighscoreModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import multiplayer.localMultiplayer.LocalMultiplayerScene;
import multiplayer.localMultiplayer.View.LocalMultiplayerView;

public class LocalMultiplayerPresenter extends GamePresenter {

	private LocalMultiplayerView localView;
	private MyScene scene;
	private Direction direction2;
	private SnakeModel snake2;
	private HighscoreModel highscore2;
	private boolean snake1Dead;
	private boolean snake2Dead;
	private boolean bothSnakeDead;
	private Boolean normalMode;
	private String info  = "Press 'N' for New Game.\nPress 'B' for Main Menu.";
	private KeyFrame disposeSnake2;
	private Timeline deadSnake2;
	
	public LocalMultiplayerPresenter(GameModel model, GameView view, MyScene scene, LocalMultiplayerView localView, SnakeModel localModel,HighscoreModel highscore2, boolean normalMode) {
		super(model, view, scene);
		
		this.localView = localView;
		snake2 = localModel;
		this.scene = scene;
		this.highscore2 = highscore2;
		this.normalMode = normalMode;
		
		snake2.setDirection(Direction.LEFT);
		direction2 = snake2.getDirection();
		disposeSnake2 = new KeyFrame(Duration.seconds(0.1), e-> disposeSnake2());
		deadSnake2 = new Timeline(disposeSnake2);
		deadSnake2.setCycleCount(1);
	}

	private void disposeSnake2() {
		for( Node body : localView.getSnakePane2().getChildren())
		{
			localView.fade(body);
			localView.startDisposeAnimation();
		}
	}

	@Override
	protected void moveSnakeControl(KeyEvent e) {
		super.moveSnakeControl(e);
		switch (e.getCode()) {

		case UP:

			if (snake2.getDirection() != Direction.DOWN) {
				direction2 = Direction.UP;
			}
			break;

		case DOWN:

			if (snake2.getDirection() != Direction.UP) {
				direction2 = Direction.DOWN;
			}
			break;

		case LEFT:

			if (snake2.getDirection() != Direction.RIGHT) {
				direction2 = Direction.LEFT;
			}
			break;

		case RIGHT:

			if (snake2.getDirection() != Direction.LEFT) {
				direction2 = Direction.RIGHT;
			}
			break;
		default:
			break;

		}
	};
	
	
	@Override
	protected void moveSnake() {
		super.moveSnake();
		snake2.setDirection(direction2);
		snake2.increaseValue();
	}
	
	@Override
	protected void disposeSnake()
	{
		for( Node body : localView.getSnakePane().getChildren())
		{
			localView.fade(body);
			localView.startDisposeAnimation();
		}
	}
	
	@Override
	protected void snakeDead() {
//		localView.getSnakeHead().setVisible(false);
		if(normalMode)
		{
			localView.getSnakePane().getChildren().clear();
			snake1Dead = true;
		}

		else
		{
			disposeSnake();
			super.startDisposeSnake();
			disposeSnake2();
			deadSnake2.play();
			survivalModeEndGame();
		}
	}
	
	private void snake2Dead() {
//		localView.getSnakeHead2().setVisible(false);
		if(normalMode)
		{
			localView.getSnakePane2().getChildren().clear();
			snake2Dead = true;
		}

		else
		{
			disposeSnake2();
			deadSnake2.play();
			disposeSnake();
			super.startDisposeSnake();
			survivalModeEndGame();
		}
	}
	
	private void bothSnakeDead()
	{
//		localView.getSnakeHead().setVisible(false);
//		localView.getSnakeHead2().setVisible(false);
		bothSnakeDead = true;
	}
	

	private void normalModeEndGame() {
		stopLoop();
		localView.stopAnimation();
		localView.playGameOverMusic();
		localView.getHighscorePane().setVisible(true);
		localView.getWinPane().setVisible(true);
		localView.getHighscorePane2().setVisible(true);
		
		if(highscore.getValue() > highscore2.getValue())
		{
			localView.getWinLabel().setText("Player 1 won!");
		}
		else if(highscore.getValue() < highscore2.getValue())
			{
			localView.getWinLabel().setText("Player 2 won!");
			}
		else{localView.getWinLabel().setText("It's a draw!");}

		localView.getInfoLabel().setText(info);
		scene.setOnKeyPressed(e->endGameOptions(e));
	}
	
	private void survivalModeEndGame()
	{
		stopLoop();
		localView.stopAnimation();
		super.stopDisposeSnake();
		deadSnake2.stop();
		localView.playGameOverMusic();
		if(snake1Dead)
		{
			localView.getWinLabel().setText("Player 2 won!");
		}
		else if(snake2Dead)
		{
			localView.getWinLabel().setText("Player 1 won!");
		}
		localView.getInfoLabel().setText(info);
		localView.getWinPane().setVisible(true);
		deadSnake2.stop();
		scene.setOnKeyPressed(e->endGameOptions(e));
	}
	private void specialEnd()
	{
		stopLoop();
		localView.stopAnimation();
		localView.playGameOverMusic();
		localView.getWinLabel().setText("It's a draw.");
		localView.getInfoLabel().setText(info);
		localView.getWinPane().setVisible(true);
		scene.setOnKeyPressed(e->endGameOptions(e));
	}
	
	private void endGameOptions(KeyEvent e)
	{
		switch (e.getCode()) {
		case B:
			returnToWelcomeWindow(scene);
			break;

		case N:
			newGame();
			break;
			
		default:
			break;
			
		}
	}
	
	private void newGame()
	{
		(new LocalMultiplayerScene(normalMode)).show((Stage) scene.getWindow());
	}
	
	@Override
	protected void showBonusFood()
	{
		localView.startAnimation();
		yin.generateRandomPosition();
		yin.setVisible(true);
	}
	
	@Override
	protected void hideBonusFood() {
		yin.setVisible(false);
		localView.stopAnimation();
	}
	
	@Override
	protected void checkCollision(GameView view) {
		super.checkCollision(localView);
		if (snake2.getHead().getY() < 1 || snake2.getHead().getY() > 23 || snake2.getHead().getX() < 1 || snake2.getHead().getX() > 23) {
			snake2Dead();
		}
		
		for(SnakePartModel currentPart : snake2.getList())
		{
			if(snake2.getHead().getX() == currentPart.getX() && snake2.getHead().getY() == currentPart.getY())
			{
				snake2Dead();
			}
		}
		
		if(snake2.getHead().getX() == food.getX() && snake2.getHead().getY() == food.getY())
		{
			snake2.grow();
			localView.playFoodMusic();
			highscore2.increaseValue();
			generateFood();
		}
		
		if(snake2.getHead().getX() == yin.getX() && snake2.getHead().getY() == yin.getY())
		{
			highscore2.increaseSpecialValue();
			localView.playBonusFoodMusic();
			yin.setVisible(false);
			generateYin();
		}
		
		if(snake2.getHead().getX() == snake.getHead().getX() && snake2.getHead().getY() == snake.getHead().getY())
		{
			bothSnakeDead();
		}
		
		for(SnakePartModel currentPart : snake.getList())
		{
			if(snake2.getHead().getX() == currentPart.getX() && snake2.getHead().getY() == currentPart.getY())
			{
				snake2Dead();
			}
		}
		
		for(SnakePartModel currentPart : snake2.getList())
		{
			if(snake.getHead().getX() == currentPart.getX() && snake.getHead().getY() == currentPart.getY())
			{
				snakeDead();
			}
		}
		
		if(bothSnakeDead)
		{
			specialEnd();
		}
		if(snake1Dead && snake2Dead && normalMode) {
			normalModeEndGame();
		}
	}
	
}
