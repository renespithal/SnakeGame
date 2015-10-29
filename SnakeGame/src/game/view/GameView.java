package game.view;

import game.model.GameModel; 
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class GameView extends Pane{
	
	private Pane highscorePane;
	public GameView(GameModel model) {
		
		Rectangle snakeHead = new Rectangle(20, 20);
		snakeHead.xProperty().bind(new IntegerBinding() {
			{bind(model.getSnake().getXProperty());}
			
			@Override
			protected int computeValue() {
				return model.getSnake().getX() *20;
			}
			});
		
		snakeHead.yProperty().bind(new IntegerBinding() {
			{bind(model.getSnake().getYProperty());}
			
		
			@Override
			protected int computeValue() {
				return model.getSnake().getY() *20;
			}
		});
		snakeHead.setFill(Color.GREEN);
		
		Rectangle yin = new Rectangle(20, 20);
		yin.xProperty().bind(new IntegerBinding() {
			{bind(model.getYinYang().getXProperty());}

			@Override
			protected int computeValue() {
				return model.getYinYang().getX() *20;
			}});
		
		yin.yProperty().bind(new IntegerBinding() {
			{bind(model.getYinYang().getYProperty());}
			
		
			@Override
			protected int computeValue() {
				return model.getYinYang().getY()*20;
			}
		});
		yin.setFill(Color.GOLD);
		
		Rectangle food = new Rectangle(20,20);
		food.xProperty().bind(new IntegerBinding() {
			{bind(model.getFood().getXProperty());}

			@Override
			protected int computeValue() {
				return model.getFood().getX()*20;
			}});
		
		food.yProperty().bind(new IntegerBinding() {
			{bind(model.getFood().getYProperty());}
			
		
			@Override
			protected int computeValue() {
				return model.getFood().getY()*20;
			}
		});
		food.setFill(Color.RED);
				
		VBox vBox = new VBox(); 
		Label highscore = new Label();
		highscore.textProperty().bind(new StringBinding() {
			{ bind(model.getHighscore().getValueProperty()); }
			
			@Override
			protected String computeValue() {
				return "Highscore: "+model.getHighscore().getValue();
			}
		});
		highscore.setFont(new Font(40));
		highscore.setAlignment(Pos.TOP_CENTER);


		vBox.getChildren().add(highscore);
		
	
		Pane snakePane = new Pane();
		snakePane.getChildren().addAll(snakeHead);
		
		Pane foodPane = new Pane();
		foodPane.getChildren().addAll(food,yin);
		
		highscorePane = new StackPane(); 
		highscorePane.getChildren().add(vBox);
		highscorePane.setVisible(false);
		highscorePane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		highscorePane.autosize();
		
		this.getChildren().addAll(snakePane,foodPane,highscorePane);
	}
	
	public Pane getHighscorePane()
	{
		return highscorePane;
	}
}
