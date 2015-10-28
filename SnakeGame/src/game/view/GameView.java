package game.view;

import game.model.GameModel;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.StringBinding;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class GameView extends Pane{
	
	private Pane highscorePane;
	private Group snakeGroup;
	private ObservableList<Node> snakeBody;
	public GameView(GameModel model) {

		snakeGroup = new Group();
		snakeBody = snakeGroup.getChildren();

		Rectangle snakeHead = new Rectangle(20, 20);
		Rectangle snakeMiddle = new Rectangle(-20,0,20,20);
		Rectangle snakeTail = new Rectangle(-40,0,20,20);
		snakeHead.setFill(Color.GREEN);
		snakeMiddle.setFill(Color.GREEN);
		snakeTail.setFill(Color.GREEN);
		snakeBody.addAll(snakeHead,snakeMiddle,snakeTail);
		System.out.println(snakeBody.size());
				
		snakeGroup.translateXProperty().bind(new IntegerBinding() {
			{bind(model.getSnake().getXProperty());}
		
			@Override
			protected int computeValue() {
				if(model.getSnake().getSnakeGrow())
				{
					int dir =model.getSnake().snakeGrowth();
					Rectangle snakePart = new Rectangle(dir*20,0,20,20);
					snakePart.setFill(Color.GREEN);
					snakeBody.add(0,snakePart);
					snakeGroup.autosize();
					model.getSnake().setSnakeGrow(false);
				}
				return model.getSnake().getX() *20;
			}
		});
		
		snakeGroup.translateYProperty().bind(new IntegerBinding() {
			{bind(model.getSnake().getYProperty());}
		
			@Override
			protected int computeValue() {
				if(model.getSnake().getSnakeGrow())
				{
					int dir =model.getSnake().snakeGrowth();
					Rectangle snakePart = new Rectangle(0,dir*20,20,20);
					snakePart.setFill(Color.GREEN);
					snakeBody.add(0,snakePart);
					snakeGroup.autosize();
					model.getSnake().setSnakeGrow(false);
				}
				return model.getSnake().getY() *20;
			}
		});
		
		Image imageYin = new Image("file:src/images/Yin.png", 20, 20, true, true);

		ImageView ivYin = new ImageView();
		ivYin.setImage(imageYin);


		ivYin.xProperty().bind(new IntegerBinding() {
			{bind(model.getYinYang().getXProperty());}

			@Override
			protected int computeValue() {
				return model.getYinYang().getX()*20;
			}});

		ivYin.yProperty().bind(new IntegerBinding() {
			{bind(model.getYinYang().getYProperty());}

			@Override
			protected int computeValue() {
				return model.getYinYang().getY()*20;
			}});
		Image imageFood = new Image("file:src/images/Apple.jpg", 20, 20, true, true);

		ImageView ivFood = new ImageView();
		ivFood.setImage(imageFood);

		ivFood.xProperty().bind(new IntegerBinding() {
			{bind(model.getFood().getXProperty());}

			@Override
			protected int computeValue() {
				return model.getFood().getX()*20;
			}});

		ivFood.yProperty().bind(new IntegerBinding() {
			{bind(model.getFood().getYProperty());}

			@Override
			protected int computeValue() {
				return model.getFood().getY()*20;
			}});
		
		
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
		snakePane.getChildren().addAll(snakeGroup);

		Pane imagePane = new Pane();
		imagePane.getChildren().addAll(ivYin, ivFood);

		highscorePane = new StackPane(); 
		highscorePane.getChildren().add(hBox);
		highscorePane.setVisible(false);
		highscorePane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		highscorePane.autosize();
		
		this.getChildren().addAll(snakePane,highscorePane,imagePane);
	}

	public Pane getHighscorePane()
	{
		return highscorePane;
	}
	
	public ObservableList<Node> snakeBody()
	{
		return snakeBody; 
	}
	
	
}
