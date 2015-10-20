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

    private Circle yin;
    private int blockSize;
    private int screenWidth;
    private int screenHeight;
    

    public YinYangFoodModel(int blockSize, int screenWidth, int screenHeight) {
        yin = new Circle(blockSize);
        yin.setFill(Color.ORANGE);
        yin.setTranslateX((int) (Math.random() * (screenWidth - blockSize)) / blockSize * blockSize);
        yin.setTranslateY((int) (Math.random() * (screenHeight - blockSize)) / blockSize * blockSize);
    }
        public Circle getYin() {
        return yin;
        }


    public void ConsumeFood() {
        if (head.getTranslateX() == yin.getTranslateX() && head.getTranslateY() == yin.getTranslateY()) {

            yin.setTranslateX((int) (Math.random() * (screenWidth - blockSize)) / blockSize * blockSize);

            yin.setTranslateY((int) (Math.random() * (screenHeight - blockSize)) / blockSize * blockSize);
        }
    }

}


