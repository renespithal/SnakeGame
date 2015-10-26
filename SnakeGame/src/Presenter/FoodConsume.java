package Presenter;

import Model.FoodModel;
import Model.SnakeModel;
import Model.YinYangFoodModel;

public class FoodConsume {
	
	public FoodConsume(SnakeModel snake,FoodModel food) {
		int blockSize = food.getBlockSize();
		if (snake.getXPos() == food.getTranslateX() && snake.getYPos() == food.getTranslateY()) {

			food.setTranslateX((int) (Math.random() * (food.getScreenWidth() - blockSize)) / blockSize * blockSize);

			food.setTranslateY((int) (Math.random() * (food.getScreenHeight() - blockSize)) / blockSize * blockSize);
		}
	}
	
	public void ConsumeFood(SnakeModel snake, YinYangFoodModel yin) {
		int blockSize = yin.getBlockSize();
        if (snake.getXPos() == yin.getXPos() && snake.getYPos() == yin.getYPos()) {

            yin.setXPos((int) (Math.random() * (yin.getScreenHeight() - blockSize)) / blockSize * blockSize);

            yin.setYPos((int) (Math.random() * (yin.getScreenHeight() - blockSize)) / blockSize * blockSize);
        }
    }

}
