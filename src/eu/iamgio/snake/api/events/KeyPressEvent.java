package eu.iamgio.snake.api.events;

import eu.iamgio.customevents.api.Event;
import javafx.scene.input.KeyEvent;

/**
 * Created by Gio on 10/12/2016.
 */
public class KeyPressEvent extends Event
{
    private KeyEvent e;

    public KeyPressEvent(KeyEvent e)
    {
        this.e = e;
    }

    public KeyEvent getKeyEvent()
    {
        return e;
    }
}
