package eu.iamgio.snake.api;

import eu.iamgio.snake.game.Main;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by Gio on 10/12/2016.
 */
public class SnakePart
{
    private Snake snake;
    private Rectangle rectangle;
    private Direction direction;

    public SnakePart(Snake snake, boolean first)
    {
        this.snake = snake;

        rectangle = new Rectangle(first ? 300 : snake.getLastPart().getValue().getX(),
                first ? 200 : snake.getLastPart().getValue().getY(), 30, 30);
        rectangle.setFill(Paint.valueOf("FFF"));
        if(!first) rectangle.setStrokeWidth(5);
        rectangle.setStroke(Paint.valueOf("000"));
        rectangle.setId("snakepart_" + snake.getParts().size());

        if(!first)
        {
            SnakePart last = snake.getLastPart();

            switch(last.getDirection())
            {
                case NORTH:
                    rectangle.setY(last.getValue().getY() + 30);
                    direction = Direction.NORTH;
                    break;
                case SOUTH:
                    rectangle.setY(last.getValue().getY() - 30);
                    direction = Direction.SOUTH;
                    break;
                case WEST:
                    rectangle.setX(last.getValue().getX() + 30);
                    direction = Direction.WEST;
                    break;
                case EAST:
                    rectangle.setX(last.getValue().getX() - 30);
                    direction = Direction.EAST;
                    break;
            }
        }
        else
            direction = snake.getDirection();

        Main.getGame().getRoot().getChildren().add(rectangle);
    }

    /**
     * @return The rectangle
     */
    public Rectangle getValue()
    {
        return rectangle;
    }

    /**
     * @return The direction
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
}
