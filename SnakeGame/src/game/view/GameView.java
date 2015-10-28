package game.view;

import game.model.GameModel;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameView extends Pane{
	
	private Pane highscorePane;
	public GameView(GameModel model) {
		Image imageYin = new Image("file:src/images/Yin.png", 20, 20, true, true);

		ImageView ivYin = new ImageView();
		ivYin.setImage(imageYin);

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

			{
				bind(model.getYinYang().getXProperty());
				ivYin.setX(model.getYinYang().getX());
			}

			@Override
			protected int computeValue() {
				return model.getYinYang().getX() * 20;
			}
		});
		
		yin.yProperty().bind(new IntegerBinding() {

			{
				bind(model.getYinYang().getYProperty());
				ivYin.setY(model.getYinYang().getY());
			}

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
				
		HBox hBox = new HBox(); 
		Label highscore = new Label();
		highscore.textProperty().bind(new StringBinding() {
			{ bind(model.getHighscore().getValueProperty()); }
			
			@Override
			protected String computeValue() {
				return "Highscore: "+model.getHighscore().getValue();
			}
		});
		highscore.setFont(new Font(40));

		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(highscore);
		
	
		Pane snakePane = new Pane();
		snakePane.getChildren().addAll(snakeHead);
		
		Pane foodPane = new Pane();
		foodPane.getChildren().addAll(food,yin);

		Pane imagePane = new Pane();
		imagePane.getChildren().addAll(ivYin);
		
		highscorePane = new StackPane(); 
		highscorePane.getChildren().add(hBox);
		highscorePane.setVisible(false);
		highscorePane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		highscorePane.autosize();
		
		this.getChildren().addAll(snakePane,foodPane,highscorePane,imagePane);
	}


	public Pane getHighscorePane()
	{
		return highscorePane;
	}
}
