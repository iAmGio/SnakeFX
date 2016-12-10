package eu.iamgio.snake.game;

import eu.iamgio.customevents.api.EventManager;
import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.libfx.api.elements.SimpleStage;
import eu.iamgio.snake.api.Game;
import eu.iamgio.snake.game.animations.MenuAnimation;
import eu.iamgio.snake.game.listeners.SnakeListener;
import eu.iamgio.snake.game.listeners.MenuListeners;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Gio on 09/12/2016.
 */
public class Main extends Application
{
    private final String VERSION = "1.0.0a";

    public static Stage stage;

    private static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXML.load(getClass(), "assets/scenes/MainScene.fxml");
        Scene scene = new Scene(root, 1000, 700);

        root.getStylesheets().add("eu/iamgio/snake/game/assets/styles/stylesheets.css");

        SimpleStage simpleStage = new SimpleStage(primaryStage);
        simpleStage.show(scene, "Snake! v" + VERSION, false);

        startEvents(scene);

        new MenuAnimation().start();

        stage = primaryStage;
    }

    public static void main(String...args)
    {
        launch(args);
    }

    public static void startEvents(Scene scene)
    {
        EventManager manager = JavaFX.getEventManager();

        JavaFX.startDefaultEvents(scene);

        manager.registerEvents(new MenuListeners());
        manager.registerEvents(new SnakeListener());
    }

    /**
     * @return The actual game
     */
    public static Game getGame()
    {
        return game;
    }

    /**
     * Sets a new game session
     * @param game Game
     */
    public static void setGame(Game game)
    {
        Main.game = game;
    }
}
