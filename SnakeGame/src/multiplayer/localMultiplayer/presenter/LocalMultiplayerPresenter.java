package multiplayer.localMultiplayer.presenter;

import framework.MyScene;
import game.model.GameModel;
import game.model.SnakeModel;
import game.model.SnakeModel.Direction;
import game.model.SnakePartModel;
import game.presenter.GamePresenter;
import game.view.GameView;
import highscore.model.HighscoreModel;
import javafx.scene.input.KeyEvent;
import multiplayer.localMultiplayer.View.LocalMultiplayerView;

public class LocalMultiplayerPresenter extends GamePresenter {

	private LocalMultiplayerView localView;
	private MyScene scene;
	private Direction direction2;
	private SnakeModel snake2;
	private HighscoreModel highscore2;
	
	public LocalMultiplayerPresenter(GameModel model, GameView view, MyScene scene, LocalMultiplayerView localView, SnakeModel localModel,HighscoreModel highscore2) {
		super(model, view, scene);
		
		this.localView = localView;
		snake2 = localModel;
		this.scene = scene;
		this.highscore2 = highscore2;
		
		snake2.setDirection(Direction.LEFT);
		direction2 = snake2.getDirection();
	}

	@Override
	protected void moveSnakeControl(KeyEvent e) {
		super.moveSnakeControl(e);
		switch (e.getCode()) {

		case W:

			if (snake2.getDirection() != Direction.DOWN) {
				direction2 = Direction.UP;
			}
			break;

		case S:

			if (snake2.getDirection() != Direction.UP) {
				direction2 = Direction.DOWN;
			}
			break;

		case A:

			if (snake2.getDirection() != Direction.RIGHT) {
				direction2 = Direction.LEFT;
			}
			break;

		case D:

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
	protected void snakeDead() {
		stopLoop();
		localView.getHighscorePane().setVisible(true);
		//localView.getHighscorePane().autosize();
		localView.getWinPane().setVisible(true);
		localView.getHighscorePane2().setVisible(true);
		if(highscore.getValue() > highscore2.getValue())
		{
			localView.getWinLabel().setText("Player 1 won!");
		}
		else localView.getWinLabel().setText("Player 2 won!");

		//localView.getWinLabel().setVisible(true);
		//localView.getHighscorePane2().setVisible(true);
		//localView.getHighscorePane2().autosize();


		scene.setOnKeyPressed(e->returnToWelcomeWindow(scene));
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
	protected void checkCollision() {
		super.checkCollision();
		if (snake2.getHead().getY() < 0 || snake2.getHead().getY() > 24 || snake2.getHead().getX() < 0 || snake2.getHead().getX() > 24) {
			snakeDead();
		}
		
		for(SnakePartModel currentPart : snake2.getList())
		{
			if(snake2.getHead().getX() == currentPart.getX() && snake2.getHead().getY() == currentPart.getY())
			{
				snakeDead();
			}
		}
		
		if(snake2.getHead().getX() == food.getX() && snake2.getHead().getY() == food.getY())
		{
			snake2.grow();
			highscore2.increaseValue();
			generateFood();
		}
		
		if(snake2.getHead().getX() == yin.getX() && snake2.getHead().getY() == yin.getY())
		{
			highscore2.increaseSpecialValue();
			yin.setVisible(false);
			generateYin();
		}
		
		if(snake2.getHead().getX() == snake.getHead().getX() && snake2.getHead().getY() == snake.getHead().getY())
		{
			snakeDead();
		}
		
		for(SnakePartModel currentPart : snake.getList())
		{
			if(snake2.getHead().getX() == currentPart.getX() && snake2.getHead().getY() == currentPart.getY())
			{
				snakeDead();
			}
		}
		
		for(SnakePartModel currentPart : snake2.getList())
		{
			if(snake.getHead().getX() == currentPart.getX() && snake.getHead().getY() == currentPart.getY())
			{
				snakeDead();
			}
		}
	}

}