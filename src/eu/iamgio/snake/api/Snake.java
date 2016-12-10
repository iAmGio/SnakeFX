package eu.iamgio.snake.api;

import eu.iamgio.snake.game.Main;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by Gio on 09/12/2016.
 */
public class Snake
{
    private int length = 1;
    private Direction direction = Direction.EST;

    private Game game;
    private Rectangle snake;

    Snake()
    {
        game = Main.getGame();
    }

    public void spawn()
    {
        snake = new Rectangle(300, 200, 30, 30);
        snake.setFill(Paint.valueOf("FFF"));
        snake.setStrokeWidth(0);
        snake.setId("snake_head");
        game.getRoot().getChildren().add(snake);
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }
}
