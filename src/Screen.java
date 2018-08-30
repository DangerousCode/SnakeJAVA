import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    Stage stage;
    Snake snake;
    Food food;

    public Screen(Stage stage) {
        this.stage = stage;
        this.snake = new Snake(stage.getWidth(), stage.getHeight());
    }


    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void drawScr() {

        TextFlow snakeBody = new TextFlow();

        for (int i = 0; i<snake.getPositions().size(); i++){
            Position position = snake.getPositions().get(i);
            Text bodyPart = new Text();
            if(i == 0){
                bodyPart.setText("O");
            } else {
                bodyPart.setText("X");
            }
            bodyPart.setX(position.getX());
            bodyPart.setY(position.getY());

            snakeBody.getChildren().add(bodyPart);
        }

        Group group = new Group(snakeBody);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.show();
    }

    public void generateFood() {

        this.food = new Food(this.snake.getPositions(), stage.getWidth(), stage.getHeight());

    }

    public boolean coordinatesInSnake(double x, double y, boolean includeHead) {

        //We need a sublist to compare whole snake or only body.

        for (Position position :
                snake.getPositions().subList(includeHead ? 0 : 1, snake.getPositions().size())) {
            if (position.getX() == x
                    && position.getY() == y) {

                return true;

            }

        }

        return false;

    }

    public boolean checkCollision() {

        if (coordinatesInSnake(snake.getHead().getX(),
                snake.getHead().getY(), false)) {
            //Collision with its own body
            return true;
        } else if (collisionWithWall()) {
            //Collision with a wall
            return true;
        }

        return false;
    }

    private boolean collisionWithWall() {

        Position head = snake.getPositions().get(0);
        if (snake.getHead().getX() == stage.getWidth()
                || snake.getHead().getY() == stage.getHeight()
                || snake.getHead().getX() == 0
                || snake.getHead().getY() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
