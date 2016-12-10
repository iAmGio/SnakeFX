package eu.iamgio.snake.game.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.libfx.api.events.MouseReleaseEvent;
import eu.iamgio.snake.api.Game;
import javafx.scene.Node;

/**
 * Created by Gio on 09/12/2016.
 */
public class MenuListeners implements Listener
{
    @EventHandler
    public void onPlayButtonRelease(MouseReleaseEvent e)
    {
        try
        {
            if(e.getMouseEvent().getTarget() != null)
            {
                Node node = (Node) e.getMouseEvent().getTarget();
                if(node.getId() != null && node.getId().equals("all_play_rectangle"))
                {
                    Game game = new Game();
                    game.start();
                }
            }
        }
        catch(NullPointerException ex)
        {

        }
    }
}
