package eu.iamgio.snake.api.events;

import eu.iamgio.customevents.api.Event;
import eu.iamgio.libfx.api.JavaFX;
import javafx.animation.AnimationTimer;

/**
 * Created by Gio on 10/12/2016.
 */
public class Loop extends Event
{
    public static class LoopManager
    {
        private static AnimationTimer timer;

        public static void start()
        {
            new AnimationTimer()
            {
                @Override
                public void handle(long now)
                {
                    JavaFX.getEventManager().callEvent(new Loop());
                    timer = this;
                }
            }.start();
        }

        public static void stop()
        {
            timer.stop();
        }
    }
}
