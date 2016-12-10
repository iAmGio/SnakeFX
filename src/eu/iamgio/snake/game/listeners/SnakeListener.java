package eu.iamgio.snake.game.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.snake.api.Snake;
import eu.iamgio.snake.api.events.Loop;
import eu.iamgio.snake.game.Main;

/**
 * Created by Gio on 10/12/2016.
 */
public class SnakeListener implements Listener
{
    @EventHandler
    public void loop(Loop loop)
    {
        Snake snake = Main.getGame().getSnake();
        snake.move();

        if(snake.getX() >= 1000 || snake.getX() <= 0 || snake.getY() >= 700 || snake.getY() <= 0)
            Main.getGame().end();
    }
}
