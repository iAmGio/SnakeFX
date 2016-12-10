package eu.iamgio.snake.game.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.snake.api.Game;
import eu.iamgio.snake.api.Snake;
import eu.iamgio.snake.api.events.Loop;

import static eu.iamgio.snake.game.Main.getGame;

/**
 * Created by Gio on 10/12/2016.
 */
public class SnakeListener implements Listener
{
    @EventHandler
    public void loop(Loop loop)
    {
        Game game = getGame();
        Snake snake = game.getSnake();

        snake.move();

        if(snake.getX() >= 1000 || snake.getX() <= 0 || snake.getY() >= 700 || snake.getY() <= 0)
        {
            game.end();
            return;
        }

        /*if(snake.getX() == +- game.getFood().getX())
        {
            System.out.println("a");
        }*/


    }
}
