package Model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

/**
 * Created by Rene on 20.10.2015.
 */
public class YinYangFoodModel {

    SnakeModel snake = new SnakeModel();
    Rectangle head;

    private Rectangle yin;
    private int blockSize;
    private int screenWidth;
    private int screenHeight;


    public YinYangFoodModel(int blockSize, int screenWidth, int screenHeight) {
        yin = new Rectangle(blockSize, blockSize);
        yin.setFill(Color.ORANGE);
        yin.setTranslateX((int) (Math.random() * (screenWidth - blockSize)) / blockSize * blockSize);
        yin.setTranslateY((int) (Math.random() * (screenHeight - blockSize)) / blockSize * blockSize);
//        System.out.println(yin.getTranslateY());
//        System.out.println(yin.getTranslateX());
//        System.out.println("xKord" + snake.getXPos());
//        System.out.println("xKord" + snake.getYPos());
    }
        public Rectangle getYin() {
        return yin;
        }


    public void ConsumeFood() {
        if (snake.getXPos() == yin.getX() && snake.getYPos() == yin.getY()) {

            yin.setTranslateX((int) (Math.random() * (screenWidth - blockSize)) / blockSize * blockSize);

            yin.setTranslateY((int) (Math.random() * (screenHeight - blockSize)) / blockSize * blockSize);
        }
    }

}


