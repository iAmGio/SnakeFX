package eu.iamgio.snake.api;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by Gio on 10/12/2016.
 */
public class SnakePart
{
    private Rectangle rectangle;

    public SnakePart(Snake snake)
    {
        rectangle = new Rectangle(snake.getParts().get(0).getX(), snake.getParts().get(0).getY(), 30, 30);
        rectangle.setFill(Paint.valueOf("FFF"));
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Paint.valueOf("000"));
        rectangle.setId("snakepart_" + snake.getParts().size());
    }

    /**
     * @return The rectangle
     */
    public Rectangle getValue()
    {
        return rectangle;
    }
}
