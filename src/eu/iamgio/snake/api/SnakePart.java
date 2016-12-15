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

    SnakePart(Snake snake, boolean first)
    {
        this.snake = snake;

        rectangle = new Rectangle(first ? 300 : snake.getLastPart().getValue().getX(),
                first ? 200 : snake.getLastPart().getValue().getY(), 30, 30);
        rectangle.setFill(Paint.valueOf("FFF"));
        rectangle.setStrokeWidth(0);

        rectangle.setId("snakepart_" + snake.getParts().size());

        if(first)
            direction = Direction.EAST;
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
     * @return Snakepart direction
     */
    public Direction getDirection()
    {
        return direction;
    }

    /**
     * Sets the direction
     * @param direction Direction
     */
    private void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    /**
     * Updates the snake
     */
    public static void update()
    {
        for(int i = Main.getGame().getSnake().getLength()-1; i>0; i--)
        {
            SnakePart part = Main.getGame().getSnake().getParts().get(i);
            Rectangle target = Main.getGame().getSnake().getParts().get(i-1).getValue();
            part.getValue().setX(target.getX());
            part.getValue().setY(target.getY());
            part.setDirection(Main.getGame().getSnake().getDirection());
        }
    }
}
