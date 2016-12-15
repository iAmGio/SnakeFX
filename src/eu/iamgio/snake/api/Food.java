package eu.iamgio.snake.api;

import eu.iamgio.snake.game.Main;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

/**
 * Created by Gio on 10/12/2016.
 */
public class Food
{
    private int x, y;
    private Circle circle;

    /**
     * Spawns a food randomly
     */
    public void spawnRandomly()
    {
        Game game = Main.getGame();

        x = new Random().nextInt(1000 - 30);
        y = new Random().nextInt(700 - 30);

        circle = new Circle(x, y, 10);
        circle.setFill(Paint.valueOf("FFF"));
        circle.setStrokeWidth(1);
        circle.setId("food");

        game.getRoot().getChildren().add(circle);
    }

    /**
     * Deletes the food
     */
    public void delete()
    {
        Main.getGame().getRoot().getChildren().remove(circle);
        x = 0; y = 0;
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

    /**
     * @return The circle
     */
    public Circle getCircle()
    {
        return circle;
    }
}
