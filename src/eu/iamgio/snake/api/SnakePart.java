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

    SnakePart(Snake snake, boolean first)
    {
        this.snake = snake;

        rectangle = new Rectangle(first ? 300 : snake.getLastPart().getValue().getX(),
                first ? 200 : snake.getLastPart().getValue().getY(), 30, 30);
        rectangle.setFill(Paint.valueOf("FFF"));
        //if(!first) rectangle.setStrokeWidth(5);
        rectangle.setStroke(Paint.valueOf("000"));
        rectangle.setId("snakepart_" + snake.getParts().size());


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
     * Updates the snake
     */
    public static void update()
    {
        for(int i = Main.getGame().getSnake().getLength()-1; i>0; i--)
        {
            Rectangle part = Main.getGame().getSnake().getParts().get(i).getValue();
            Rectangle target = Main.getGame().getSnake().getParts().get(i-1).getValue();
            part.setX(target.getX());
            part.setY(target.getY());
        }
    }
}
