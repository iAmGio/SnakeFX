package eu.iamgio.snake.api;

import eu.iamgio.snake.game.Main;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Created by Gio on 10/12/2016.
 */
public class Food
{
    private int x, y;
    private Rectangle rectangle;

    /**
     * Spawns a food randomly
     */
    public void spawnRandomly()
    {
        Game game = Main.getGame();

        x = new Random().nextInt(1000 - 30);
        y = new Random().nextInt(700 - 30);

        rectangle = new Rectangle(x, y, 20, 20);
        rectangle.setFill(Paint.valueOf("FFF"));
        rectangle.setStrokeWidth(0);
        rectangle.setId("food");

        game.getRoot().getChildren().add(rectangle);
    }

    /**
     * Deletes the food
     */
    public void delete()
    {
        Main.getGame().getRoot().getChildren().remove(rectangle);
    }

    /**
     * @return x
     */
    public int getX()
    {
        return x;
    }

    /**
     * @return y
     */
    public int getY()
    {
        return y;
    }
}
