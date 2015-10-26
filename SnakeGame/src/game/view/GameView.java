package game.view;

import game.model.GameModel;
import javafx.scene.layout.Pane;

public class GameView extends Pane{
	public GameView(GameModel model) {
	
		Pane snakePane = new Pane();
		snakePane.getChildren().addAll(model.getSnake().getObservableList());
		
		Pane foodPane = new Pane();
		foodPane.getChildren().addAll(model.getFood().getFood().getCircle(),model.getYinYang().getYin().getRectangle());
		
		this.getChildren().addAll(snakePane,foodPane);
	}
}
