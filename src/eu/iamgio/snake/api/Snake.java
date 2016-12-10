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

    private double x, y;

    Snake()
    {
        game = Main.getGame();
    }

    /**
     * Spawns the snake
     */
    void spawn()
    {
        x = 300; y = 200;
        snake = new Rectangle(x, y, 30, 30);
        snake.setFill(Paint.valueOf("FFF"));
        snake.setStrokeWidth(0);
        snake.setId("snake_head");
        game.getRoot().getChildren().add(snake);
    }

    /**
     * Moves the snake
     */
    public void move()
    {
        final double X_PER_MS = 5;

        if(direction == Direction.NORTH)
            snake.setY(snake.getY() + X_PER_MS);
        else if(direction == Direction.SOUTH)
            snake.setY(snake.getY() - X_PER_MS);
        else if(direction == Direction.WEST)
            snake.setX(snake.getX() - X_PER_MS);
        else if(direction == Direction.EST)
            snake.setX(snake.getX() + X_PER_MS);

        x = snake.getX(); y = snake.getY();
    }

    /**
     * @return Snake's length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Sets the length
     * @param length Length
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     * @return Snake's direction
     */
    public Direction getDirection()
    {
        return direction;
    }

    /**
     * Sets the direction
     * @param direction Direction
     */
    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    /**
     * @return x
     */
    public double getX()
    {
        return x;
    }

    /**
     * @return y
     */
    public double getY()
    {
        return y;
    }
}
