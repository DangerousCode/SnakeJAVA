import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends javafx.application.Application {

    private static final String TITLE = "Snake";
    private static final int X_DIMENSION = 600;
    private static final int Y_DIMENSION = 600;
    private static Screen screen;

    @Override
    public void start(Stage primaryStage) {
        try {
            Group group = new Group();
            Scene scene = new Scene(group, X_DIMENSION, Y_DIMENSION);
            primaryStage.setTitle("Snake");
            primaryStage.setScene(scene);
            primaryStage.show();
            boolean winner = false;
            boolean collision = false;
            screen = new Screen(primaryStage);
            screen.generateFood();
            Snake snake = screen.getSnake();

            while (!winner && !collision) {

                screen.drawScr();

                //If snake eats food, generate new food
                boolean foodEaten = snake.moveSnake(screen.getFood());
                if (foodEaten) {
                    screen.setFood(new Food(snake.getPositions(), X_DIMENSION, Y_DIMENSION));
                }
                collision = screen.checkCollision();

            }
            screen.drawScr();
            if (collision) {
                System.out.println("\nYou lose");
            } else {
                System.out.println("\nYou win");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
