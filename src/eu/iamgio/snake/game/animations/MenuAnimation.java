package eu.iamgio.snake.game.animations;

import eu.iamgio.libfx.api.JavaFX;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by Gio on 09/12/2016.
 */
public class MenuAnimation
{
    private static MenuAnimation animation;

    private Timeline timeline = new Timeline();

    /**
     * Creates the rectangle animation
     */
    public MenuAnimation()
    {
        Rectangle snake = (Rectangle) JavaFX.fromId("snake_rectangle");

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        KeyValue kv = new KeyValue(snake.xProperty(), 843);
        KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
        timeline.getKeyFrames().add(kf);

        animation = this;
    }

    /**
     * @return This animation
     */
    public static MenuAnimation getAnimation()
    {
        return animation;
    }

    /**
     * Starts the animation
     */
    public void start()
    {
        timeline.play();
    }

    /**
     * Stops the animation
     */
    public void stop()
    {
        timeline.stop();
    }
}
