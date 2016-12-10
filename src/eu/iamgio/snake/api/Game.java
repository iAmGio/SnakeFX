package eu.iamgio.snake.api;

import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.snake.api.events.Loop;
import eu.iamgio.snake.game.Main;
import eu.iamgio.snake.game.animations.MenuAnimation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Gio on 09/12/2016.
 */
public class Game
{
    private boolean active;

    private Snake snake;
    private Food food;

    private Parent root;

    /**
     * Starts the game
     */
    public void start()
    {
        this.active = true;
        Main.setGame(this);

        snake = new Snake();

        MenuAnimation.getAnimation().stop();

        root = FXML.load(Main.class, "assets/scenes/GameScene.fxml");
        Scene scene = new Scene(root, 1000, 700);
        root.getStylesheets().add("eu/iamgio/snake/game/assets/styles/stylesheets.css");

        Main.stage.setScene(scene);

        food = new Food();
        food.spawnRandomly();
        Loop.LoopManager.start();

        snake.spawn();
    }

    /**
     * Ends the game
     * TODO
     */
    public void end()
    {
        this.active = false;

        root = FXML.load(Main.class, "assets/scenes/MainScene.fxml");
        Scene scene = new Scene(root, 1000, 700);
        root.getStylesheets().add("eu/iamgio/snake/game/assets/styles/stylesheets.css");
        Main.stage.setScene(scene);
        new MenuAnimation().start();
        JavaFX.startDefaultEvents(scene);

        Main.setGame(null);
        Loop.LoopManager.stop();
    }

    /**
     * @return Current snake
     */
    public Snake getSnake()
    {
        return snake;
    }

    /**
     * @return Current food
     */
    public Food getFood()
    {
        return food;
    }

    /**
     * Sets the food
     * @param food Food
     */
    public void setFood(Food food)
    {
        this.food = food;
    }

    /**
     * @return Root
     */
    public Pane getRoot()
    {
        return (Pane) root;
    }
}
