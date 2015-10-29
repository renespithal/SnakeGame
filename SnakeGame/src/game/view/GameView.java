package game.view;

import game.model.GameModel;
import game.model.SnakePartModel;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.StringBinding;
import javafx.collections.ListChangeListener;
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
	public GameView(GameModel model) {
		
		

//		Group snakeGroup = new Group();
		Pane snakePane = new Pane(); 
		
//		Image imageSnake = new Image("file:src/images/snakePart.jpg", 20, 20, true, true);
//		ImageView ivSnake = new ImageView();
//		ivSnake.setImage(imageSnake);
		
		Rectangle snakeHead = new Rectangle(20, 20);
		snakeHead.setFill(Color.GREEN);
		
		snakePane.getChildren().add(snakeHead);
		
		bindSnakePart(model.getSnake().getHead(), snakeHead);
		
		model.getSnake().getList().addListener(new ListChangeListener<SnakePartModel>()
				{

					@Override
					public void onChanged(javafx.collections.ListChangeListener.Change<? extends SnakePartModel> c) {
						while(c.next()){
							Rectangle snakePartView = new Rectangle(20, 20);
							snakePartView.setFill(Color.GREEN);
							SnakePartModel newPart = c.getAddedSubList().get(0);
							bindSnakePart(newPart, snakePartView);
							snakePane.getChildren().add(snakePartView);
							System.out.println(snakePane.getChildren().size());
						}
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
			{
				bind(model.getYinYang().getYProperty());
			}

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
			{
				bind(model.getFood().getYProperty());
			}

			@Override
			protected int computeValue() {
				return model.getFood().getY()*20;
			}});
		

		HBox hBox = new HBox();
		Label highscore = new Label();
		highscore.textProperty().bind(new StringBinding() {
			{
				bind(model.getHighscore().getValueProperty());
			}

			@Override
			protected String computeValue() {
				return "Highscore: "+model.getHighscore().getValue();
			}
		});
		highscore.setFont(new Font(40));

		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(highscore);
		
		
		


		Pane imagePane = new Pane();
		imagePane.getChildren().addAll(ivFood, ivYin);

		highscorePane = new StackPane(); 
		highscorePane.getChildren().add(hBox);
		highscorePane.setVisible(false);
		highscorePane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
		highscorePane.autosize();
		
		this.getChildren().addAll(snakePane,imagePane,highscorePane);
	}

	private void bindSnakePart(SnakePartModel snakePart, Rectangle snakePartView) {
		snakePartView.xProperty().bind(new IntegerBinding() {
			{bind(snakePart.getXProperty());}

			@Override
			protected int computeValue() {

				return snakePart.getX()*20;
			}});

		snakePartView.yProperty().bind(new IntegerBinding() {
			{bind(snakePart.getYProperty());}

			@Override
			protected int computeValue() {
				return snakePart.getY() *20;
			}
		});
	}

	public Pane getHighscorePane()
	{
		return highscorePane;
	}
}
