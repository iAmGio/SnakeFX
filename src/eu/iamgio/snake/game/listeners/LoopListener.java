package eu.iamgio.snake.game.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.snake.api.events.Loop;

/**
 * Created by Gio on 10/12/2016.
 */
public class LoopListener implements Listener
{
    @EventHandler
    public void loop(Loop loop)
    {
        //System.out.println("a");
    }
}
