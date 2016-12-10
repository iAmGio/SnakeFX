package eu.iamgio.snake.api;

import eu.iamgio.libfx.api.FXML;
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

        new Food().spawnRandomly();
        Loop.LoopManager.start();
    }

    /**
     * Ends the game
     * TODO
     */
    public void end()
    {
        this.active = false;
        Main.setGame(null);
    }

    /**
     * @return Current snake
     */
    public Snake getSnake()
    {
        return snake;
    }

    public Pane getRoot()
    {
        return (Pane) root;
    }
}
