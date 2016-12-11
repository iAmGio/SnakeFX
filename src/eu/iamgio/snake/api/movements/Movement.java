package eu.iamgio.snake.api.movements;

import eu.iamgio.snake.api.Snake;

import java.util.HashMap;

/**
 * Created by Gio on 11/12/2016.
 */
public class Movement
{
    private static HashMap<Double, Double> movements;

    public static class Recorder
    {
        public static void record(Snake snake)
        {
            movements.put(snake.getX(), snake.getY());
        }

        public static void createSession()
        {
            movements = new HashMap<>();
        }
    }

    public static HashMap<Double, Double> getMovements()
    {
        return movements;
    }
}
