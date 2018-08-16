import java.util.List;

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

    public void drawScr() {

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

        this.food = new Food(generateRandomFoodPosition(this.snake.getPositions()));

    }

    //Needed to validate that food is not into snake
    private Position generateRandomFoodPosition(List<Position> notDesiredPositions) {
        int xRandom = (int) (Math.random() * this.xDimension);
        int yRandom = (int) (Math.random() * this.yDimension);
        Position position = new Position(xRandom, yRandom);
        if (!notDesiredPositions.contains(position)) {
            return position;
        } else {
            return generateRandomFoodPosition(notDesiredPositions);
        }
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
        } else if (coordinatesInSnake(xDimension, yDimension, true)) {
            //Collision with a wall
            return true;
        }

        return false;
    }

    public void moveSnake() {

        Position foodPosition = food.getPosition();
        Position headPosition = snake.getPositions().get(0);

        //If y position is closer than x position, move to that direction
        if ((Math.abs(foodPosition.getY() - headPosition.getY())
                == (Math.abs(foodPosition.getX() - headPosition.getX())))) {

            //In this case we need to generate a new random number to move Y or X direction
            double rand = Math.random();

            //If rand is less than 0.5 move X, else, move Y
            if (rand < 0.5) {
                //If the difference between head's x position and food's x position is negative, then move left
                if (foodPosition.getX() - headPosition.getX() < 0) {
                    //Change coordinate of the second position to head's position
                    Position oldPosition1 = headPosition;
                    Position oldPosition2 = snake.getPositions().get(1);
                    headPosition.setX(headPosition.getX() - 1);

                    for (int i = 1; i < snake.getPositions().size(); i++) {

                        snake.getPositions().set(i, oldPosition1);

//                        snake.getPositions().get

                    }

                } else {

                }

            } else {

            }

        } else if ((Math.abs(foodPosition.getY() - headPosition.getY())
                > (Math.abs(foodPosition.getX() - headPosition.getX())))) {

        } else {

        }
    }
}
