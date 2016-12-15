package eu.iamgio.snake.game.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.snake.api.Direction;
import eu.iamgio.snake.api.Game;
import eu.iamgio.snake.api.Snake;
import eu.iamgio.snake.api.SnakePart;
import eu.iamgio.snake.api.events.KeyPressEvent;
import eu.iamgio.snake.api.events.Loop;
import eu.iamgio.snake.game.Main;
import javafx.scene.input.KeyCode;

/**
 * Created by Gio on 10/12/2016.
 */
public class SnakeListener implements Listener
{
    @EventHandler
    public void loop(Loop loop)
    {
        Game game = Main.getGame();
        Snake snake = game.getSnake();

        snake.move();

        if(snake.getX() >= 1000 || snake.getX() <= -30 || snake.getY() >= 700 || snake.getY() <= -30)
        {
            game.end();
            return;
        }

        if(snake.intersectsFood())
        {
            snake.eat();
            SnakePart.update();
            return;
        }

        if(snake.intersectsItself())
        {
            System.out.println(snake.getParts().get(1).getValue().getId());
            game.end();
            return;
        }

        SnakePart.update();
    }

    @EventHandler
    public void onKeyPress(KeyPressEvent e)
    {
        KeyCode code = e.getKeyEvent().getCode();
        Snake snake = Main.getGame().getSnake();

        if(code == KeyCode.UP || code == KeyCode.W)
            snake.setDirection(Direction.NORTH);
        else if(code == KeyCode.DOWN || code == KeyCode.S)
            snake.setDirection(Direction.SOUTH);
        else if(code == KeyCode.LEFT || code == KeyCode.A)
            snake.setDirection(Direction.WEST);
        else if(code == KeyCode.RIGHT || code == KeyCode.D)
            snake.setDirection(Direction.EAST);
    }
}
