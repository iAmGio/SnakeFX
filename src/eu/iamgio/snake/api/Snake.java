package eu.iamgio.snake.api;

import eu.iamgio.snake.api.movements.Movement;
import eu.iamgio.snake.game.Main;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Created by Gio on 09/12/2016.
 */
public class Snake
{
    private int length = 1;
    private Direction direction = Direction.EAST;

    private Game game;
    private Rectangle snake;

    private double x, y;

    private int points = 0;

    private ArrayList<Rectangle> parts = new ArrayList<>();

    Snake()
    {
        game = Main.getGame();
    }

    /**
     * Spawns the snake
     */
    void spawn()
    {
        x = 300;
        y = 200;
        snake = new Rectangle(x, y, 30, 30);
        snake.setFill(Paint.valueOf("E8E8E8"));
        snake.setStrokeWidth(2);
        snake.setId("snake_head");
        game.getRoot().getChildren().add(snake);

        parts.add(snake);
    }

    /**
     * Moves the snake
     */
    public void move()
    {
        final double X_PER_MS = 5;

        for(Rectangle part : parts)
            switch(direction)
            {
                case NORTH:
                    part.setY(part.getY() - X_PER_MS);
                    break;
                case SOUTH:
                    part.setY(part.getY() + X_PER_MS);
                    break;
                case WEST:
                    part.setX(part.getX() - X_PER_MS);
                    break;
                case EAST:
                    part.setX(part.getX() + X_PER_MS);
                    break;
            }

        x = snake.getX();
        y = snake.getY();
    }

    /**
     * @return Snake's length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Adds a part
     * @param part Snake part
     */
    public void addPart(SnakePart part)
    {
        Rectangle rectangle = part.getValue();
        Rectangle last = parts.get(parts.size() - 1);

        rectangle.setX(last.getX() - 30);
        rectangle.setY(last.getY());

        parts.add(rectangle);
        game.getRoot().getChildren().add(rectangle);

        length++;
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
        if(length > 1)
            if(
                 (this.direction == Direction.NORTH && direction == Direction.SOUTH) ||
                 (this.direction == Direction.SOUTH && direction == Direction.NORTH) ||
                 (this.direction == Direction.EAST && direction == Direction.WEST) ||
                 (this.direction == Direction.WEST && direction == Direction.EAST)
              )
                return;

        this.direction = direction;

        Movement.Recorder.record(this);
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

    /**
     * @return Snake's points
     */
    public int getPoints()
    {
        return points;
    }

    /**
     * Sets the points
     * @param points Points
     */
    public void setPoints(int points)
    {
        this.points = points;
    }

    /**
     * @return Snake's parts
     */
    public ArrayList<Rectangle> getParts()
    {
        return parts;
    }
}
