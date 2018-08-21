import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen {

    int xDimension;
    int yDimension;
    Snake snake;
    Food food;

    public Screen(int x, int y) {
        this.xDimension = x;
        this.yDimension = y;
        this.snake = new Snake(x, y);
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

        for (int i = 0; i < 1000; i++) {
            System.out.println();
        }
        for (int i = 0; i < xDimension; i++) {
            System.out.print("/");
        }
        System.out.println();
        for (int x = 0; x < xDimension; x++) {
            for (int y = 0; y < yDimension; y++) {
                if (y == 0 || y == yDimension - 1) {
                    System.out.print("/");
                }

                if (food.getPosition().getX() == x
                        && food.getPosition().getY() == y) {
                    System.out.print("@");
                } else if (snake.getPositions().get(0).getX() == x
                        && snake.getPositions().get(0).getY() == y) {
                    //If position contains snake's head (position 0 of the positions list), print o
                    System.out.print("o");
                } else if (coordinatesInSnake(x, y, false)) {
                    //If position exists into snake's body, print an x
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < xDimension; i++) {
            System.out.print("/");
        }
    }

    public void generateFood() {

        this.food = new Food(this.snake.getPositions(), xDimension, yDimension);

    }

    public boolean coordinatesInSnake(int x, int y, boolean includeHead) {

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

        if (coordinatesInSnake(snake.getPositions().get(0).getX(),
                snake.getPositions().get(0).getY(), false)) {
            //Collision with its own body
            return true;
        } else if (collisionWithWall()) {
            //Collision with a wall
            return true;
        }

        return false;
    }

    private boolean collisionWithWall() {
        if (snake.getPositions().get(0).getX() == xDimension
                || snake.getPositions().get(0).getY() == yDimension - 1
                || snake.getPositions().get(0).getX() == -1
                || snake.getPositions().get(0).getY() == -1) {
            return true;
        } else {
            return false;
        }
    }
}
